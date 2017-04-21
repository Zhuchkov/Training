package com.training.controller;

import com.training.controller.input.NoteInput;
import com.training.model.Notebook;
import com.training.view.View;

public class Controller {
	Notebook nootebook;
	View view;
	

	public Controller(Notebook nootebook, View view) {
		this.nootebook = nootebook;
		this.view = view;
	}


	public void process() {
		view.print(View.DATA_REQUEST);
		NoteInput input =new NoteInput();
		input.newNote();
		view.print(input.toString());
		
	}

}
