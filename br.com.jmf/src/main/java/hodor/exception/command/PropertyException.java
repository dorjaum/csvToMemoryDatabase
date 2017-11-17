package hodor.exception.command;

import hodor.exception.HodorException;

public class PropertyException extends HodorException {

	private static final long serialVersionUID = 868497600965670732L;

	public PropertyException(String msg) {
		super(msg);
	}
	
	public PropertyException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  PropertyException(Exception ex) {
		super(ex);
	}

}
