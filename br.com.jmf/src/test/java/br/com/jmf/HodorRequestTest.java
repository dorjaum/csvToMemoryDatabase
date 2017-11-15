package br.com.jmf;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.jmf.bean.city.CityDataBean;

public class HodorRequestTest {

	@Test
	public void countAsterisk() {
		HodorRequest hodor = HodorRequest.getInstance();
		hodor.execute("count *");
		List<CityDataBean> listCityDataBean = hodor.getResult();
		Assert.assertEquals(5565, listCityDataBean.size());
	}
}
