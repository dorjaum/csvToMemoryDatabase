package br.com.jmf.cmd;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.cmd.type.CommandInterface;
import br.com.jmf.exception.command.CommandFilterException;

public class CommandFilterTest extends EnvironmentPreparationTest{

	private static final String CMD_FILTER = "filter";
	private static final String PROP_UF = "uf";
	private static final String VAL_RO = "RO";
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
	public void filterWithPropertyUfEqualsRo() {
		ArrayList<String> listCommand = new ArrayList<String>();
		listCommand.add(CMD_FILTER);
		listCommand.add(PROP_UF);
		listCommand.add(VAL_DF);
		CommandInterface command = CommandFactory.getCommand(listCommand);
		
		StringBuilder resultAsJson = new StringBuilder();
		resultAsJson.append(" [ibge_id:5300108, uf:df, capital:Brasília, capital:true, lon:-47.887905478, ");
		resultAsJson.append("lat:-15.7940873619 ,no_accents:Brasilia ,alternative_names: ,microregion:Brasília ,mesoregion:Distrito Federal]");
		
		Assert.assertEquals(resultAsJson.toString(), command.getResult());
	}
}
