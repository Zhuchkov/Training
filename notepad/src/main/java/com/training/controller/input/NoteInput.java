package com.training.controller.input;

import com.training.controller.InputUtil;

public class NoteInput {
	InputUtil iu = new InputUtil();
	String firstName;
	String lastName;
	String nickName;
	String phone;
	
	public NoteInput newNote(){
		this.firstName = iu.regexValidatedInput(Regex.NAME_PATTERN);
		this.lastName = iu.regexValidatedInput(Regex.NAME_PATTERN);
		this.nickName = iu.regexValidatedInput(Regex.NICKNAME_PATTERN);
		this.phone = iu.regexValidatedInput(Regex.PHONE_PATTERN);
		return this;
		
	}

	@Override
	public String toString() {
		return "NoteInput [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", phone="
				+ phone + "]";
	}
	

}
