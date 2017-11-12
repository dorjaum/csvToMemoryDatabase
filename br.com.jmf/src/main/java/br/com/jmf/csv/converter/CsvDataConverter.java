package br.com.jmf.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.bean.city.CityHeaderBean;
import br.com.jmf.csv.type.SeparatorType;
import br.com.jmf.reader.FileReaderInterface;
import br.com.jmf.reader.csv.CsvReader;

public class CsvDataConverter {

	private static final String SEPARATOR = SeparatorType.COMMA.getSeparator();
	private static final String PATH_TO_CSV_FILE = "src/test/resources/files/cities_data.csv";
	
	private FileReaderInterface csvReader = CsvReader.getInstance();
	private ArrayList<CityHeaderBean> listCityHeaderBean;
	private ArrayList<CityDataBean> listCityDataBean;
	
	public CsvDataConverter() {
		setListCityHeaderBean(new ArrayList<CityHeaderBean>());
		setListCityDataBean(new ArrayList<CityDataBean>());
		((CsvReader) getCsvReader()).setCsvSeparator(SEPARATOR);
		getCsvReader().setPathToFile(PATH_TO_CSV_FILE).build();
	}
	
	public CsvDataConverter(String pathToFile, SeparatorType separator) {
		getCsvReader().setPathToFile(pathToFile);
		((CsvReader) getCsvReader()).setCsvSeparator(separator.getSeparator());
		setListCityHeaderBean(new ArrayList<CityHeaderBean>());
		setListCityDataBean(new ArrayList<CityDataBean>());
	}

	public FileReaderInterface getCsvReader() {
		return csvReader;
	}

	public List<CityHeaderBean> getCitiesHeaderBean() {
		if(listCityHeaderBean.isEmpty()) {
			fillListCityHeaderBean();
		}
		
		return listCityHeaderBean;
	}

	private void fillListCityHeaderBean() {
		List<String> listHeader = getCsvReader().getHeader();
		for (String headerName : listHeader) {
			listCityHeaderBean.add(new CityHeaderBean(headerName));
		}
	}

	public List<CityHeaderBean> getListCityHeaderBean() {
		return listCityHeaderBean;
	}

	private void setListCityHeaderBean(ArrayList<CityHeaderBean> listCityHeaderBean) {
		this.listCityHeaderBean = listCityHeaderBean;
	}

	public List<CityDataBean> getCitiesDataBean() {
		if(listCityDataBean.isEmpty()) {
			fillListCityDataBean();
		}
		
		return listCityDataBean;
	}

	private void fillListCityDataBean() {
		List<Map<String, String>> listDataMap = getCsvReader().getData();
		CityDataBean cityDataBean = null;
		long idLine = 1L;
		
		for (Map<String, String> dataMap : listDataMap) {
			cityDataBean = new CityDataBean(dataMap);
			cityDataBean.setIdLine(idLine++);
			listCityDataBean.add(cityDataBean);
		}
	}

	public ArrayList<CityDataBean> getListCityDataBean() {
		return listCityDataBean;
	}

	private void setListCityDataBean(ArrayList<CityDataBean> listCityDataBean) {
		this.listCityDataBean = listCityDataBean;
	}
	
}
