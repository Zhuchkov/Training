package com.training.model.entity.institute;

import java.util.NoSuchElementException;

import com.training.model.DocumentQueue;
import com.training.model.entity.document.DocumentType;

public class MathInstitute extends AbstractInstitute {
	
	public MathInstitute(DocumentQueue queue){
		super(queue);
	}
	@Override
	public void accept() {
		try{
		while(queue.element().getType()==DocumentType.MATH){
			extractFromQueue();
		}
		}catch (NoSuchElementException e) {
			return;
		}

	}

}
