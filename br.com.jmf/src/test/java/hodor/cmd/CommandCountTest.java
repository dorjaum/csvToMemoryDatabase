package hodor.cmd;

import static hodor.cmd.CommandFactory.getCommand;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import hodor.cmd.sub.CommandAsterisk;
import hodor.cmd.sub.CommandDistinct;
import hodor.cmd.type.CommandCount;
import hodor.cmd.type.CommandInterface;

public class CommandCountTest extends EnvironmentPreparationTest{

	@Test
	public void countAsteristik() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CommandCount.CMD_COUNT);
		listCommand.add(CommandAsterisk.CMD_ASTERISK);
		CommandInterface commandCount = getCommand(listCommand);
		
		Assert.assertEquals(String.format(CommandCount.PREFIX_RESPONSE_COUNTED_TOTAL_OF, "5565"), commandCount.getResult());
	}
	
	@Test
	public void countDistinctUf() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CommandCount.CMD_COUNT);
		listCommand.add(CommandDistinct.CMD_DISTINCT);
		listCommand.add(PROP_UF);
		CommandInterface commandCount = getCommand(listCommand);

		Assert.assertEquals(String.format(CommandCount.PREFIX_RESPONSE_COUNTED_TOTAL_OF, "27"), commandCount.getResult());
	}
}
