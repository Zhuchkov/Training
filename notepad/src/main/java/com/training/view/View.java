package com.training.view;

public class View {

	public static final String DATA_REQUEST = "new note ";
	public static final String INPUT_REQUEST_STRING = "input ";
	public static final String INPUT_WRONG_STRING = "wrong input ";
	public static final String SAVE_REQUEST = "want to save? 0-save, 1-change fields, 2-exit ";
	public static final String WRONG_UNMERIC_INPUT = "Number expected";
	public static final String NICKNAME_OCCUPIED = "Nickname occupied. Input new";
	public static final String DB_EXCEPTION = "Some database error. Try again";

	public void print(String output) {
		System.out.println(output);
		
	}

}
