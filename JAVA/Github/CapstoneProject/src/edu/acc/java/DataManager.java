package edu.acc.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ignored) {
            }
        }
    }
}

