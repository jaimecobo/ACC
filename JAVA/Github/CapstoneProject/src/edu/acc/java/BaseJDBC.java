package edu.acc.java;

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

}
