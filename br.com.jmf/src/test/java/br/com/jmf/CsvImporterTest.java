package br.com.jmf;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.jmf.exception.DataCorrupetedException;
import br.com.jmf.exception.HeaderNotFoundException;
import br.com.jmf.exception.MissingFileException;
import br.com.jmf.exception.ReadingFileException;
import br.com.jmf.reader.CsvReader;

public class CsvImporterTest {

	private static final String PATH_TO_CSV = "src/test/resources/files/cities_data.csv";
	private static final String PATH_TO_CSV_WITHOUT_HEADER = "src/test/resources/files/cities_data_without_header.csv";
	private static final String PATH_TO_CSV_IO_PROBLEM = "src/test/resources/files/cities_data_corrupted_io_problem.csv";
	private static final String PATH_TO_CSV_CORRUPTED = "src/test/resources/files/cities_data_corrupted.csv";
	private static final String WRONG_PATH_TO_CSV = "src__/test/resources/files/cities_data.csv";
	private static final String CSV_SEPARATOR = ",";
	
	@Test
	public void importDefaultFileSunday() {
		CsvReader
			.getInstance()
			.setPathToFile(PATH_TO_CSV)
			.setCsvSeparator(CSV_SEPARATOR)
			.build();
	}
	
	@Test(expected = MissingFileException.class)
	public void importFileWrongPathRainnyDay() {
		CsvReader
		.getInstance()
		.setPathToFile(WRONG_PATH_TO_CSV)
		.setCsvSeparator(CSV_SEPARATOR)
		.build();
	}
	
	@Test(expected = DataCorrupetedException.class)
	public void importFileWithCorruptedData() {
		CsvReader
		.getInstance()
		.setPathToFile(PATH_TO_CSV_CORRUPTED)
		.setCsvSeparator(CSV_SEPARATOR)
		.build();
	}
	
	@Test(expected = HeaderNotFoundException.class)
	public void importFileWithoutHeader() {
		CsvReader
		.getInstance()
		.setPathToFile(PATH_TO_CSV_WITHOUT_HEADER)
		.setCsvSeparator(CSV_SEPARATOR)
		.build();
	}
	
	@Test
	public void assertDataFromFile() {
			CsvReader csvReader = CsvReader
				.getInstance()
				.setPathToFile(PATH_TO_CSV)
				.setCsvSeparator(CSV_SEPARATOR)
				.build();
			
			List<Map<String, String>> listData = csvReader.getData();

			Assert.assertEquals(5565, listData.size());
	}
	
	@Test
	public void assertHeaderFromFile() {
		CsvReader csvReader = CsvReader
				.getInstance()
				.setPathToFile(PATH_TO_CSV)
				.setCsvSeparator(CSV_SEPARATOR)
				.build();
		
		List<String> header = csvReader.getHeader();
		Assert.assertEquals(header.size(), 10);
	}
	
}
