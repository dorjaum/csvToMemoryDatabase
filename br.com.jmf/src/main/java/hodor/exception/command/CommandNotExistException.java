package hodor.exception.command;

public class CommandNotExistException extends RuntimeException {

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
