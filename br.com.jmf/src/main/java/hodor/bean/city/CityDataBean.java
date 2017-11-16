package hodor.bean.city;

import java.util.Collection;
import java.util.Map;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

public class CityDataBean {

	private long idLine;
	private Map<String, String> linePropertieValue;
	
	public CityDataBean(Map<String, String> propertieValue) {
		this.linePropertieValue = propertieValue;
	}

	public Map<String, String> getLinePropertieValue() {
		return linePropertieValue;
	}

	public void setLinePropertieValue(Map<String, String> linePropertieValue) {
		this.linePropertieValue = linePropertieValue;
	}

	public String getValue(CityHeaderBean headerBean) {
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
