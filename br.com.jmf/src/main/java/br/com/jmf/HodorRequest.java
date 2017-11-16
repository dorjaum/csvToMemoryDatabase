package br.com.jmf;

import java.util.ArrayList;
import java.util.List;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.cmd.CommandFactory;
import br.com.jmf.cmd.type.CommandInterface;
import br.com.jmf.csv.converter.CsvDatabaseMemoryBuilder;
import br.com.jmf.utils.StringUtils;

public class HodorRequest {
	
	private String result = "";
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
	
	public void execute(String request) {
		List<String> commandList = getCommandList(request);
		//se commandList tem um comando soh, stoura excessao.
		setCommand(CommandFactory.getCommand(commandList.get(0), commandList.subList(1, commandList.size())));
		setResult(command.getResult());
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
