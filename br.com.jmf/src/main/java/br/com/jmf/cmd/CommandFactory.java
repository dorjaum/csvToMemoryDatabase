package br.com.jmf.cmd;

import java.util.ArrayList;
import java.util.List;

import br.com.jmf.bean.city.CityHeaderBean;
import br.com.jmf.cmd.property.Property;
import br.com.jmf.cmd.property.Value;
import br.com.jmf.cmd.type.CommandCount;
import br.com.jmf.cmd.type.CommandDistinct;
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

	public CommandInterface getCommand(String commandInput) {
		if(isBlank(commandInput)) {
			throw new CommandNotExistException(MSG_ENTER_A_COMMAND_THAT_IS_NOT_EMPTY);
		}
		
		String inputUpper = commandInput.toUpperCase();
		
		if(inputUpper.equals(CommandCount.CMD_COUNT)) {
			return new CommandCount();
		}
		
		if(inputUpper.equals(CommandDistinct.CMD_DISTINCT)) {
			return new CommandDistinct();
		}
		
		if(inputUpper.equals(CommandFilter.CMD_FILTER)) {
			return new CommandFilter();
		}
		
		return null;
	}

	public Property getProperty(String property) {
		if(isBlank(property)) {
			throw new PropertyException(MSG_PROPERTY_MUST_BE_NOT_BLANK);
		}
		
		ArrayList<CityHeaderBean> listCityHeaderBean = DatabaseMemory.getInstance().getListCityHeaderBean();
		for (CityHeaderBean cityHeaderBean : listCityHeaderBean) {
			if(cityHeaderBean.getName().equals(property)) {
				return new Property(property);
			}
		}
		
		throw new PropertyException(MSG_PROPERTY_NOT_EXISTS);		
	}

	public Value getValue(String value) {
		if(isBlank(value)) {
			throw new ValueException(MSG_VALUE_MUST_BE_NOT_BLANK);
		}
		
		return new Value(value);
	}
	
	private List<String> getCommandList(String commandInput) {
		String commandUpper = commandInput.toUpperCase();
		String[] possibleCommandList = commandUpper.split(" ");
		ArrayList<String> notBlankWords = new ArrayList<String>();
		for (String possibleCommand : possibleCommandList) {
			if(isNotBlank(possibleCommand)){
				notBlankWords.add(possibleCommand);
			}
		}
		
		return notBlankWords;
	}

	private boolean isNotBlank(String possibleCommand) {
		return !isBlank(possibleCommand); 
	}
	
	private boolean isBlank(String commandInput) {
		return commandInput == null || commandInput.trim().equals("");
	}
	
}
