package br.com.jmf.cmd;

import org.junit.Before;

import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;

public class EnvironmentPreparationTest {

	@Before
	public void before() {
		CsvDatabaseMemoryBuilder.execute();
	}
}
