package com.training.model;

import com.training.model.exception.DataBaseExeption;
import com.training.model.exception.NicknameOccupiedException;
import com.training.model.jdbc.SQLiteJDBC;

public class Notebook {
	SQLiteJDBC  dao = new SQLiteJDBC();
	
	//private List<Note> notes = new LinkedList<>();
	
	public void save(Note note) throws NicknameOccupiedException, DataBaseExeption{
		//notes.add(note);
		dao.insert(note);
	}
}
