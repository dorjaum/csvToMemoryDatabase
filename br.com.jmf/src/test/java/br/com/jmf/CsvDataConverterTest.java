package br.com.jmf;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.bean.city.CityHeaderBean;
import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;
import br.com.jmf.database.DatabaseMemory;

public class CsvDataConverterTest {
	
	@Before
	public void initializeDatabaseMemory() {
		CsvDatabaseMemoryBuilder.build();
	}
	
	@Test
	public void convertListHeaderToObject() {
		List<CityHeaderBean> listCityBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		
		Assert.assertEquals(10, listCityBean.size());
	}
	
	@Test
	public void convertListDataToObject() {
		List<CityDataBean> listCitiesDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		
		assertEquals(5565, listCitiesDataBean.size());
	}
	
	@Test
	public void convertListDataToObjectAssertFirstLineValues() {
		List<CityDataBean> listCitiesDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		
		Assert.assertEquals(5565, listCitiesDataBean.size());
		
		List<CityHeaderBean> citiesHeaderBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		CityHeaderBean ibgeId = citiesHeaderBean.get(0);
		
		CityDataBean firstLine = listCitiesDataBean.get(0);
		Assert.assertEquals(1l, firstLine.getIdLine());
		
		String ibgeIDValue = firstLine.getValue(ibgeId);
		assertEquals("1100015", ibgeIDValue);
		
		CityHeaderBean uf = citiesHeaderBean.get(1);
		String ufValue = firstLine.getValue(uf);
		assertEquals("RO", ufValue);

		CityHeaderBean name = citiesHeaderBean.get(2);
		String nameValue = firstLine.getValue(name);
		assertEquals("Alta Floresta D'Oeste", nameValue);

		CityHeaderBean capital = citiesHeaderBean.get(3);
		String capitalValue = firstLine.getValue(capital);
		assertEquals("", capitalValue);
		
		CityHeaderBean lon = citiesHeaderBean.get(4);
		String lonValue = firstLine.getValue(lon);
		assertEquals("-61.9998238963", lonValue);
		
		CityHeaderBean lat = citiesHeaderBean.get(5);
		String latValue = firstLine.getValue(lat);
		assertEquals("-11.9355403048", latValue);
		
		CityHeaderBean noAccents = citiesHeaderBean.get(6);
		String noAccentsValue = firstLine.getValue(noAccents);
		assertEquals("Alta Floresta D'Oeste", noAccentsValue);
		
		CityHeaderBean alternativeName = citiesHeaderBean.get(7);
		String alternativeNameValue = firstLine.getValue(alternativeName);
		assertEquals("", alternativeNameValue);
		
		CityHeaderBean microRegion = citiesHeaderBean.get(8);
		String microRegionValue = firstLine.getValue(microRegion);
		assertEquals("Cacoal", microRegionValue);
		
		CityHeaderBean mesoregion = citiesHeaderBean.get(9);
		String mesoregionValue = firstLine.getValue(mesoregion);
		assertEquals("Leste Rondoniense", mesoregionValue);
		
	}
	
}
