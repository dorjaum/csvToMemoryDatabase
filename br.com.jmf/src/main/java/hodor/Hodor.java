package hodor;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hodor {
	private static final String HODOR_ACTION_SENDS_GOODBYE = " ** HODOR sends you GOODBYE. \"HODOR\" =D ** ";
	private static final String HODOR_ACTION_STANDS = " ** Hodor standing in front of you and smiling at you. \"HODOR\" =D ** ";
	
	private static Logger LOGGER = Logger.getLogger(Hodor.class.getName());

	public static void main(String[] args) {
		HodorRequest instance = HodorRequest.getInstance();
		Scanner input = new Scanner(System.in);
		printInstructions();
		String request = "";
		while(true) {
			LOGGER.log(Level.INFO, "WAITING FOR COMMAND > ");
			request = input.nextLine();
			if(request.toLowerCase().equals("exit")) {
				LOGGER.log(Level.INFO, HODOR_ACTION_SENDS_GOODBYE);
				break;
			}
			
			surpriseOfHodor(request);
			tryExecuteCommand(instance, request);
		}
	}
	
	private static void surpriseOfHodor(String request) {
		if(request.toLowerCase().equals("hodor")) {
			System.out.println(HODOR_ACTION_STANDS);
		}
	}
	
	private static void tryExecuteCommand(HodorRequest instance, String request) {
		try {
			instance.execute(request);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
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
