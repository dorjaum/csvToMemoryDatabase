package hodor.exception.command;

public class ValueException extends RuntimeException {

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
