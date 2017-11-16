package br.com.jmf.cmd.type;

import java.util.List;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.cmd.CommandFactory;
import br.com.jmf.cmd.sub.SubCommandInterface;
import br.com.jmf.exception.command.CommandNotExistException;

public class CommandCount implements CommandInterface{

	public static final String PREFIX_RESPONSE_COUNTED_TOTAL_OF = "COUNTED TOTAL OF: %s";
	private static final String MSG_PLEASE_PROVIDE_A_SUBCOMMAND_FOR_COUNT_COMMAND = "Please provide a subcommand for COUNT command";
	private static final String MSG_PLEASE_PROVIDE_A_VALID_SUBCOMMAND_FOR_COUNT_COMMAND = "Please provide valid subcommand for COUNT command";
	public static final String CMD_COUNT = "count";
	private SubCommandInterface subCommand;
	
	
	public CommandCount(List<String> commandSequence) {
		validateCommandSequence(commandSequence);
		
		List<String> subList = getSublistCommands(commandSequence) ;
		SubCommandInterface subCommand = CommandFactory.getSubCommand(commandSequence.get(0), subList);
		validateSubCommand(subCommand);
		setSubCommand(subCommand);
	}

	private void validateSubCommand(SubCommandInterface subCommand) {
		if(subCommand == null) {
			throw new CommandNotExistException(MSG_PLEASE_PROVIDE_A_VALID_SUBCOMMAND_FOR_COUNT_COMMAND);
		}
	}

	private void validateCommandSequence(List<String> commandSequence) {
		if(commandSequence.isEmpty()) {
			throw new CommandNotExistException(MSG_PLEASE_PROVIDE_A_SUBCOMMAND_FOR_COUNT_COMMAND);
		}
	}

	private void setSubCommand(SubCommandInterface subCommand) {
		this.subCommand = subCommand;
	}

	private List<String> getSublistCommands(List<String> commandSequence) {
		return commandSequence.size() >= 1 ? commandSequence.subList(1, commandSequence.size()) : commandSequence;
	}

	public String getResult() {
		return generateResponse();
	}

	private String generateResponse() {
		List<CityDataBean> result = getSubCommand().getResult();
		return String.format(PREFIX_RESPONSE_COUNTED_TOTAL_OF, result.size());
	}

	private SubCommandInterface getSubCommand() {
		return this.subCommand;
	}

}
