package com.opencart.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBD {
public static void main(String[] args) throws SQLException {
	ResultSet executeQuery = DatabaseUtils.executeQuery("select *from employees");

	while (executeQuery.next()) {
		
		  // process each row in the result set
        int empId = executeQuery.getInt("EMPLOYEE_ID");
        String firstName = executeQuery.getString("FIRST_NAME");
        String lastName = executeQuery.getString("LAST_NAME");
        double salary = executeQuery.getDouble("SALARY");
        System.out.println(empId + "\t" + firstName + "\t" + lastName + "\t" + salary);
   
		System.out.println(executeQuery.getString("EMPLOYEE_ID"));
		
	}
	
}
}
