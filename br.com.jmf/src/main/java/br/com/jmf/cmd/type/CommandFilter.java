package br.com.jmf.cmd.type;

import java.util.List;

import br.com.jmf.cmd.CommandFactory;
import br.com.jmf.cmd.property.PropertyInterface;
import br.com.jmf.exception.command.CommandFilterException;

public class CommandFilter implements CommandInterface {

	private static final String MSG_YOU_MUST_PROVIDE_A_PROPERTY_AND_VALUE = "You must provide a [property] and [value].";
	public static final String CMD_FILTER = "filter";
	private PropertyInterface property;
	
	public CommandFilter(List<String> subCommands) {
		validateSubcommands(subCommands);
		
		String propertyString = subCommands.get(0);
		String valueString = subCommands.get(1);
		setProperty(CommandFactory.getProperty(propertyString, valueString));
	}

	private void validateSubcommands(List<String> subCommands) {
		if(subCommands.size() != 2) {
			throw new CommandFilterException(MSG_YOU_MUST_PROVIDE_A_PROPERTY_AND_VALUE);
		}
	}

	public String getResult() {
		
		
		return null;
	}

	public PropertyInterface getProperty() {
		return property;
	}

	private void setProperty(PropertyInterface property) {
		this.property = property;
	}

}
