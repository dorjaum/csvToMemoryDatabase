package hodor.cmd;

import static hodor.cmd.CommandFactory.getCommand;
import static hodor.cmd.CommandFactory.getProperty;
import static hodor.cmd.CommandFactory.getValue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import hodor.cmd.CommandFactory;
import hodor.cmd.property.Property;
import hodor.cmd.property.PropertyInterface;
import hodor.cmd.property.Value;
import hodor.cmd.property.ValueInterface;
import hodor.cmd.sub.CommandAsterisk;
import hodor.cmd.type.CommandCount;
import hodor.cmd.type.CommandFilter;
import hodor.cmd.type.CommandInterface;
import hodor.exception.command.CommandNotExistException;
import hodor.exception.command.PropertyException;
import hodor.exception.command.ValueException;

public class CommandTest extends EnvironmentPreparationTest {

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
