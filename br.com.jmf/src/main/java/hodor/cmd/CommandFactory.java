package hodor.cmd;

import static hodor.utils.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.List;

import hodor.bean.city.HeaderBean;
import hodor.cmd.property.Property;
import hodor.cmd.property.PropertyInterface;
import hodor.cmd.property.Value;
import hodor.cmd.property.ValueInterface;
import hodor.cmd.sub.CommandAsterisk;
import hodor.cmd.sub.CommandDistinct;
import hodor.cmd.sub.SubCommandInterface;
import hodor.cmd.type.CommandCount;
import hodor.cmd.type.CommandFilter;
import hodor.cmd.type.CommandInterface;
import hodor.database.DatabaseMemory;
import hodor.exception.command.CommandNotExistException;
import hodor.exception.command.PropertyException;
import hodor.exception.command.ValueException;

public class CommandFactory {
	
	private static final String MSG_PROPERTY_NOT_EXISTS = "Property not exists.";
	private static final String MSG_VALUE_MUST_BE_NOT_BLANK = "Value must be not blank.";
	private static final String MSG_PROPERTY_MUST_BE_NOT_BLANK = "Property must be not blank.";
	private static final String MSG_ENTER_A_COMMAND_THAT_IS_NOT_EMPTY = "Enter a command that is not empty";
	private static final String MSG_COMMAND_PROVIDED_NOT_EXPECTED = "Command provided not expected.";
	private static final String MSG_PLEASE_PROVIDE_A_VALID_SUBCOMMAND = "Please provide valid subcommand.";

	public static CommandInterface getCommand(List<String> commandList) {
		List<String> subListOfCommands = commandList.subList(1, commandList.size());

		return getCommand(commandList.get(0), subListOfCommands);
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
		
		throw new CommandNotExistException(MSG_COMMAND_PROVIDED_NOT_EXPECTED);
		
	}

	public static PropertyInterface getProperty(String property, String value) {
		validateProperty(property);
		
		ArrayList<HeaderBean> listCityHeaderBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		for (HeaderBean cityHeaderBean : listCityHeaderBean) {
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
		
		
		throw new CommandNotExistException(MSG_PLEASE_PROVIDE_A_VALID_SUBCOMMAND);
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
