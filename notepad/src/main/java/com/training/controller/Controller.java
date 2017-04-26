package com.training.controller;

import java.util.Scanner;

import com.training.controller.input.Fields;
import com.training.controller.input.NoteConstructor;
import com.training.model.Note;
import com.training.model.Notebook;
import com.training.model.exception.DataBaseExeption;
import com.training.model.exception.NicknameOccupiedException;
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
		Note note = new NoteConstructor(view).createNote();
		saveMenu(note);

	}

	private void saveMenu(Note note) {
		view.print(note.toString());
		view.print(View.SAVE_REQUEST);
		int option = readNumber();
		switch (option){
		case 0:
			saveNote(note);
			break;
		case 1:
			process();
			break;
		case 2:
		default:
			return;
		}
	}

	private void saveNote(Note note) {
		try {
			notebook.save(note);
		} catch (NicknameOccupiedException ex) {
			view.print(View.NICKNAME_OCCUPIED);
			Note fixedNote = new NoteConstructor(view).changeField(ex.getInvalidNote(), Fields.NICKNAME);
			saveNote(fixedNote);
		}catch(DataBaseExeption ex){
			view.print(View.DB_EXCEPTION);
			saveMenu(ex.getCurrentNote());
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
