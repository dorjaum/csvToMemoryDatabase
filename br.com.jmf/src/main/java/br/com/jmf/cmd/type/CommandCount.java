package br.com.jmf.cmd.type;

import java.util.List;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.cmd.CommandFactory;
import br.com.jmf.cmd.sub.SubCommandInterface;
import br.com.jmf.exception.command.CommandNotExistException;

public class CommandCount implements CommandInterface{

	private static final String MSG_PLEASE_PROVIDE_A_SUBCOMMAND_FOR_COUNT_COMMAND = "Please provide a subcommand for COUNT command";
	public static final String CMD_COUNT = "count";
	private SubCommandInterface subCommand;
	
	
	public CommandCount(List<String> commandSequence) {
		if(commandSequence.isEmpty()) {
			throw new CommandNotExistException(MSG_PLEASE_PROVIDE_A_SUBCOMMAND_FOR_COUNT_COMMAND);
		}
		
		List<String> subList = getSublistCommands(commandSequence) ;
		subCommand = CommandFactory.getSubCommand(commandSequence.get(0), subList);
	}

	private List<String> getSublistCommands(List<String> commandSequence) {
		return commandSequence.size() >= 1 ? commandSequence.subList(1, commandSequence.size()) : commandSequence;
	}

	public String getResult() {
		List<CityDataBean> result = subCommand.getResult();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(result.size());
		
		return stringBuilder.toString();
	}

}
