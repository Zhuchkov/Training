package com.training.model;

import java.util.LinkedList;
import java.util.List;

import com.training.controller.input.NoteInput;

public class Notebook {
	
	private List<Note> notes = new LinkedList<>();
	
	public void saveNote(List<Field> input){
		notes.add(new Note(input));
		
	}

}
