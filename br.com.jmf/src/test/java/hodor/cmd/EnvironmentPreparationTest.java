package hodor.cmd;

import org.junit.Before;

import hodor.csv.converter.CsvDatabaseMemoryBuilder;

public class EnvironmentPreparationTest {

	protected static final String CMD_FILTER = "filter";
	protected static final String VALUE_12345 = "12345";
	protected static final String PROP_IBGE_ID = "ibge_id";
	protected static final String NO_RESULTS = "No results.";
	protected static final String PROP_UF = "uf";
	protected static final String VAL_DF = "DF";
	protected static final String VAL_NOT_EXIST = "HODOR";
	
	@Before
	public void before() {
		CsvDatabaseMemoryBuilder csvDatabaseMemoryBuilder = new CsvDatabaseMemoryBuilder();
		csvDatabaseMemoryBuilder.execute();
	}
}
