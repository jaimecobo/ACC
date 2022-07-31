package edu.acc.java;

import java.io.Serializable;

public class HeaderBean implements Serializable {
	
	private String key;  // header key
	private String value;  // header value
	
	public HeaderBean() {}
	public HeaderBean(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}