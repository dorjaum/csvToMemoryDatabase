package br.com.jmf.csv;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.csv.type.SeparatorType;
import br.com.jmf.exception.csv.DataCorrupetedException;
import br.com.jmf.exception.csv.HeaderNotFoundException;
import br.com.jmf.exception.csv.MissingFileException;
import br.com.jmf.reader.csv.CsvReader;

public class CsvImporterTest {

	private static final String PATH_TO_CSV = "src/test/resources/files/cities_data.csv";
	private static final String PATH_TO_CSV_WITHOUT_HEADER = "src/test/resources/files/cities_data_without_header.csv";
	private static final String PATH_TO_CSV_CORRUPTED = "src/test/resources/files/cities_data_corrupted.csv";
	private static final String WRONG_PATH_TO_CSV = "src__/test/resources/files/cities_data.csv";
	private static final String CSV_SEPARATOR = SeparatorType.COMMA.getSeparator();
	
	@Test
	public void importDefaultFileSunday() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV).execute();
	}
	
	@Test(expected = MissingFileException.class)
	public void importFileWrongPathRainnyDay() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(WRONG_PATH_TO_CSV).execute();
	}
	
	@Test(expected = DataCorrupetedException.class)
	public void importFileWithCorruptedData() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV_CORRUPTED).execute();
	}
	
	@Test(expected = HeaderNotFoundException.class)
	public void importFileWithoutHeader() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV_WITHOUT_HEADER).execute();
	}
	
	@Test
	public void assertDataFromFile() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV).execute();
			
		List<Map<String, String>> listData = instance.getData();
		Assert.assertEquals(5565, listData.size());
	}
	
	@Test
	public void assertHeaderFromFile() {
		CsvReader csvReader = CsvReader.getInstance();
		csvReader.setCsvSeparator(CSV_SEPARATOR);
		csvReader.setPathToFile(PATH_TO_CSV).execute();
		
		List<String> header = csvReader.getHeader();
		Assert.assertEquals(10, header.size());
	}
	
}
