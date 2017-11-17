package hodor.exception;

public abstract class HodorException extends RuntimeException {

	private static final long serialVersionUID = 1692212228525593385L;

	public HodorException(String msg) {
		super(msg);
	}

	public HodorException(String msg, Exception ex) {
		super(msg, ex);
	}

	public HodorException(Exception ex) {
		super(ex);
	}
}
