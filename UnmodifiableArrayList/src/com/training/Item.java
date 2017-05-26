package com.training;

public class Item implements DeepCloneable {

	private int i;

	public Item(int i) {
		this.i = i;
	}

	@Override
	public Object deepClone() {
		return new Item(i);
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	@Override
	public String toString() {
		
		return String.valueOf(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (i != other.i)
			return false;
		return true;
	}
	
}