package hodor.exception.command;

import hodor.exception.HodorException;

public class ValueException extends HodorException {

	private static final long serialVersionUID = 8684976002343732L;

	public ValueException(String msg) {
		super(msg);
	}
	
	public ValueException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  ValueException(Exception ex) {
		super(ex);
	}

}
