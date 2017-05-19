package com.training.model.entity.producer;

import com.training.model.DocumentQueue;
import com.training.model.entity.document.Document;
import com.training.model.entity.document.DocumentFactory;

public class Producer implements Runnable {
	private DocumentQueue queue;
	private DocumentFactory factory = new DocumentFactory();


	public Producer(DocumentQueue queue) {
		this.queue = queue;
	}
	

	@Override
	public void run() {
		Document nextDocuent;
		do {
			nextDocuent = factory.getRandomDocument();
			if (nextDocuent == null) {
				queue.setEmpty();
				return;
			} else {
				queue.add(nextDocuent);
			}
		} while (true);
	}

}
