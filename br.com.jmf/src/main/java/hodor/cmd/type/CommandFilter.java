package hodor.cmd.type;

import java.util.ArrayList;
import java.util.List;

import hodor.bean.city.DataBean;
import hodor.cmd.CommandFactory;
import hodor.cmd.property.PropertyInterface;
import hodor.database.DatabaseMemory;
import hodor.exception.command.CommandFilterException;

public class CommandFilter implements CommandInterface {

	private static final String MSG_NO_RESULTS = "No results.";
	private static final String MSG_YOU_MUST_PROVIDE_A_PROPERTY_AND_VALUE = "You must provide a [property] and [value].";
	private static final String LINE_BREAK = "\n";
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
		ArrayList<DataBean> listCityDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		ArrayList<String> listOfJsonBeans = new ArrayList<String>();
		for (DataBean cityDataBean : listCityDataBean) {
			if(isBeanWithPropertyAndValueSelectable(cityDataBean)) {
				listOfJsonBeans.add(cityDataBean.asJson());
			}
		}
		
		return createApresentableResult(listOfJsonBeans);
	}

	private String createApresentableResult(ArrayList<String> listOfJsonBeans) {
		if(listOfJsonBeans.isEmpty()) {
			return MSG_NO_RESULTS;
		}
		
		StringBuilder apresentableResult = new StringBuilder();
		for (String jsonBean : listOfJsonBeans) {
			apresentableResult.append(jsonBean + LINE_BREAK);
		}
		return apresentableResult.toString();
	}

	private boolean isBeanWithPropertyAndValueSelectable(DataBean cityDataBean) {
		return cityDataBean.getLinePropertieValue().get(getProperty().getName()).toLowerCase().equals(getProperty().getValue().getValue().toLowerCase());
	}

	public PropertyInterface getProperty() {
		return property;
	}

	private void setProperty(PropertyInterface property) {
		this.property = property;
	}

}
