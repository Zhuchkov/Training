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
		try {
			while (queue.element().getType() == DocumentType.BIOLOG) {
				extractFromQueue();
			}

		} catch (NoSuchElementException e) {
			return;
		}
	}

}
