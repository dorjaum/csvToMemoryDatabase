package br.com.jmf.reader;

import java.util.List;
import java.util.Map;

public interface FileReaderInterface {

	public FileReaderInterface build();
	
	public FileReaderInterface setPathToFile(String pathToFile);
	
	public FileReaderInterface setCsvSeparator(String separator);
	
	public List<String> getHeader();
	
	public List<Map<String, String>> getData();
}
