package hodor.cmd;

import static hodor.cmd.CommandFactory.getSubCommand;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import hodor.cmd.CommandFactory;
import hodor.cmd.sub.CommandAsterisk;
import hodor.cmd.sub.CommandDistinct;
import hodor.cmd.sub.SubCommandInterface;
import hodor.exception.command.CommandNotExistException;

public class SubCommandTest extends EnvironmentPreparationTest{

	
	@Test(expected = CommandNotExistException.class)
	public void commandNotExistEmptyString() {
		getSubCommand("", new ArrayList<String>());
	}
	
	@Test(expected = CommandNotExistException.class)
	public void commandNotExistNullString() {
		getSubCommand(null, new ArrayList<String>());
	}
	
	@Test
	public void subCommandDistinct() {
		ArrayList<String> listProperty = new ArrayList<String>();
		listProperty.add("ibge_id");
		
		SubCommandInterface distinct = getSubCommand("distinct", listProperty);
		Assert.assertTrue(distinct instanceof CommandDistinct);
	}
	
	@Test
	public void subCommandAsterisk() {
		SubCommandInterface distinct = CommandFactory.getSubCommand("*", new ArrayList<String>());
		Assert.assertTrue(distinct instanceof CommandAsterisk);
	}
}
