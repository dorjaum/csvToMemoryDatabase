package hodor.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hodor.bean.city.DataBean;
import hodor.bean.city.HeaderBean;
import hodor.database.DatabaseMemory;
import hodor.reader.FileReaderInterface;
import hodor.reader.csv.CsvReader;

public abstract class DatabaseMemoryBuilder implements DatabaseMemoryBuilderInterface{

	protected static FileReaderInterface reader = CsvReader.getInstance();
	
	protected static void fillListCityHeaderBean() {
		List<String> listHeader = reader.getHeader();
		ArrayList<HeaderBean> listCityHeaderBean = new ArrayList<HeaderBean>();
		for (String headerName : listHeader) {
			listCityHeaderBean.add(new HeaderBean(headerName));
		}
		
		DatabaseMemory.getInstance().setListCityHeaderBean(listCityHeaderBean);
	}

	protected static void fillListCityDataBean() {
		List<Map<String, String>> listDataMap = reader.getData();
		DataBean cityDataBean = null;
		long idLine = 1L;
		ArrayList<DataBean> listCityDataBean = new ArrayList<DataBean>();
		
		for (Map<String, String> dataMap : listDataMap) {
			cityDataBean = new DataBean(dataMap);
			cityDataBean.setIdLine(idLine++);
			listCityDataBean.add(cityDataBean);
		}
		
		DatabaseMemory.getInstance().setListCityDataBean(listCityDataBean);
	}
}
