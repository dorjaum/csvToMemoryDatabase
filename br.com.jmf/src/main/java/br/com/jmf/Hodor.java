package br.com.jmf;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hodor {
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
				LOGGER.log(Level.INFO, " ** PROGRAM HAS BEEN STOPED BY THE USER ** ");
				break;
			}
			
			tryExecuteCommand(instance, request);
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
