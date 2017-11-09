package br.com.jmf.reader;

import java.util.List;
import java.util.Map;

public interface FileReaderInterface {

	public List<String> getHeader();
	
	public List<Map<String, String>> getData();
}
