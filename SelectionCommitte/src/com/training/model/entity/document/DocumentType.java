package com.training.model.entity.document;

public enum DocumentType {
	MATH(25), BIOLOG(20);

	private int quantity;

	DocumentType(int max) {
		this.quantity = max;
	}

	public int getQuantity() {
		return quantity;
	}
}
