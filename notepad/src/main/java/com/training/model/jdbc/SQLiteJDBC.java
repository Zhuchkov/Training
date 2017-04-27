package com.training.model.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.model.Field;
import com.training.model.Note;
import com.training.model.exception.DataBaseExeption;
import com.training.model.exception.NicknameOccupiedException;

public class SQLiteJDBC {

	private static final String JDBC_SQLITE_TEST_DB = "jdbc:sqlite:test.db";
	public static void createNewDatabase() throws SQLException {

		String url = JDBC_SQLITE_TEST_DB;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
			}

		} catch (SQLException e) {
			throw e;
		}
	}

	public static void createNewTable() throws SQLException {
		// SQLite connection string
		String url = JDBC_SQLITE_TEST_DB;

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS notebook (" 
		+ "	id integer PRIMARY KEY,"
		+ "	firstname text NOT NULL,"
		+ "	lastname text NOT NULL,"
		+ "	phonenumber text NOT NULL,"
		+ "	nickname text NOT NULL UNIQUE"
		+ ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			throw e;
		}
	}
	private Connection connect() {
        // SQLite connection string
        String url = JDBC_SQLITE_TEST_DB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public void insert(Note note) throws NicknameOccupiedException, DataBaseExeption {
        String sql = "INSERT INTO notebook(firstname,lastname,phonenumber,nickname) VALUES(?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	int i=1;
        	for(Field field:note.getFields()){
        		pstmt.setString(i++,field.getFieldValue());
        	}
        	//TODO how to store Time and Date in databases???
        	//pstmt.setDate(i, note.getCreationDate());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
        	if(e.getMessage().contains("A UNIQUE constraint failed")){
        		throw new NicknameOccupiedException(e,note);
        	}else{
        		throw new DataBaseExeption(e,note);
        	}
        }
    }
	public void selectAll(){
        String sql = "SELECT * FROM notebook";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("firstname") + "\t" +
                                   rs.getString("lastname") + "\t" +
                                   rs.getString("phonenumber") + "\t" +
                                   rs.getString("nickname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
