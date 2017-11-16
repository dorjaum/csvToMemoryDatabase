package hodor.exception.csv;

public class ReadingFileException extends RuntimeException {

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
