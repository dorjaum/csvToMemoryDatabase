package br.com.jmf.cmd;

import static br.com.jmf.cmd.CommandFactory.getSubCommand;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.cmd.sub.CommandAsterisk;
import br.com.jmf.cmd.sub.CommandDistinct;
import br.com.jmf.cmd.sub.SubCommandInterface;
import br.com.jmf.exception.command.CommandNotExistException;

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
