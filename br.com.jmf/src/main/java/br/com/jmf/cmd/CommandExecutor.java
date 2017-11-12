package br.com.jmf.cmd;

import java.util.ArrayList;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.database.DatabaseMemory;

public class CommandExecutor {
	
	public long count() {
		ArrayList<CityDataBean> listCityDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		return listCityDataBean.size();
	}

	
}
