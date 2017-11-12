package br.com.jmf.bean;

import java.util.Map;

public class CityDataBean {

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
	

}
