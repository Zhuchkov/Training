package com.training.model.entity.institute;

import java.util.NoSuchElementException;

import com.training.model.DocumentQueue;
import com.training.model.entity.document.DocumentType;

public class BiologyInstitute extends AbstractInstitute {

	public BiologyInstitute(DocumentQueue queue) {
		super(queue);

	}

	@Override
	public void accept() {
		while (!queue.isEmpty() || queue.getSize() > 0) {
		
			try {
				while (queue.element().getType() == DocumentType.BIOLOG) {
					extractFromQueue();
				}

			} catch (NoSuchElementException e) {
				return;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
