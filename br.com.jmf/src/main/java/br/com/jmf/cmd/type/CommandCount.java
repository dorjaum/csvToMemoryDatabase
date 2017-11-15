package br.com.jmf.cmd.type;

import java.util.ArrayList;
import java.util.List;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.cmd.CommandInterface;
import br.com.jmf.database.DatabaseMemory;

public class CommandCount implements CommandInterface{

	public static final String CMD_COUNT = "COUNT";
	List<String> commandList;
	
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
