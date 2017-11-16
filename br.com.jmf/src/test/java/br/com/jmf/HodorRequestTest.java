package br.com.jmf;

import static java.lang.String.format;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.cmd.type.CommandCount;
import br.com.jmf.exception.command.CommandNotExistException;

public class HodorRequestTest {
	
	@Test
	public void countAsterisk() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count *");
		String result = hodor.getResult();

		Assert.assertEquals(format(CommandCount.PREFIX_RESPONSE_COUNTED_TOTAL_OF, "5565"), result);
	}
	
	@Test
	public void countDistinctPropertyIbgeId() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count distinct ibge_id");
		String result = hodor.getResult();
		
		Assert.assertEquals(format(CommandCount.PREFIX_RESPONSE_COUNTED_TOTAL_OF, "5565"), result);
	}
	
	@Test
	public void countDistinctPropertyUf() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count distinct uf");
		String result = hodor.getResult();
		
		Assert.assertEquals(format(CommandCount.PREFIX_RESPONSE_COUNTED_TOTAL_OF, "27") , result);
	}
	
	@Test
	public void countDistinctPropertyAlternativeNames() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count distinct alternative_names");
		String result = hodor.getResult();
		
		Assert.assertEquals(format(CommandCount.PREFIX_RESPONSE_COUNTED_TOTAL_OF, "4") , result);
	}
	
	@Test(expected = CommandNotExistException.class)
	public void countWithNotVaidSubCommand() {
		HodorRequest.getInstance().execute("count dis uf");
	}
	
	@Test(expected = CommandNotExistException.class)
	public void countOnly() {
		HodorRequest.getInstance().execute("count");
	}
	
	@Test(expected = CommandNotExistException.class)
	public void wrongCountCommand() {
		HodorRequest.getInstance().execute("cunt");
	}
}
