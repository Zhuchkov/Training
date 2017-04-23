package com.training.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.training.controller.input.NoteInput;
import com.training.model.Field;
import com.training.model.Notebook;
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
		NoteInput input = new NoteInput(view);
		List<Field> fields = input.createNote();
		view.print(Arrays.toString(fields.toArray()));
		view.print(View.SAVE_REQUEST);
		if(readNumber()==0){
		notebook.saveNote(fields);
		}else{
			process();
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
