package hodor.exception.command;

import hodor.exception.HodorException;

public class CommandNotExistException extends HodorException {

	private static final long serialVersionUID = 1238773404574969594L;
	
	public CommandNotExistException(String msg) {
		super(msg);
	}
	
	public CommandNotExistException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  CommandNotExistException(Exception ex) {
		super(ex);
	}
}
