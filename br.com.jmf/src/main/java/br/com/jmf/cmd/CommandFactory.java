package br.com.jmf.cmd;

import static br.com.jmf.utils.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.List;

import br.com.jmf.bean.city.CityHeaderBean;
import br.com.jmf.cmd.property.Property;
import br.com.jmf.cmd.property.PropertyInterface;
import br.com.jmf.cmd.property.Value;
import br.com.jmf.cmd.property.ValueInterface;
import br.com.jmf.cmd.sub.CommandAsterisk;
import br.com.jmf.cmd.sub.CommandDistinct;
import br.com.jmf.cmd.sub.SubCommandInterface;
import br.com.jmf.cmd.type.CommandCount;
import br.com.jmf.cmd.type.CommandFilter;
import br.com.jmf.cmd.type.CommandInterface;
import br.com.jmf.database.DatabaseMemory;
import br.com.jmf.exception.command.CommandNotExistException;
import br.com.jmf.exception.command.PropertyException;
import br.com.jmf.exception.command.ValueException;

public class CommandFactory {
	
	private static final String MSG_PROPERTY_NOT_EXISTS = "Property not exists.";
	private static final String MSG_VALUE_MUST_BE_NOT_BLANK = "Value must be not blank.";
	private static final String MSG_PROPERTY_MUST_BE_NOT_BLANK = "Property must be not blank.";
	private static final String MSG_ENTER_A_COMMAND_THAT_IS_NOT_EMPTY = "Enter a command that is not empty";
	private static final String MSG_COMMAND_PROVIDED_NOT_EXPECTED = "Command provided not expected.";

	public static CommandInterface getCommand(List<String> commandList) {
		List<String> subListOfCommands = commandList.subList(1, commandList.size());
		CommandInterface command = getCommand(commandList.get(0), subListOfCommands);
		if(command == null) {
			throw new CommandNotExistException(MSG_COMMAND_PROVIDED_NOT_EXPECTED);
		}
		
		return command;
	}
	
	
	public static CommandInterface getCommand(String command, List<String> subCommands) {
		validateCommand(command);
		String inputUpper = command.toLowerCase();
		
		if(inputUpper.equals(CommandCount.CMD_COUNT)) {
			return new CommandCount(subCommands);
		}
		
		if(inputUpper.equals(CommandFilter.CMD_FILTER)) {
			return new CommandFilter(subCommands);
		}
		
		return null;
	}

	public static PropertyInterface getProperty(String property, String value) {
		validateProperty(property);
		
		ArrayList<CityHeaderBean> listCityHeaderBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		for (CityHeaderBean cityHeaderBean : listCityHeaderBean) {
			if(cityHeaderBean.getName().equals(property)) {
				return new Property(property, value);
			}
		}
		
		throw new PropertyException(MSG_PROPERTY_NOT_EXISTS);		
	}

	public static ValueInterface getValue(String value) {
		if(isBlank(value)) {
			throw new ValueException(MSG_VALUE_MUST_BE_NOT_BLANK);
		}
		
		return new Value(value);
	}
	
	public static SubCommandInterface getSubCommand(String subCommand, List<String> subList) {
		validateCommand(subCommand);
		
		String subCommandUpper = subCommand.toLowerCase();
		
		if(subCommandUpper.equals(CommandDistinct.CMD_DISTINCT)) {
			return new CommandDistinct(subList);
		}
		
		if(subCommandUpper.equals(CommandAsterisk.CMD_ASTERISK)){
			return new CommandAsterisk();
		}
		
		return null;
	}

	private static void validateProperty(String property) {
		if(isBlank(property)) {
			throw new PropertyException(MSG_PROPERTY_MUST_BE_NOT_BLANK);
		}
	}

	private static void validateCommand(String command) {
		if(isBlank(command)) {
			throw new CommandNotExistException(MSG_ENTER_A_COMMAND_THAT_IS_NOT_EMPTY);
		}
	}


}
