package hodor.csv.type;

public enum SeparatorType {

	COMMA(","),
	SEMICOLON(";"),
	TABULATION("	"),
	PIPE("|"),
	CARET("^");
	
	private String separator;
	
	SeparatorType(String separator) {
		this.separator = separator;
	}
	
	public String getSeparator() {
		return this.separator;
	}
}
