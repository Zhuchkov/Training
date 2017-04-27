package com.training;
import java.sql.SQLException;

import com.training.controller.Controller;
import com.training.model.Notebook;
import com.training.model.jdbc.SQLiteJDBC;
import com.training.view.View;

public class Main {

	public static void main(String[] args){
		try {
			SQLiteJDBC.createNewDatabase();
			SQLiteJDBC.createNewTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Notebook notebook = new Notebook();
		View view = new View();
		Controller controller = new Controller(notebook, view);
		controller.process();
	}
}
