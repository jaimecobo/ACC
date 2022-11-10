package edu.acc.java;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * Utility JBDC accessor class.
 * This version supports PreparedStatement
 *
 */
public interface PreparedBaseJDBC extends BaseJDBC {

	@Deprecated
	ResultSet executeQuery(String query) throws SQLException;
	
}
