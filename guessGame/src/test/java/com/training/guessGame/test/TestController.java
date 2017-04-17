package com.training.guessGame.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.training.guessGame.Controller;
import com.training.guessGame.Model;
import com.training.guessGame.View;

public class TestController {

	@Test
	public void testOutOfBoundariesValidationInputOutOfBoundaries(){
		Model model = new Model(0,100);
		View view = new View();
		Controller controller = new Controller(model, view);
		assertTrue(controller.outOfBoundariesValidation(-1));
	}
	
	@Test
	public void testOutOfBoundariesValidationInputInBoundaries(){
		Model model = new Model(0,100);
		View view = new View();
		Controller controller = new Controller(model, view);
		assertFalse(controller.outOfBoundariesValidation(50));
	}
}
