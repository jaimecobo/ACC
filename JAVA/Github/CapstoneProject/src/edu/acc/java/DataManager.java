package edu.acc.java;

import java.sql.Connection;
import java.sql.SQLException;

public class DataManager
{
    protected void close(Connection connection)
    {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {
            }
        }
    }

    protected void close(Statement statement)
    {
        
    }
}

