package com.training.controller.input;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.training.model.Field;
import com.training.model.Note;
import com.training.view.View;

public class NoteConstructor {
	private View view;
	private Scanner sc = new Scanner(System.in);

	public NoteConstructor(View view) {
		this.view = view;
	}

	public Note createNote() {
		List<Field> fields = new LinkedList<>();
		for (Fields f : Fields.values()) {
			fields.add(createField(f));
		}
		return new Note(fields);
	}

	private Field createField(Fields currentField) {
		view.print(View.INPUT_REQUEST_STRING + currentField.fieldName());
		String fieldValue = sc.nextLine();
		while (!currentField.validate(fieldValue)) {
			view.print(View.INPUT_WRONG_STRING + View.INPUT_REQUEST_STRING + currentField.fieldName());
			fieldValue = sc.nextLine();
		}
		return new Field(currentField.fieldName(), fieldValue);
	}

	public Note changeField(Note note, Fields f) {
		Field field = createField(f);
		note.getFields().set(f.ordinal(), field);
		return note;
	}
}
