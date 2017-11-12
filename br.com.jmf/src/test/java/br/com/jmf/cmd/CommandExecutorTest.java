package br.com.jmf.cmd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;
import br.com.jmf.exception.command.CommandNotExistException;

public class CommandExecutorTest {

	@Before
	public void prepareDatabaseMemory() {
		CsvDatabaseMemoryBuilder.build();
	}
	
	@Test
	public void countRegisters() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInterface commandCount = commandFactory.getCommand("count *");
		
		String totalRegisters = commandCount.getResult();
		
		Assert.assertTrue("5565".equals(totalRegisters));
	}
	
	@Test(expected = CommandNotExistException.class)
	public void commandNotExist() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInterface commandCount = commandFactory.getCommand("");
	}
}
