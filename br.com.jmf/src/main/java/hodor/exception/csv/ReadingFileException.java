package hodor.exception.csv;

import hodor.exception.HodorException;

public class ReadingFileException extends HodorException {

	private static final long serialVersionUID = 123587734574969594L;
	
	public ReadingFileException(String msg) {
		super(msg);
	}
	
	public ReadingFileException(String msg, Exception ex) {
		super(msg, ex);
	}
	
	public  ReadingFileException(Exception ex) {
		super(ex);
	}

}
