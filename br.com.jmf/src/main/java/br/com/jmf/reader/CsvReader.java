package br.com.jmf.reader;

import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.jmf.exception.DataCorrupetedException;

public class CsvReader implements FileReaderInterface{

	private static final String MSG_FILE_CLOSED_WITH_SUCCESS = "File closed with success.";
	private static final String MSG_PROBLEM_WHILE_TRYING_TO_CLOSE_FILE = "Problem while trying to close file.";
	private static final String MSG_PROBLEM_READING_YOUR_FILE = "Problem reading your file.";
	private static final String MSG_FILE_NOT_FOUND = "File Not Found, check your path.";
	private static final String ERROR_MSG_DATA_CORRUPTED_AT_LINE = "Data corrupted at line %s";
	
	private String pathToFile;
	private String csvSeparator;
	private BufferedReader bufferReader;
	private ArrayList<String> header ;
	private ArrayList<Map<String, String>> data;
	private static CsvReader instance;
	
	private Logger LOGGER = Logger.getLogger(CsvReader.class.getName());
	
	private CsvReader() {
		header = new ArrayList<String>();
		data = new ArrayList<Map<String, String>>();
	}

	public static CsvReader getInstance() {
		if (instance == null) {
			instance = new CsvReader();
		}

		return instance;
	}

	public CsvReader build() {
		try {
			trySetBufferReader();
			tryReadCsvHeader();
			tryReadCsvData();
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.SEVERE, MSG_FILE_NOT_FOUND, e);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, MSG_PROBLEM_READING_YOUR_FILE, e);
		} finally {
			tryCloseCsvFile();
		}

		return this;
	}

	private void trySetBufferReader() throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(getPathToFile()));
		setBufferReader(bufferedReader);
	}

	private void tryCloseCsvFile() {
		if (getBufferReader() != null) {
			try {
				getBufferReader().close();
				LOGGER.log(Level.INFO, MSG_FILE_CLOSED_WITH_SUCCESS);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, MSG_PROBLEM_WHILE_TRYING_TO_CLOSE_FILE, e);
			}
		}
	}

	private void tryReadCsvData() throws IOException {
		String line;
		Integer linePosition = 1;
		ArrayList<Map<String, String>> listMappedData = new ArrayList<Map<String, String>>();
		Map<String, String> fieldValue = null;
		
		while ((line = getBufferReader().readLine()) != null) {
			String[] splitedLine = line.split(getCsvSeparator());
			validateSplitedLine(splitedLine, linePosition);
			
			fieldValue = createMappedDataHeader(splitedLine);
			listMappedData.add(fieldValue);
			linePosition++;
		}
		
		setData(listMappedData);
	}

	private Map<String, String> createMappedDataHeader(String[] splitedData) {
		String field;
		String dataAtPosition;
		Map<String, String> fieldValue;
		fieldValue = new HashMap<String, String>();

		for(int position = 0; position < splitedData.length; position++) {
			field = getHeader().get(position);
			dataAtPosition = splitedData[position];
			fieldValue.put(field, dataAtPosition);
		}
		return fieldValue;
	}

	private void validateSplitedLine(String[] splitedLine, Integer linePosition) {
		if(splitedLine.length != getHeader().size())
			throw new DataCorrupetedException(format(ERROR_MSG_DATA_CORRUPTED_AT_LINE, linePosition));
		
	}

	private void tryReadCsvHeader() throws IOException {
		String line = getBufferReader().readLine();
		String[] splitHeader = line.split(getCsvSeparator());
		for (String field : splitHeader) {
			getHeader().add(field);
		}
	}

	public String getPathToFile() {
		return pathToFile;
	}

	public CsvReader setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
		return this;
	}

	public CsvReader setCsvSeparator(String csvSeparator) {
		this.csvSeparator = csvSeparator;
		return this;
	}

	public String getCsvSeparator() {
		return csvSeparator;
	}

	public BufferedReader getBufferReader() {
		return bufferReader;
	}

	public void setBufferReader(BufferedReader bufferReader) {
		this.bufferReader = bufferReader;
	}

	public List<String> getHeader() {
		return header;
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	private void setHeader(ArrayList<String> header) {
		this.header = header;
	}
	
	private void setData(ArrayList<Map<String, String>> data) {
		this.data = data;
	}

}
