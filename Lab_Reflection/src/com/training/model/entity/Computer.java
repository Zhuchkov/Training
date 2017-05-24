package com.training.model.entity;

import com.training.model.annotation.MethodAnnotation;

public class Computer {

	private String name;
	private int coreFrequency;
	private int coreQuantity;
	private int ram;
	private int hdd;

	public Computer(String name, int coreFrequency, int coreQuantity, int ram, int hdd) {
		this.name = name;
		this.coreFrequency = coreFrequency;
		this.coreQuantity = coreQuantity;
		this.ram = ram;
		this.hdd = hdd;
	}

	@MethodAnnotation
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoreFrequency() {
		return coreFrequency;
	}

	public void setCoreFrequency(int coreFrequency) {
		this.coreFrequency = coreFrequency;
	}

	public int getCoreQuantity() {
		return coreQuantity;
	}

	public void setCoreQuantity(int coreQuantity) {
		this.coreQuantity = coreQuantity;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	@Override
	@MethodAnnotation
	public String toString() {
		return "Computer [name=" + name + ", coreFrequency=" + coreFrequency + ", coreQuantity=" + coreQuantity
				+ ", ram=" + ram + ", hdd=" + hdd + "]";
	}

}
