package hodor.cmd.sub;

import java.util.List;

import hodor.bean.city.DataBean;
import hodor.database.DatabaseMemory;

public class CommandAsterisk implements SubCommandInterface {

	public static final String CMD_ASTERISK = "*";
	
	public List<DataBean> getResult(){
		return DatabaseMemory.getInstance().getListCityDataBean();
	}
}
