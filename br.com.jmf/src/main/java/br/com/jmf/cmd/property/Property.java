package br.com.jmf.cmd.property;

public class Property implements PropertyInterface{

	private String name;
	private ValueInterface value;
	
	public Property(String property) {
		this.name = property;
	}
	
	public Property(String property, String value) {
		this.name = property;
		setValue(new Value(value));
	}

	public String getName() {
		return this.name;
	}

	public ValueInterface getValue() {
		return value;
	}

	public void setValue(ValueInterface value) {
		this.value = value;
	}

}
