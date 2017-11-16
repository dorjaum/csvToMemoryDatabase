package hodor.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hodor.bean.city.CityDataBean;
import hodor.bean.city.CityHeaderBean;
import hodor.csv.type.SeparatorType;
import hodor.database.DatabaseMemory;
import hodor.reader.FileReaderInterface;
import hodor.reader.csv.CsvReader;

public class CsvDatabaseMemoryBuilder {

	private static final String SEPARATOR = SeparatorType.COMMA.getSeparator();
	private static final String PATH_TO_CSV_FILE = "src/test/resources/files/cities_data.csv";
	
	private static FileReaderInterface csvReader = CsvReader.getInstance();
	
	private CsvDatabaseMemoryBuilder() {}
	
	public static void execute(String pathToFile, SeparatorType separator) {
		csvReader.setPathToFile(pathToFile);
		((CsvReader) csvReader).setCsvSeparator(separator.getSeparator());
		csvReader.execute();
		fillListCityHeaderBean();
		fillListCityDataBean();
	}
	
	public static void execute() {
		csvReader.setPathToFile(PATH_TO_CSV_FILE);
		((CsvReader) csvReader).setCsvSeparator(SEPARATOR);
		csvReader.execute();
		fillListCityHeaderBean();
		fillListCityDataBean();
	}

	private static void fillListCityHeaderBean() {
		List<String> listHeader = csvReader.getHeader();
		ArrayList<CityHeaderBean> listCityHeaderBean = new ArrayList<CityHeaderBean>();
		for (String headerName : listHeader) {
			listCityHeaderBean.add(new CityHeaderBean(headerName));
		}
		
		DatabaseMemory.getInstance().setListCityHeaderBean(listCityHeaderBean);
	}

	private static void fillListCityDataBean() {
		List<Map<String, String>> listDataMap = csvReader.getData();
		CityDataBean cityDataBean = null;
		long idLine = 1L;
		ArrayList<CityDataBean> listCityDataBean = new ArrayList<CityDataBean>();
		
		for (Map<String, String> dataMap : listDataMap) {
			cityDataBean = new CityDataBean(dataMap);
			cityDataBean.setIdLine(idLine++);
			listCityDataBean.add(cityDataBean);
		}
		
		DatabaseMemory.getInstance().setListCityDataBean(listCityDataBean);
	}

	
}
