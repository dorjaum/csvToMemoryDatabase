package br.com.jmf.cmd.type;

import java.util.ArrayList;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.cmd.CommandInterface;
import br.com.jmf.database.DatabaseMemory;

public class CommandCount implements CommandInterface{

	public String getResult() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(count());
		
		return stringBuilder.toString();
	}
	
	public long count() {
		ArrayList<CityDataBean> listCityDataBean = DatabaseMemory.getInstance().getListCityDataBean();
		return listCityDataBean.size();
	}

}
