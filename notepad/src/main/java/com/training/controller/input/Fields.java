package com.training.controller.input;

import java.util.regex.Pattern;
import static com.training.controller.input.Regex.*;
import static com.training.controller.input.FieldNames.*;

 enum Fields {
	FIRST_NAME(firstNameField,NAME_PATTERN),
	LAST_NAME(lastNameField,NAME_PATTERN),
	PHONE_NUMBER(phoneNumberField,PHONE_PATTERN);
	
	private String name;
	private Pattern regex;
	private Fields(String name, Pattern regex) {
		this.name = name;
		this.regex = regex;
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
