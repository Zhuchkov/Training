package com.training.model;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Note {

	private List<Field> fields = new LinkedList<>();
	private LocalDateTime creationDate;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public List<Field> getFields() {
		return fields;
	}

	public Note(List<Field> fields) {
		creationDate= LocalDateTime.now();
		this.fields.addAll(fields);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Field f : fields) {
			sb.append(f.getFieldName());
			sb.append(": ");
			sb.append(f.getFieldValue());
			sb.append("\n");
		}
		sb.append(creationDate.toString());
		return sb.toString();
	}

}
