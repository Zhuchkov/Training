package com.training.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.training.model.DocumentQueue;
import com.training.model.entity.document.Document;
import com.training.model.entity.institute.BiologyInstitute;
import com.training.model.entity.institute.GeneralInstitute;
import com.training.model.entity.institute.MathInstitute;
import com.training.model.entity.producer.Producer;
import com.training.view.View;

public class Controller {
	View view;
	DocumentQueue queue = new DocumentQueue(25, 50);

	public Controller() {

	}

	public Controller(View view) {
		this.view = view;
	}

	public void launchApp() {
		new Thread(new Producer(queue)).start();
		BiologyInstitute inst = new BiologyInstitute(queue);
		GeneralInstitute inst2 = new GeneralInstitute(queue);
		MathInstitute inst3 = new MathInstitute(queue);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread( new InstituteTask(inst)).start();
		new Thread(new InstituteTask(inst2)).start();
		new Thread(new InstituteTask(inst3)).start();
//		while (!queue.isEmpty() || queue.getSize() > 0) {
//			ExecutorService ex = Executors.newSingleThreadExecutor();
//			ex.execute(biologyInstituteTask);
//			ex.execute(generalInstituteTask);
//			ex.execute(mathInstituteTask);
//			ex.shutdown();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
}
