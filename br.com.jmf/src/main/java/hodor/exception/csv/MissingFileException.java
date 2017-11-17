package hodor.exception.csv;

import hodor.exception.HodorException;

public class MissingFileException extends HodorException {

	private static final long serialVersionUID = 12387734574969594L;
	
	public MissingFileException(String msg) {
		super(msg);
	}
	
	public MissingFileException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  MissingFileException(Exception ex) {
		super(ex);
	}

}
