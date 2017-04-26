package com.training.model;

import java.util.LinkedList;
import java.util.List;

import com.training.controller.input.NoteInput;
import com.training.model.exception.NicknameOccupiedException;
import com.training.model.jdbc.SQLiteJDBC;

public class Notebook {
	SQLiteJDBC  dao = new SQLiteJDBC();
	
	//private List<Note> notes = new LinkedList<>();
	
	public void saveNote(Note note) throws NicknameOccupiedException{
		//notes.add(note);
		dao.insert(note);
		dao.selectAll();
		
	}

}
