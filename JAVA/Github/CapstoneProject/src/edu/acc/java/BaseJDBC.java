package edu.acc.java;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface BaseJDBC {
	/**
	 * 
	 * @return true if DB is available (Connection not null)
	 * 
	 */
	boolean isAvailable();

	/**
	 * 
	 * @param user valid MySQL user for Connection
	 */
	void setUser(String user);

	/**
	 * 
	 * @param pswd MySQL password for user for Connection
	 */
	void setPswd(String pswd);

	/**
	 * 
	 * @param query the SQL syntax query to execute
	 * @return ResultSet for given query 
	 * @throws SQLException
	 */
	ResultSet executeQuery(String query) throws SQLException;

	/**
	 * 
	 * @param query the SQL syntax query to execute
	 * @return int for number of rows affected
	 * @throws SQLException
	 */
	int executeUpdate(String query) throws SQLException;

}
