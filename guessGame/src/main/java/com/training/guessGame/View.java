package com.training.guessGame;

import java.util.List;

public class View {

	public static final String INPUT_NUMBER_REQUEST = "input number between %d and %d";
	public static final String WRONG_UNMERIC_INPUT = "Wrong input. Integer value expected";
	public static final String CONGRATULATION = "congratulation";
	public static final String OUT_OF_MIN_BORDER = "Wrong input. Value less then min border";
	public static final String OUT_OF_MAX_BORDER ="Wrong input. Value bigger then max border";
	private static final String STEP_INFO = "On the step %d you try number %d ";
	
	
	public void printInputRequest(int min, int max) {
		
		print(String.format(INPUT_NUMBER_REQUEST, min, max));
		
	}

	public void print(String output) {
		System.out.println(output);
	}

	public void printRoute(List<Integer> route) {
		for(int counter=0;counter<route.size();counter++){
			print(String.format(STEP_INFO,counter ,route.get(counter)));
		}
		
	}

}
