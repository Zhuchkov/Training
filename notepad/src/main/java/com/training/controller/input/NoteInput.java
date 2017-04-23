package com.training.controller.input;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.training.model.Field;
import com.training.view.View;

public class NoteInput {
	private View view;

	
	public NoteInput(View view) {
		this.view = view;
	}

	public List<Field> createNote() {
		List<Field> note = new LinkedList<>();
		view.print("create note");
		Scanner sc = new Scanner(System.in);
		for (Fields f : Fields.values()) {
			String field = createField(sc, f);
			note.add(new Field(f.fieldName(), field));
		}
		return note;
	}

	private String createField(Scanner sc, Fields f) {
		view.print(View.INPUT_REQUEST_STRING + f.fieldName());
		String input = sc.nextLine();
		while (!f.validate(input)) {
			view.print(View.INPUT_WRONG_STRING + View.INPUT_REQUEST_STRING + f.fieldName());
			input = sc.nextLine();
		}
		return input;
	}



}
