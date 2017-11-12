package br.com.jmf.cmd;

import org.junit.Assert;
import org.junit.Test;

public class CommandExecutorTest {

	@Test
	public void countRegisters() {
		CommandExecutor commandExecutor = new CommandExecutor();
		long totalRegisters = commandExecutor.count();
		
		Assert.assertEquals(5565, totalRegisters);
	}
}
