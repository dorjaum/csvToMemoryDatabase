package hodor;

import java.util.ArrayList;
import java.util.List;

import hodor.cmd.CommandFactory;
import hodor.cmd.type.CommandInterface;
import hodor.csv.converter.CsvDatabaseMemoryBuilder;
import hodor.utils.StringUtils;

public class HodorRequest {
	
	private String response = "";
	private static HodorRequest hodorRequest;
	private CommandInterface command;
	
	public static HodorRequest getInstance() {
		if(hodorRequest == null) {
			hodorRequest = new HodorRequest();
		}
		
		return hodorRequest;
	}
	
	private HodorRequest() {
		CsvDatabaseMemoryBuilder.execute();
	}
	
	public HodorRequest execute(String request) {
		List<String> commandList = getCommandList(request);
		setCommand(CommandFactory.getCommand(commandList));
		setResponse(getCommand().getResult());
		printResult();
		
		return this;
	}

	private CommandInterface getCommand() {
		return command;
	}

	private void printResult() {
		System.out.println(getResponse());
	}

	private void setCommand(CommandInterface command) {
		this.command = command;
	}

	private void setResponse(String result) {
		this.response = result;
	}

	public String getResponse() {
		return response;
	}
	
	private List<String> getCommandList(String commandInput) {
		String commandUpper = commandInput.toLowerCase();
		String[] possibleCommandList = commandUpper.split(" ");
		ArrayList<String> notBlankWords = new ArrayList<String>();
		for (String possibleCommand : possibleCommandList) {
			if(StringUtils.isNotBlank(possibleCommand)){
				notBlankWords.add(possibleCommand);
			}
		}
		
		return notBlankWords;
	}
	
}
