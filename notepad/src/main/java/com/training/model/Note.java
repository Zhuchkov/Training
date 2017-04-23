package com.training.model;

import java.util.LinkedList;
import java.util.List;

public class Note {

	private List<Field> fields = new LinkedList<>();

	public Note(List<Field> fields) {
		this.fields.addAll(fields);
	}
	
	
}
