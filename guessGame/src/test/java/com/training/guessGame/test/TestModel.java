package com.training.guessGame.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.training.guessGame.Model;

public class TestModel {

	@Test
	public void testGenerateValue() {
		for(int i = 0; i<1000;i++){
			int value = new Model().generateValue(0, 100);
			if(value<0||value>100) 
				fail();
		}
	}
	@Test
	public void testMakeGuessExactlyValue(){
		Model model = new Model(0,100);
		model.setValue(50);
		model.makeGuess(50);
		assertTrue(model.makeGuess(50));
	}
	@Test
	public void testMakeGuessBiggerThenValue(){
		Model model = new Model(0,100);
		model.setValue(50);
		model.makeGuess(51);
		int actualMax = model.getMax();
		int expectedMax = 51;
		assertEquals(expectedMax, actualMax);
		assertFalse(model.makeGuess(51));
	}
	@Test
	public void testMakeGuessLessThenValue(){
		Model model = new Model(0,100);
		model.setValue(50);
		model.makeGuess(49);
		int actualMin = model.getMin();
		int expectedMin = 49;
		assertEquals(expectedMin, actualMin);
		assertFalse(model.makeGuess(49));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testModelMinBorderBiggerThenMaxBorder(){
		new Model(100,0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateValueMinBorderBiggerThenMaxBorder(){
		new Model().generateValue(100, 0);
	}
	
}