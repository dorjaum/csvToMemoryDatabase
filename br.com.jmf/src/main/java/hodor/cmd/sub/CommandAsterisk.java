package hodor.cmd.sub;

import java.util.List;

import hodor.bean.city.CityDataBean;
import hodor.database.DatabaseMemory;

public class CommandAsterisk implements SubCommandInterface {

	public static final String CMD_ASTERISK = "*";
	
	public List<CityDataBean> getResult(){
		return DatabaseMemory.getInstance().getListCityDataBean();
	}
}
