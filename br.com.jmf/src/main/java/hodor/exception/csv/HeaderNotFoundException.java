package hodor.exception.csv;

import hodor.exception.HodorException;

public class HeaderNotFoundException extends HodorException {

	private static final long serialVersionUID = -4629346402196769170L;

	public HeaderNotFoundException(String msg) {
		super(msg);
	}
	
	public HeaderNotFoundException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  HeaderNotFoundException(Exception ex) {
		super(ex);
	}

}
