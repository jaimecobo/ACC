package edu.acc.java;

import java.sql.Connection;

public class LocalMySQLCP implements PreparedBaseJDBC {

	private Connection conn;  // database Connection
	private String myDB = "jdbc:mysql://localhost:3306";  // local connection string
	private String user = "root";  // local user
	
}
