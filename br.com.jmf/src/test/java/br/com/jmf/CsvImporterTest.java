package br.com.jmf;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.csv.exception.DataCorrupetedException;
import br.com.jmf.csv.exception.HeaderNotFoundException;
import br.com.jmf.csv.exception.MissingFileException;
import br.com.jmf.reader.csv.CsvReader;

public class CsvImporterTest {

	private static final String PATH_TO_CSV = "src/test/resources/files/cities_data.csv";
	private static final String PATH_TO_CSV_WITHOUT_HEADER = "src/test/resources/files/cities_data_without_header.csv";
	private static final String PATH_TO_CSV_CORRUPTED = "src/test/resources/files/cities_data_corrupted.csv";
	private static final String WRONG_PATH_TO_CSV = "src__/test/resources/files/cities_data.csv";
	private static final String CSV_SEPARATOR = ",";
	
	@Test
	public void importDefaultFileSunday() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV).build();
	}
	
	@Test(expected = MissingFileException.class)
	public void importFileWrongPathRainnyDay() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(WRONG_PATH_TO_CSV).build();
	}
	
	@Test(expected = DataCorrupetedException.class)
	public void importFileWithCorruptedData() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV_CORRUPTED).build();
	}
	
	@Test(expected = HeaderNotFoundException.class)
	public void importFileWithoutHeader() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV_WITHOUT_HEADER).build();
	}
	
	@Test
	public void assertDataFromFile() {
		CsvReader instance = CsvReader.getInstance();
		instance.setCsvSeparator(CSV_SEPARATOR);
		instance.setPathToFile(PATH_TO_CSV).build();
			
		List<Map<String, String>> listData = instance.getData();
		Assert.assertEquals(5565, listData.size());
	}
	
	@Test
	public void assertHeaderFromFile() {
		CsvReader csvReader = CsvReader.getInstance();
		csvReader.setCsvSeparator(CSV_SEPARATOR);
		csvReader.setPathToFile(PATH_TO_CSV).build();
		
		List<String> header = csvReader.getHeader();
		Assert.assertEquals(10, header.size());
	}
	
}
