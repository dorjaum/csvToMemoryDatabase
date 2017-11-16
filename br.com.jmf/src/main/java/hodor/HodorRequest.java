package hodor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import hodor.bean.city.CityDataBean;
import hodor.cmd.CommandFactory;
import hodor.cmd.type.CommandInterface;
import hodor.csv.converter.CsvDatabaseMemoryBuilder;
import hodor.exception.command.CommandNotExistException;
import hodor.utils.StringUtils;

public class HodorRequest {
	
	private String result = "";
	private static HodorRequest hodorRequest;
	private CommandInterface command;
	private static Logger LOGGER = Logger.getLogger(Hodor.class.getName());
	
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
		setResult(getCommand().getResult());
		printResult();
		
		return this;
	}

	private CommandInterface getCommand() {
		return command;
	}

	private void printResult() {
		System.out.println(getResult());
	}

	private void setCommand(CommandInterface command) {
		this.command = command;
	}

	private void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
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
