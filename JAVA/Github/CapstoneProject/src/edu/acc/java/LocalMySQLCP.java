package edu.acc.java;

import java.sql.Connection;

public class LocalMySQLCP implements PreparedBaseJDBC {

	private Connection conn;  // database Connection
	private String myDB = "jdbc:mysql://localhost:3306";  // local connection string
	private String user = "root";  // local user
	private String pswd = "sesame"; // local MySQL root passwd
	public LocalMySQLCP() {
		this.conn = connectionPool();  // if needed, user can alter userid/password and call openDB()
	}
	
}
