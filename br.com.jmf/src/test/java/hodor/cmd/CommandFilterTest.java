package hodor.cmd;

import static hodor.cmd.CommandFactory.getCommand;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import hodor.cmd.CommandFactory;
import hodor.cmd.type.CommandFilter;
import hodor.cmd.type.CommandInterface;
import hodor.exception.command.CommandFilterException;

public class CommandFilterTest extends EnvironmentPreparationTest{

	@Test(expected = CommandFilterException.class)
	public void filterWithoutProperty() {
		ArrayList<String> listCommand = new ArrayList<String>();
		
		CommandFactory.getCommand(CMD_FILTER, listCommand);
	}

	@Test
	public void commandFilter() {
		ArrayList<String> subCommand = new ArrayList<String>();
		subCommand.add(PROP_IBGE_ID);
		subCommand.add(VALUE_12345);
		CommandInterface filter = getCommand(CMD_FILTER, subCommand);
		Assert.assertTrue(filter instanceof CommandFilter);
	}
	
	@Test(expected = CommandFilterException.class)
	public void filterWithPropertyUfWithoutValue() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CMD_FILTER);
		listCommand.add(PROP_UF);
		
		CommandInterface command = CommandFactory.getCommand(listCommand);
		Assert.assertEquals("[]", command.getResult());
	}
	
	@Test
	public void filterWithPropertyUfEqualsDF() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CMD_FILTER);
		listCommand.add(PROP_UF);
		listCommand.add(VAL_DF);
		CommandInterface command = CommandFactory.getCommand(listCommand);
		
		StringBuilder resultAsJson = new StringBuilder();
		resultAsJson.append("[ line: 5565, microregion:Brasília, uf:DF, capital:true, no_accents:Brasilia, ");
		resultAsJson.append("ibge_id:5300108, name:Brasília, lon:-47.887905478, alternative_names:, lat:-15.7940873619, ");
		resultAsJson.append("mesoregion:Distrito Federal ]\n"); 
		
		Assert.assertEquals(resultAsJson.toString(), command.getResult());
	}
	
	@Test
	public void filterWithPropertyMesoregionThatNotExist() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CMD_FILTER);
		listCommand.add(PROP_UF);
		listCommand.add(VAL_NOT_EXIST);
		CommandInterface command = CommandFactory.getCommand(listCommand);
		
		StringBuilder resultAsJson = new StringBuilder();
		resultAsJson.append(NO_RESULTS);
		
		Assert.assertEquals(resultAsJson.toString(), command.getResult());
	}
}
