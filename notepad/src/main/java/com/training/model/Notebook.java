package com.training.model;

import com.training.model.exception.NicknameOccupiedException;
import com.training.model.jdbc.SQLiteJDBC;

public class Notebook {
	SQLiteJDBC  dao = new SQLiteJDBC();
	
	//private List<Note> notes = new LinkedList<>();
	
	public void save(Note note) throws NicknameOccupiedException{
		//notes.add(note);
		dao.insert(note);
	}
}
