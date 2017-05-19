package com.training.controller;

import com.training.model.entity.institute.AbstractInstitute;

public class InstituteTask implements Runnable {
	
	AbstractInstitute inst;

	public InstituteTask(AbstractInstitute inst) {
		this.inst = inst;
	}

	@Override
	public void run() {
		inst.accept();
		
	}

}
