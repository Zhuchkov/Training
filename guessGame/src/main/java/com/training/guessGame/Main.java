package com.training.guessGame;

import com.training.guessGame.view.View;

public class Main {

	public static void main(String[] args) {
		Model model = new Model(0,100);
		View view = new View();
		Controller controller = new Controller(model, view);
		controller.startGame();

	}

}
