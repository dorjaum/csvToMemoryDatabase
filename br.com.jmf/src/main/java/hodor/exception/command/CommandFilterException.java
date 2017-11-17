package hodor.exception.command;

import hodor.exception.HodorException;

public class CommandFilterException extends HodorException {

	private static final long serialVersionUID = 123823305578909594L;
	
	public CommandFilterException(String msg) {
		super(msg);
	}
	
	public CommandFilterException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  CommandFilterException(Exception ex) {
		super(ex);
	}
}
