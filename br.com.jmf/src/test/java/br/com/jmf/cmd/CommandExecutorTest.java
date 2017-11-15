package br.com.jmf.cmd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jmf.cmd.property.Property;
import br.com.jmf.cmd.property.Value;
import br.com.jmf.cmd.type.CommandCount;
import br.com.jmf.cmd.type.CommandDistinct;
import br.com.jmf.cmd.type.CommandFilter;
import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;
import br.com.jmf.exception.command.CommandNotExistException;
import br.com.jmf.exception.command.PropertyException;
import br.com.jmf.exception.command.ValueException;

public class CommandExecutorTest {

	private CommandFactory commandFactory;
	
	@Before
	public void prepareDatabaseMemory() {
		CsvDatabaseMemoryBuilder.build();
		commandFactory = new CommandFactory();
	}
	
	@Test
	public void countRegisters() {
		CommandInterface commandCount = commandFactory.getCommand("count");
		Assert.assertTrue(commandCount instanceof CommandCount);
	}
	
	@Test(expected = CommandNotExistException.class)
	public void commandNotExist() {
		commandFactory.getCommand("");
	}
	
	@Test
	public void commandDistinct() {
		CommandInterface distinct = commandFactory.getCommand("distinct");
		Assert.assertTrue(distinct instanceof CommandDistinct);
	}
	
	@Test
	public void commandFilter() {
		CommandInterface filter = commandFactory.getCommand("filter");
		Assert.assertTrue(filter instanceof CommandFilter);
	}
	
	@Test(expected = PropertyException.class)
	public void generateEmptyProperty() {
		Property property = commandFactory.getProperty("");
		Assert.assertTrue(property instanceof Property);
	}
	
	@Test(expected = ValueException.class)
	public void generateEmptyValue() {
		Value value = commandFactory.getValue("");
		Assert.assertTrue(value instanceof Value);
	}
}
