package com.training.model;

public class Field {

	private String fieldName;
	private String fieldValue;
	
	public Field(String fieldName, String fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	@Override
	public String toString() {
		return "\n"+fieldName+": "+fieldValue;
	}
	
}
