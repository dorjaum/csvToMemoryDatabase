package br.com.jmf.cmd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;

public class CommandExecutorTest {

	@Before
	public void prepareDatabaseMemory() {
		CsvDatabaseMemoryBuilder.build();
	}
	
	@Test
	public void countRegisters() {
		CommandExecutor commandExecutor = new CommandExecutor();
		long totalRegisters = commandExecutor.count();
		
		Assert.assertEquals(5565, totalRegisters);
	}
}
