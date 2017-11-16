package hodor.cmd;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import hodor.cmd.CommandFactory;
import hodor.cmd.type.CommandInterface;
import hodor.exception.command.CommandFilterException;

public class CommandFilterTest extends EnvironmentPreparationTest{

	private static final String CMD_FILTER = "filter";
	private static final String PROP_UF = "uf";
	private static final String VAL_DF = "DF";

	@Test(expected = CommandFilterException.class)
	public void filterWithoutProperty() {
		ArrayList<String> listCommand = new ArrayList<String>();
		
		CommandFactory.getCommand(CMD_FILTER, listCommand);
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
}
