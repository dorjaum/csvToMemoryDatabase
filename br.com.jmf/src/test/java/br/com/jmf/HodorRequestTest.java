package br.com.jmf;

import org.junit.Assert;
import org.junit.Test;

public class HodorRequestTest {

	@Test
	public void countAsterisk() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count *");
		String result = hodor.getResult();

		Assert.assertEquals("5565", result);
	}
	
	@Test
	public void countDistinctPropertyIbgeId() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count distinct ibge_id");
		String result = hodor.getResult();
		
		Assert.assertEquals("5565", result);
	}
}
