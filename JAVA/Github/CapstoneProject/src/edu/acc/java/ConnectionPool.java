package edu.acc.java;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;
	
	private ConnectionPool(){
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/hotels360");	
		}
		catch(NamingException e){
			System.out.println(e);
		}
	}
	
	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public Connection getConnection() {

		try {
			return dataSource.getConnection();
		}
		catch (SQLException ex) {
			printTrace(ex);
			return null;
		}
	}  

	public void freeConnection(Connection c) {
		try {
			c.close();
		}
		catch (SQLException ex) {
		printTrace(ex);
		}
	}
	

	public void printTrace(SQLException ex) {
		for (Throwable t : ex) {
			t.printStackTrace(System.out);  // stack trace to console
		}
	}

}
