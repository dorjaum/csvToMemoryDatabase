package hodor.cmd;

import org.junit.Before;

import hodor.csv.converter.CsvDatabaseMemoryBuilder;

public class EnvironmentPreparationTest {

	@Before
	public void before() {
		CsvDatabaseMemoryBuilder.execute();
	}
}
