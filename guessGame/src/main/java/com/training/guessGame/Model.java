package com.training.guessGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Model {
	private int min;
	private int max;
	private int value;
	
	List<Integer> route = new LinkedList<Integer>();
	public Model(){
		
	}	
		
	public Model(int min, int max) {
		this.min = min;
		this.max = max;
		this.value = generateValue(min,max);
		//System.out.println(value);
	}
	public int generateValue(int min, int max) {
		return new Random().nextInt(max-min)+min;
		
	}
	public boolean makeGuess(int input) {
		if(input<value){
			min=input;
		}else{
			max=input;
		}
		return input==value;
	}
	
	public void addStepToRoute(int input) {
		route.add(input);
	}
	
	
	
	public List<Integer> getRoute(){
		return route;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	

}
