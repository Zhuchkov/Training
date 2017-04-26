package com.training;
import com.training.controller.Controller;
import com.training.model.Notebook;
import com.training.model.jdbc.SQLiteJDBC;
import com.training.view.View;

public class Main {

	public static void main(String[] args){
		SQLiteJDBC.createNewDatabase();
		SQLiteJDBC.createNewTable();
		Notebook notebook = new Notebook();
		View view = new View();
		Controller controller = new Controller(notebook, view);
		controller.process();
	}
}
