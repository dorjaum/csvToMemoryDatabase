package br.com.jmf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvImporter {

	private String pathToFile;
	private String csvSeparator;
	private BufferedReader bufferReader;
	private static CsvImporter instance;

	private CsvImporter() {

	}

	public static CsvImporter getInstance() {
		if (instance == null) {
			instance = new CsvImporter();
		}

		return instance;
	}

	public CsvImporter build() {
		try {
			trySetBufferReader();
			tryReadCsvHeader();
			tryReadCsvData();
		} catch (FileNotFoundException e) {
			// explode mine exception here
		} catch (IOException e) {
			// explode mine exception here
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
			} catch (IOException e) {
				e.printStackTrace();
				// minha excessao aqui tentando fechar o arquivo.
			}
		}
	}

	private void tryReadCsvData() throws IOException {
		String line;
		while ((line = getBufferReader().readLine()) != null) {
			String[] data = line.split(getCsvSeparator());
			// create data
		}
	}

	private void tryReadCsvHeader() throws IOException {
		String line;
		line = getBufferReader().readLine();
		// create header
	}

	public String getPathToFile() {
		return pathToFile;
	}

	public CsvImporter setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
		return this;
	}

	public CsvImporter setCsvSeparator(String csvSeparator) {
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

}
