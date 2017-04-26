package com.training.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.training.controller.input.Fields;
import com.training.controller.input.NoteInput;
import com.training.model.Field;
import com.training.model.Note;
import com.training.model.Notebook;
import com.training.model.exception.NicknameOccupiedException;
import com.training.model.jdbc.SQLiteJDBC;
import com.training.view.View;

public class Controller {
	Notebook notebook;
	View view;

	public Controller(Notebook nootebook, View view) {
		this.notebook = nootebook;
		this.view = view;
	}

	public void process() {
		view.print(View.DATA_REQUEST);
		Note note = new NoteInput(view).createNote();
		view.print(note.toString());
		view.print(View.SAVE_REQUEST);
		if (readNumber() == 0) {
			saveNote(note);
		} else {
			process();
		}

	}

	private void saveNote(Note note) {
		try {
			notebook.saveNote(note);
		} catch (NicknameOccupiedException e) {
			view.print(View.NICKNAME_OCCUPIED);
			Note fixedNote = new NoteInput(view).changeField(e.getInvalidNote(), Fields.NICKNAME);
			saveNote(fixedNote);
		}
	}

	private int readNumber() {
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			view.print(View.WRONG_UNMERIC_INPUT);
			sc.next();
		}
		return sc.nextInt();
	}

}
