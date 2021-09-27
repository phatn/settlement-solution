package com.sc.settlement.api.common;

public enum ResponseStatus {
	
	
	SUCCESS("success"), ERROR("error");
	
	private String value;
	
	private ResponseStatus(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
}
