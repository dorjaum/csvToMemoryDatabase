package hodor.csv;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hodor.bean.city.DataBean;
import hodor.bean.city.HeaderBean;
import hodor.csv.converter.CsvDatabaseMemoryBuilder;
import hodor.database.DatabaseMemory;

public class CsvDataConverterTest {
	
	@Before
	public void initializeDatabaseMemory() {
		CsvDatabaseMemoryBuilder csvDatabaseMemoryBuilder = new CsvDatabaseMemoryBuilder();
		csvDatabaseMemoryBuilder.execute();
	}
	
	@Test
	public void convertListHeaderToObject() {
		List<HeaderBean> listCityBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		
		Assert.assertEquals(10, listCityBean.size());
	}
	
	@Test
	public void convertListDataToObject() {
		List<DataBean> listCitiesDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		
		assertEquals(5565, listCitiesDataBean.size());
	}
	
	@Test
	public void convertListDataToObjectAssertFirstLineValues() {
		List<DataBean> listCitiesDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		
		Assert.assertEquals(5565, listCitiesDataBean.size());
		
		List<HeaderBean> citiesHeaderBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		HeaderBean ibgeId = citiesHeaderBean.get(0);
		
		DataBean firstLine = listCitiesDataBean.get(0);
		Assert.assertEquals(1l, firstLine.getIdLine());
		
		String ibgeIDValue = firstLine.getValue(ibgeId);
		assertEquals("1100015", ibgeIDValue);
		
		HeaderBean uf = citiesHeaderBean.get(1);
		String ufValue = firstLine.getValue(uf);
		assertEquals("RO", ufValue);

		HeaderBean name = citiesHeaderBean.get(2);
		String nameValue = firstLine.getValue(name);
		assertEquals("Alta Floresta D'Oeste", nameValue);

		HeaderBean capital = citiesHeaderBean.get(3);
		String capitalValue = firstLine.getValue(capital);
		assertEquals("", capitalValue);
		
		HeaderBean lon = citiesHeaderBean.get(4);
		String lonValue = firstLine.getValue(lon);
		assertEquals("-61.9998238963", lonValue);
		
		HeaderBean lat = citiesHeaderBean.get(5);
		String latValue = firstLine.getValue(lat);
		assertEquals("-11.9355403048", latValue);
		
		HeaderBean noAccents = citiesHeaderBean.get(6);
		String noAccentsValue = firstLine.getValue(noAccents);
		assertEquals("Alta Floresta D'Oeste", noAccentsValue);
		
		HeaderBean alternativeName = citiesHeaderBean.get(7);
		String alternativeNameValue = firstLine.getValue(alternativeName);
		assertEquals("", alternativeNameValue);
		
		HeaderBean microRegion = citiesHeaderBean.get(8);
		String microRegionValue = firstLine.getValue(microRegion);
		assertEquals("Cacoal", microRegionValue);
		
		HeaderBean mesoregion = citiesHeaderBean.get(9);
		String mesoregionValue = firstLine.getValue(mesoregion);
		assertEquals("Leste Rondoniense", mesoregionValue);
		
	}
	
}
