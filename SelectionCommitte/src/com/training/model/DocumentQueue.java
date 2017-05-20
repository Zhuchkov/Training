package com.training.model;

import java.util.LinkedList;

import com.training.model.entity.document.Document;

public class DocumentQueue {
	private final int minQuantity;
	private final int maxQuantity;

	private boolean producerEmpty = false;

	LinkedList<Document> documents = new LinkedList<>();;

	public DocumentQueue(int minQuantity, int maxQuantity) {
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
	}

	public synchronized void add(Document document) {

		while (documents.size() > maxQuantity) {
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		documents.add(document);
	}

	public synchronized Document element() {
		return documents.element();
	}

	public synchronized Document remove() {
		while (!isEmpty() && documents.size() < minQuantity) {
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return documents.remove();
	}

	public synchronized void setEmpty() {
		notifyAll();
		producerEmpty = true;

	}

	public boolean isEmpty() {
		return producerEmpty;
	}
	public int getSize(){
		return documents.size();
	}

}
