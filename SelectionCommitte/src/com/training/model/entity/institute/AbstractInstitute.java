package com.training.model.entity.institute;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import com.training.model.DocumentQueue;
import com.training.model.entity.document.Document;

public abstract class AbstractInstitute {

	protected DocumentQueue queue;
	protected List<Document> documents = new LinkedList<>();

	public AbstractInstitute(DocumentQueue queue) {
		this.queue = queue;
	}

	public abstract void accept();

	protected void extractFromQueue() {
		try {
			Document doc = queue.remove();
			System.out.println("[removed] "+getClass()+doc);
			documents.add(doc);
		} catch (NoSuchElementException e) {
			return;
		}
	}

	public List<Document> getDocuments() {
		return documents;
	}
}
