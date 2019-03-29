package com.stx.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnect {
	
	Statement st=null;
	Connection con=null;
	public Statement Connect(){
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","stx12","stx");
			st=con.createStatement();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	return st;
	}
	
	public void Close(){
		
		try{
			st.close();
			con.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
}
