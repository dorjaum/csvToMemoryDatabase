package hodor.cmd.sub;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import hodor.bean.city.CityDataBean;
import hodor.cmd.CommandFactory;
import hodor.cmd.property.PropertyInterface;
import hodor.database.DatabaseMemory;
import hodor.exception.command.PropertyException;

public class CommandDistinct implements SubCommandInterface{
	private static final String MSG_PLEASE_PROVIDE_A_PROPERTY_FOR_DISTINCT_COMMAND = "Please provide a property for DISTINCT command";
	public static final String CMD_DISTINCT = "distinct";
	private PropertyInterface property;
	
	public CommandDistinct(List<String> subList) {
		if(subList.isEmpty()) {
			throw new PropertyException(MSG_PLEASE_PROVIDE_A_PROPERTY_FOR_DISTINCT_COMMAND);
		}
		
		setProperty(CommandFactory.getProperty(subList.get(0), ""));
	}

	private void setProperty(PropertyInterface property) {
		this.property = property;
	}

	public List<CityDataBean> getResult() {
		ArrayList<CityDataBean> listCityDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		SortedSet<CityDataBean> distinctSet = createDistinctSet();
		distinctSet.addAll(listCityDataBean); 
		
		return sortedSetAsArrayList(listCityDataBean, distinctSet);
	}

	private ArrayList<CityDataBean> sortedSetAsArrayList(ArrayList<CityDataBean> listCityDataBean, SortedSet<CityDataBean> distinctSet) {
		ArrayList<CityDataBean> listDistinctDataBean = new ArrayList<CityDataBean>();
		listDistinctDataBean.addAll(distinctSet);
		
		return listDistinctDataBean;
	}

	private SortedSet<CityDataBean> createDistinctSet() {
		SortedSet<CityDataBean> setDistinct = new TreeSet<CityDataBean>(new Comparator<CityDataBean>(){
		    public int compare(CityDataBean data1, CityDataBean data2) {
		    	return data1.getLinePropertieValue().get(property.getName()).equals(data2.getLinePropertieValue().get(property.getName())) ? 0 : 1;
		    }
		});
		
		return setDistinct;
	}
	
}
