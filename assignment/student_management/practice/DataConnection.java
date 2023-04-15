package com.assignment.student_management.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	private final static String USERNAME="root";
	private final static String DATABASE_NAME="bank_management_system";
	private  final static String PASSWORD="";
	private  final static String DRIVER_NAME="com.mysql.jdbc.Driver";
	private  final static String URL="jdbc:mysql://localhost/";

	public static Connection getConnection() throws Exception{
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL+DATABASE_NAME, USERNAME, PASSWORD);
	}


}
