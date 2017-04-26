package com.training.controller.input;

import java.util.regex.Pattern;
import static com.training.controller.input.Regex.*;
import static com.training.controller.input.FieldNames.*;

 public enum Fields {
	FIRST_NAME(firstNameField,NAME_PATTERN,false),
	LAST_NAME(lastNameField,NAME_PATTERN,false),
	PHONE_NUMBER(phoneNumberField,PHONE_PATTERN,false),
	NICKNAME(nicknameField,NICKNAME_PATTERN,false);
	
	private String name;
	private Pattern regex;
	private boolean optional;
	private Fields(String name, Pattern regex,boolean optional) {
		this.name = name;
		this.regex = regex;
		this.optional=optional;
	}
	public boolean validate(String input){
		return regex.matcher(input).matches();
	}
	public String fieldName(){
		return name;
	}
	public Pattern regex(){
		return regex;
	}
}
