package com.training.model.exception;

import com.training.model.Note;

public class NicknameOccupiedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7474585205907930983L;
	
	private Note invalidNote;
	public NicknameOccupiedException(Note note){
		super();
		invalidNote=note;
		
	}

	public Note getInvalidNote() {
		return invalidNote;
	}
}
