package br.com.jmf.exception.command;

public class CommandFilterException extends RuntimeException {

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
