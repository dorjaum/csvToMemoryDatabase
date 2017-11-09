package br.com.jmf;

import org.junit.Test;

import br.com.jmf.reader.CsvReader;

public class CsvImporterTest {

	private static final String PATH_TO_CSV = "src/test/resources/cities_data.csv";
	private static final String CSV_SEPARATOR = ",";
	
	@Test
	public void importDefaultFileSunday() {
		CsvReader
			.getInstance()
			.setPathToFile(PATH_TO_CSV)
			.setCsvSeparator(CSV_SEPARATOR)
			.build();
	}
}
