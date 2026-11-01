package com.telusko;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {


    public static Connection getConnection() throws SQLException {
        // Establish the connection

        String url = "jdbc:mysql://localhost:3306/JDBC1";
        String user = "root";
        String password = "Ragini@123";
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection connection, Statement statement) throws SQLException {

        connection.close();
        statement.close();
    }
}


