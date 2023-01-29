package edu.acc.java;

import java.sql.Connection;
import java.sql.ResultSet;

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
}

