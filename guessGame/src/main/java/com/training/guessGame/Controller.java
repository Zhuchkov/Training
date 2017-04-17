package com.training.guessGame;

import java.util.Scanner;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void startGame() {
		boolean guessed;
		do {
			Scanner sc = new Scanner(System.in);
			inputRequest();
			int input = processInput(sc);
			guessed = model.makeGuess(input);
			model.addStepToRoute(input);

		} while (guessed == false);
		view.print(View.CONGRATULATION);
		view.printRoute(model.getRoute());
	}

	private void inputRequest() {
		view.printInputRequest(model.getMin(), model.getMax());
	}

	private int processInput(Scanner sc) {
		int input;
		do {
			input = readNumber(sc);
		} while (outOfBoundariesValidation(input));
		return input;
	}

	public boolean outOfBoundariesValidation(int input) {
		 if(input < model.getMin()){
			 view.print(View.OUT_OF_MIN_BORDER);
			 inputRequest();
			 return true;
		 }else if(input>model.getMax()){
			 view.print(View.OUT_OF_MAX_BORDER);
			 inputRequest();
			 return true;
		 }
		 return false;
	}

	private int readNumber(Scanner sc) {
		while (!sc.hasNextInt()) {
			view.print(View.WRONG_UNMERIC_INPUT);
			inputRequest();
			sc.next();
		}
		return sc.nextInt();
	}

}
