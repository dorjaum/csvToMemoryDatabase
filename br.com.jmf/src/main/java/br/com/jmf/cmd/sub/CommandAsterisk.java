package br.com.jmf.cmd.sub;

import java.util.List;

import br.com.jmf.bean.city.CityDataBean;
import br.com.jmf.database.DatabaseMemory;

public class CommandAsterisk implements SubCommandInterface {

	public static final String CMD_ASTERISK = "*";
	
	public List<CityDataBean> getResult(){
		return DatabaseMemory.getInstance().getListCityDataBean();
	}
}
