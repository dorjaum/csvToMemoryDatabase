package br.com.jmf;

import org.junit.Test;

public class CsvImporterTest {

	private static final String PATH_TO_CSV = "";
	private static final String CSV_SEPARATOR = ",";
	
	@Test
	public void importDefaultFileSunday() {
		CsvImporter
			.getInstance()
			.setPathToFile(PATH_TO_CSV)
			.setCsvSeparator(CSV_SEPARATOR)
			.build();
	}
}
