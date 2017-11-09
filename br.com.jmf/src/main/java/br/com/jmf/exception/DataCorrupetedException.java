package br.com.jmf.exception;

public class DataCorrupetedException extends RuntimeException {

	private static final long serialVersionUID = 1238773404574969594L;
	
	public DataCorrupetedException(String msg) {
		super(msg);
	}
	
	public DataCorrupetedException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  DataCorrupetedException(Exception ex) {
		super(ex);
	}
	
}
