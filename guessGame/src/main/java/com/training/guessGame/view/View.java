package com.training.guessGame.view;

import java.util.List;

public class View {

	public static final String REQUEST_INPUT_NUMERIC = "request.input.numeric";
	public static final String ERROR_INPUT_NUMERIC = "error.input.numeric";
	public static final String CONGRATULATION = "info.congrat";
	public static final String OUT_OF_MIN_BORDER = "error.input.min";
	public static final String OUT_OF_MAX_BORDER ="error.input.max";
	private static final String STEP_INFO = "info.step";
	public static final String REQUEST_INPUT_LANGUAGE = "request.input.language";
	
	ResourceManager resourceManager = ResourceManager.INSTANCE;
	
	public void printInputRequest(int min, int max) {
		
		print(REQUEST_INPUT_NUMERIC, min, max);
		
	}
	
	public void print(String output) {
		out(resourceManager.getString(output));
	}
	

	public void printRoute(List<Integer> route) {
		for(int counter=0;counter<route.size();counter++){
			print(STEP_INFO,counter ,route.get(counter));
		}
		
	}
	private void print(String key, Number... num){
		out(String.format(resourceManager.getString(key),num));
	}

	private void out(String out) {
		System.out.println(out);
	}

}
