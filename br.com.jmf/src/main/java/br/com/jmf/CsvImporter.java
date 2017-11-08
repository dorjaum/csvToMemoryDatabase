package br.com.jmf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvImporter {

	private String pathToFile;
	private String csvSeparator;
	private BufferedReader bufferReader;
	private static CsvImporter instance;
	
	private CsvImporter() {
		
	}
	
	public static CsvImporter getInstance() {
		if(instance == null) {
			instance = new CsvImporter();
		}
		
		return instance;
	}
	
	public void run() {

	    String arquivoCSV = "arquivo.csv";
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ",";
	    try {

	        br = new BufferedReader(new FileReader(arquivoCSV));
	        while ((linha = br.readLine()) != null) {

	            String[] pais = linha.split(csvDivisor);

	            System.out.println("País [code= " + pais[pais.length-2] 
	                                 + " , name=" + pais[pais.length-1] + "]");

	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	  }

	public CsvImporter build() {
		String line = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(getPathToFile()));
			setBufferReader(bufferedReader);
			tryReadCsvHeader();
			tryReadCsvData();
		}catch (FileNotFoundException e) {
			//explode mine exception here
		} catch (IOException e) {
			//explode mine exception here
		}
		
		return this;
	}

	private void tryReadCsvData() throws IOException {
		String line;
		while((line = getBufferReader().readLine()) != null) {
			String[] data = line.split(getCsvSeparator());
			//create data
		}
	}

	private void tryReadCsvHeader() throws IOException {
		String line;
		line = getBufferReader().readLine();
		//create header
	}



	public String getPathToFile() {
		return pathToFile;
	}

	public CsvImporter setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
		return this;
	}

	public CsvImporter setCsvSeparator(String csvSeparator) {
		this.csvSeparator = csvSeparator;
		return this;
	}

	public String getCsvSeparator() {
		return csvSeparator;
	}

	public BufferedReader getBufferReader() {
		return bufferReader;
	}

	public void setBufferReader(BufferedReader bufferReader) {
		this.bufferReader = bufferReader;
	}

}
