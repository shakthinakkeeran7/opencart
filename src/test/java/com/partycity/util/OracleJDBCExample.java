package com.partycity.util;

import java.sql.*;

public class OracleJDBCExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
        String user = "hr";
        String password = "admin";

      
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            System.out.println(resultSet.next());
    }
}
