package edu.acc.java;

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

}
