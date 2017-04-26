package com.training.model;

import java.util.LinkedList;
import java.util.List;

public class Note {

	private List<Field> fields = new LinkedList<>();

	public Note(List<Field> fields) {
		this.fields.addAll(fields);
	}

	public List<Field> getFields() {
		return fields;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Field f: fields){
			sb.append(f.getFieldName());
			sb.append(": ");
			sb.append(f.getFieldValue());
			sb.append("\n");
		}
		return sb.toString();
	}
}
