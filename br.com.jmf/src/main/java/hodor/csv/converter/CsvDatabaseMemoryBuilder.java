package hodor.csv.converter;

import hodor.csv.type.SeparatorType;
import hodor.reader.csv.CsvReader;

public class CsvDatabaseMemoryBuilder extends DatabaseMemoryBuilder{

	private String SEPARATOR = SeparatorType.COMMA.getSeparator();
	private String PATH_TO_CSV_FILE = "src/test/resources/files/cities_data.csv";
	
	public CsvDatabaseMemoryBuilder() {	}
	
	public CsvDatabaseMemoryBuilder(String pathToFile, SeparatorType separator) {
		this.SEPARATOR = separator.getSeparator();
		this.PATH_TO_CSV_FILE = pathToFile;
	}
	
//	public void execute() {
//		reader.setPathToFile(pathToFile);
//		((CsvReader) reader).setCsvSeparator(separator.getSeparator());
//		reader.execute();
//		fillListCityHeaderBean();
//		fillListCityDataBean();
//	}
	
	public void execute() {
		reader.setPathToFile(PATH_TO_CSV_FILE);
		((CsvReader) reader).setCsvSeparator(SEPARATOR);
		reader.execute();
		fillListCityHeaderBean();
		fillListCityDataBean();
	}

}
