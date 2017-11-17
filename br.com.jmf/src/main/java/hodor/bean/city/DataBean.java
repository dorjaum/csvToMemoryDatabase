package hodor.bean.city;

import java.util.Map;

public class DataBean {

	private long idLine;
	private Map<String, String> linePropertieValue;
	
	public DataBean(Map<String, String> propertieValue) {
		this.linePropertieValue = propertieValue;
	}

	public Map<String, String> getLinePropertieValue() {
		return linePropertieValue;
	}

	public void setLinePropertieValue(Map<String, String> linePropertieValue) {
		this.linePropertieValue = linePropertieValue;
	}

	public String getValue(HeaderBean headerBean) {
		return getLinePropertieValue().get(headerBean.getName());
	}

	public long getIdLine() {
		return idLine;
	}

	public void setIdLine(long idLine) {
		this.idLine = idLine;
	}

	public String asJson() {
		StringBuilder jsonBuilder = new StringBuilder();
		jsonBuilder.append("[ ");
		jsonBuilder.append("line: " );
		jsonBuilder.append(getIdLine());
		jsonBuilder.append(", ");
		for (String key : getLinePropertieValue().keySet()) {
			jsonBuilder.append(key);
			jsonBuilder.append(":");
			jsonBuilder.append(getLinePropertieValue().get(key));
			jsonBuilder.append(", ");
		}
		jsonBuilder = eraseLastComma(jsonBuilder);
		jsonBuilder.append(" ]");
		
		return jsonBuilder.toString();
	}

	private StringBuilder eraseLastComma(StringBuilder jsonBuilder) {
		return jsonBuilder.replace(jsonBuilder.length() -2, jsonBuilder.length(), "");
	}
	

}
