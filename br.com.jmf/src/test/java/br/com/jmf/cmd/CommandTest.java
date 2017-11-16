package br.com.jmf.cmd;

import static br.com.jmf.cmd.CommandFactory.getCommand;
import static br.com.jmf.cmd.CommandFactory.getProperty;
import static br.com.jmf.cmd.CommandFactory.getValue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.cmd.property.Property;
import br.com.jmf.cmd.property.PropertyInterface;
import br.com.jmf.cmd.property.Value;
import br.com.jmf.cmd.property.ValueInterface;
import br.com.jmf.cmd.sub.CommandAsterisk;
import br.com.jmf.cmd.type.CommandCount;
import br.com.jmf.cmd.type.CommandFilter;
import br.com.jmf.cmd.type.CommandInterface;
import br.com.jmf.exception.command.CommandNotExistException;
import br.com.jmf.exception.command.PropertyException;
import br.com.jmf.exception.command.ValueException;

public class CommandTest extends EnvironmentPreparationTest {

	private static final String CMD_FILTER = "filter";
	private static final String VALUE_12345 = "12345";
	private static final String PROP_IBGE_ID = "ibge_id";

	@Test
	public void countInstance() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CommandCount.CMD_COUNT);
		listCommand.add(CommandAsterisk.CMD_ASTERISK);

		CommandInterface commandCount = getCommand(listCommand);
		Assert.assertTrue(commandCount instanceof CommandCount);
	}

	@Test(expected = CommandNotExistException.class)
	public void commandNotExistEmptyString() {
		getCommand("", new ArrayList<String>());
	}

	@Test(expected = CommandNotExistException.class)
	public void commandNotExistNullString() {
		getCommand(null, new ArrayList<String>());
	}

	@Test
	public void commandFilter() {
		ArrayList<String> subCommand = new ArrayList<String>();
		subCommand.add(PROP_IBGE_ID);
		subCommand.add(VALUE_12345);
		CommandInterface filter = getCommand(CMD_FILTER, subCommand);
		Assert.assertTrue(filter instanceof CommandFilter);
	}

	@Test(expected = PropertyException.class)
	public void generateEmptyProperty() {
		CommandFactory.getProperty("", "");
	}

	@Test
	public void generateProperty() {
		PropertyInterface property = getProperty(PROP_IBGE_ID, "");
		Assert.assertTrue(property instanceof Property);
	}

	@Test(expected = ValueException.class)
	public void generateEmptyValue() {
		CommandFactory.getValue("");
	}

	@Test
	public void generateValue() {
		ValueInterface value = getValue(VALUE_12345);
		Assert.assertTrue(value instanceof Value);
	}
}
