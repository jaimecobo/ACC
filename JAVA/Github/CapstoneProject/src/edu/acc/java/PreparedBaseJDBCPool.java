package edu.acc.java;

public interface PreparedBaseJDBCPool extends PreparedBaseJDBC {
	
	@Deprecated
	void setUser(String user);
	
}
