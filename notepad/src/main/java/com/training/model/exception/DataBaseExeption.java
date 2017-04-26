package com.training.model.exception;

import java.sql.SQLException;

import com.training.model.Note;

public class DataBaseExeption extends Exception {

	private static final long serialVersionUID = 2121922097933473049L;
	private Note currentNote;

	public DataBaseExeption(SQLException e, Note note) {
		super(e);
		currentNote = note;
	}

	public Note getCurrentNote() {
		return currentNote;
	}

}
