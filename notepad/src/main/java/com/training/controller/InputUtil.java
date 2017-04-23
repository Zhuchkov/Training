package com.training.controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.training.view.View;

public class InputUtil {
	Scanner sc = new Scanner(System.in);
	View view = new View();
	
	public String regexValidatedInput(Pattern pattern){
		view.print(View.INPUT_REQUEST_STRING);
		String input = sc.nextLine();
		while(! pattern.matcher(input).matches()){
			view.print(View.INPUT_WRONG_STRING+View.INPUT_REQUEST_STRING);
			input=sc.nextLine();
		}
		return input;
		
	}


}
