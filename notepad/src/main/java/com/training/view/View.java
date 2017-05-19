package com.training.view;

import com.training.model.Note;

public class View {

	public static  String DATA_REQUEST = "info.note.creation";
	public static  String INPUT_REQUEST_STRING = "request.input.string";
	public static  String INPUT_WRONG_STRING = "error.input.string";
	public static  String SAVE_REQUEST = "request.input.save";
	public static  String WRONG_UNMERIC_INPUT = "error.input.numeric";
	public static  String NICKNAME_OCCUPIED = "error.database.unick.nicknme";
	public static  String DB_EXCEPTION = "error.database.unknown";
	public static  String REQUEST_INPUT_LANGUAGE = "request.input.language";

	public void print(String... output) {
		for (String s : output) {
			System.out.print(ResourceManager.INSTANCE.getStringUTF8Encoded(s)+" ");
		}
		System.out.println("\n");
	}
	public void print(String output) {
	
			System.out.println(ResourceManager.INSTANCE.getStringUTF8Encoded(output));
	
	}
	public void printNote(Note note) {
		System.out.println(note.toString());
		
	}

}
