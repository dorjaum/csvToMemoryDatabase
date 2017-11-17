package hodor;

import static java.util.logging.Level.INFO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import hodor.bean.city.HeaderBean;
import hodor.database.DatabaseMemory;
import hodor.exception.HodorException;

public class Hodor {
	private static final String WAITING_FOR_COMMAND = ">> WAITING FOR COMMAND << ";
	private static final String HODOR_ACTION_SENDS_GOODBYE = " ** HODOR sends you GOODBYE. \"HODOR\" =D ** ";
	private static final String HODOR_ACTION_STANDS = " ** Hodor standing in front of you and smiling at you. \"HODOR\" =D ** ";
	
	private static Logger LOGGER = Logger.getLogger(Hodor.class.getName());

	public static void main(String[] args) {
		HodorRequest instance = HodorRequest.getInstance();
		printInstructions();
		String request = "";
		Scanner input = new Scanner(System.in);
		
		while(true) {
			LOGGER.log(INFO, WAITING_FOR_COMMAND);
			request = input.nextLine();
			if(isExit(request)) {
				LOGGER.log(INFO, HODOR_ACTION_SENDS_GOODBYE);
				break;
			}
			
			surpriseOfHodor(request);
			tryExecuteCommand(instance, request);
		}
	}
	
	private static void tryExecuteCommand(HodorRequest instance, String request) {
		try {
			instance.execute(request);
		} catch (HodorException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
	}
	
	private static void printInstructions() {
		System.out.println(" ###################################################################### ");
		System.out.println(" ### TYPE EXIT TO STOP EXECUTION 									 ");
		System.out.println(" ### ACTUAL VALID COMMANDS EX:   									 ");
		System.out.println(" ###   > count * ");
		System.out.println(" ###   > count distinct [property] ");
		System.out.println(" ###   > filter [property] [value]");
		System.out.println(" ###   > List of Available Properties: " + getAvailableProperties());
		System.out.println("     ");
		System.out.println(" ### YOU CAN IMPORT EVERTY CSV THAT HAS A HEADER AND CORRESPONDENT DATA ### ");
		System.out.println(" ### NOT CASE SENSITIVE, HOLDOR SAYS \"HOLDOR(ENJOY)\" ;)              ### ");
		System.out.println(" ###################################################################### ");
		System.out.println("  ");
		System.out.println("  ");
		
	}

	private static String getAvailableProperties() {
		ArrayList<HeaderBean> listCityHeaderBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		StringBuilder properties = new StringBuilder();
		for (HeaderBean header : listCityHeaderBean) {
			properties.append("[");
			properties.append(header.getName());
			properties.append("] ");
		}
		
		return properties.toString();
	}

	private static boolean isExit(String request) {
		return request.toLowerCase().equals("exit");
	}
	
	private static void surpriseOfHodor(String request) {
		if(request.toLowerCase().equals("hodor")) {
			System.out.println(HODOR_ACTION_STANDS);
		}
	}
}
