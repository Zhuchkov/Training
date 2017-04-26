package com.training.controller.input;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.training.model.Field;
import com.training.model.Note;
import com.training.view.View;

public class NoteInput {
	private View view;
	private Scanner sc=new Scanner(System.in);
	
	public NoteInput(View view) {
		this.view = view;
	}

	public Note createNote() {
		List<Field> fields = new LinkedList<>();
		view.print("create note");
		for (Fields f : Fields.values()) {
			fields.add(createField(f));
		}
		return new Note(fields);
	}

	private Field createField(Fields f) {
		view.print(View.INPUT_REQUEST_STRING + f.fieldName());
		String fieldValue = sc.nextLine();
		while (!f.validate(fieldValue)) {
			view.print(View.INPUT_WRONG_STRING + View.INPUT_REQUEST_STRING + f.fieldName());
			fieldValue = sc.nextLine();
		}
		return new Field(f.fieldName(), fieldValue);
	}
	public Note changeField(Note note, Fields f){
		Field field = createField(f);
		note.getFields().set(f.ordinal(), field);
		return note;
	}
}
