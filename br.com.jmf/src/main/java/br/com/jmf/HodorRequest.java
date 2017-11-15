package br.com.jmf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;
import br.com.jmf.reader.csv.CsvReader;

public class HodorRequest {
	
	private List<CityDataBean> result = new ArrayList<CityDataBean>();
	private static HodorRequest hodorRequest;
	private static Logger LOGGER = Logger.getLogger(HodorRequest.class.getName());
	
	public static void main(String[] args) {
		HodorRequest instance = HodorRequest.getInstance();
		Scanner input = new Scanner(System.in);
		printInstructions();
		String request = "";
		while(true) {
			LOGGER.log(Level.INFO, "WAITING FOR COMMAND > ");
			request = input.nextLine();

			if(request.toUpperCase().equals("EXIT")) {
				LOGGER.log(Level.INFO, " ** PROGRAM HAS BEEN STOPED BY THE USER ** ");
				break;
			}
			
			instance.execute(request);
		}
	}

	public static HodorRequest getInstance() {
		if(hodorRequest == null) {
			hodorRequest = new HodorRequest();
		}
		
		return hodorRequest;
	}
	
	private HodorRequest() {
		CsvDatabaseMemoryBuilder.execute();
	}
	
	public void execute(String request) {
		
	}

	public List<CityDataBean> getResult() {
		return result;
	}

	private static void printInstructions() {
		System.out.println(" ### TYPE EXIT TO STOP EXECUTION ### ");
		System.out.println(" ### ACTUAL VALID COMMANDS EX:   ### ");
		System.out.println(" > count * ");
		System.out.println(" > count distinct [property] ");
		System.out.println(" > filter [property] [value]");
		System.out.println(" ");
		System.out.println(" ### NOT CASE SENSITIVE, ENJOY ;) ### ");
	}
	
}
