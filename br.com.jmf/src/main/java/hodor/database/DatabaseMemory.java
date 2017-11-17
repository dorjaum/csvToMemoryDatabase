package hodor.database;

import java.util.ArrayList;

import hodor.bean.city.DataBean;
import hodor.bean.city.HeaderBean;

public class DatabaseMemory {

	private static DatabaseMemory instance;

	private DatabaseMemory() {
	}

	public static synchronized DatabaseMemory getInstance() {
		if(instance == null) {
			instance = new DatabaseMemory();
		}
		
		return instance;
	}

	private ArrayList<HeaderBean> listCityHeaderBean;
	private ArrayList<DataBean> listCityDataBean;

	public ArrayList<HeaderBean> getListCityHeaderBean() {
		return listCityHeaderBean;
	}

	public void setListCityHeaderBean(ArrayList<HeaderBean> listCityHeaderBean) {
		this.listCityHeaderBean = listCityHeaderBean;
	}

	public ArrayList<DataBean> getListCityDataBean() {
		return listCityDataBean;
	}

	public void setListCityDataBean(ArrayList<DataBean> listCityDataBean) {
		this.listCityDataBean = listCityDataBean;
	}
}
