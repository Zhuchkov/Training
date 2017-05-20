package com.training.model.entity.institute;

import java.util.Random;

import com.training.model.DocumentQueue;

public class GeneralInstitute extends AbstractInstitute {

	public GeneralInstitute(DocumentQueue queue) {
		super(queue);

	}

	@Override
	public void accept() {
		while (!queue.isEmpty() || queue.getSize() > 0) {
			Random random = new Random();
			for (int i = 0; i < random.nextInt(5); i++) {
				extractFromQueue();
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
