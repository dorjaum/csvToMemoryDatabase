package br.com.jmf.cmd;

import br.com.jmf.cmd.type.CommandCount;
import br.com.jmf.exception.command.CommandNotExistException;

public class CommandFactory {

	private static final String CMD_COUNT_EVERY_ROW = "COUNT *(.*)";
	private static final String MSG_ENTER_A_COMMAND_THAT_IS_NOT_EMPTY = "Enter a command that is not empty";

	public CommandInterface getCommand(String commandInput) {
		if(commandInput == null || commandInput.trim().equals("")) {
			throw new CommandNotExistException(MSG_ENTER_A_COMMAND_THAT_IS_NOT_EMPTY);
		}
		
		String commandUpper = commandInput.toUpperCase();
		if(commandUpper.matches(CMD_COUNT_EVERY_ROW)) {
			return new CommandCount();
		}
		
		return null;
	}
	
}
