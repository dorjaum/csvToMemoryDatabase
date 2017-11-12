package br.com.jmf.database;

import java.util.ArrayList;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.bean.city.CityHeaderBean;

public class DatabaseMemory {

	private static DatabaseMemory instance;

	private DatabaseMemory() {
	}

	public static DatabaseMemory getInstance() {
		if(instance == null) {
			instance = new DatabaseMemory();
		}
		
		return instance;
	}

	private ArrayList<CityHeaderBean> listCityHeaderBean;
	private ArrayList<CityDataBean> listCityDataBean;

	public ArrayList<CityHeaderBean> getListCityHeaderBean() {
		return listCityHeaderBean;
	}

	public void setListCityHeaderBean(ArrayList<CityHeaderBean> listCityHeaderBean) {
		this.listCityHeaderBean = listCityHeaderBean;
	}

	public ArrayList<CityDataBean> getListCityDataBean() {
		return listCityDataBean;
	}

	public void setListCityDataBean(ArrayList<CityDataBean> listCityDataBean) {
		this.listCityDataBean = listCityDataBean;
	}
}
