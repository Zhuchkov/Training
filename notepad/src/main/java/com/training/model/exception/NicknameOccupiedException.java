package com.training.model.exception;

import java.sql.SQLException;

import com.training.model.Note;

public class NicknameOccupiedException extends SQLException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4262886475358904958L;
	
	private Note invalidNote;
	public NicknameOccupiedException(SQLException e, Note note){
		super(e);
		invalidNote=note;
		
	}

	public Note getInvalidNote() {
		return invalidNote;
	}
}
