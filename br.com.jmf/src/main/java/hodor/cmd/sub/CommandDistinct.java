package hodor.cmd.sub;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import hodor.bean.city.DataBean;
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

	public List<DataBean> getResult() {
		ArrayList<DataBean> listCityDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		SortedSet<DataBean> distinctSet = createDistinctSet();
		distinctSet.addAll(listCityDataBean); 
		
		return sortedSetAsArrayList(listCityDataBean, distinctSet);
	}

	private ArrayList<DataBean> sortedSetAsArrayList(ArrayList<DataBean> listCityDataBean, SortedSet<DataBean> distinctSet) {
		ArrayList<DataBean> listDistinctDataBean = new ArrayList<DataBean>();
		listDistinctDataBean.addAll(distinctSet);
		
		return listDistinctDataBean;
	}

	private SortedSet<DataBean> createDistinctSet() {
		SortedSet<DataBean> setDistinct = new TreeSet<DataBean>(new Comparator<DataBean>(){
		    public int compare(DataBean data1, DataBean data2) {
		    	return data1.getLinePropertieValue().get(property.getName()).equals(data2.getLinePropertieValue().get(property.getName())) ? 0 : 1;
		    }
		});
		
		return setDistinct;
	}
	
}
