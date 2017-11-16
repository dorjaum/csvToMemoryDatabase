package hodor.cmd.property;

public class Value implements ValueInterface{

	private String value;
	
	public Value(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
