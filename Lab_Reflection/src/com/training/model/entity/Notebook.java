package com.training.model.entity;

import com.training.model.annotation.MethodAnnotation;

public class Notebook extends Computer {

	private int screenDiagonal;
	private int weight;
	private int battery;

	public Notebook(String name, int coreFrequency, int coreQuantity, int ram, int hdd, int screenDiagonal, int weight,
			int battery) {
		super(name, coreFrequency, coreQuantity, ram, hdd);
		this.screenDiagonal = screenDiagonal;
		this.weight = weight;
		this.battery = battery;
	}
	
	@Override
	@MethodAnnotation
	public String toString() {
		return "Notebook [screenDiagonal=" + screenDiagonal + ", weight=" + weight + ", battery=" + battery + "]";
	}
	
	public int getScreenDiagonal() {
		return screenDiagonal;
	}

	public void setScreenDiagonal(int screenDiagonal) {
		this.screenDiagonal = screenDiagonal;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

}
