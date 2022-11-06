package com.ravi.bank.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {
	Connection con=null;
	public Statement st=null;
	public DbConnection() {
		FileInputStream fis=null; 
		try 
		{
			fis= new FileInputStream("F:\\EclipseProject\\Banking System\\src\\com\\ravi\\bank\\resources\\db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver_class=p.getProperty("driverClass");
			String driver_url=p.getProperty("driverUrl");
			String user=p.getProperty("user");
			String password=p.getProperty("password");
			Class.forName(driver_class);
			con=DriverManager.getConnection(driver_url,user,password);
			st = con.createStatement();
		} 
		catch (ClassNotFoundException|SQLException|IOException e) 
		{
			e.printStackTrace();
		}
		
	 }
		
}


