package com.stx.Manager;

import java.sql.SQLException;
import java.sql.Statement;

import com.stx.JdbcConnection.JdbcConnect;

public class StatusOut {
	
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	public void PeopleOut(String username){
		
		String Sql="update System_WorkerInfo set status='ÒÑÏÂ°à' where WorkerName='"+username+"'";
		try {
			st.executeUpdate(Sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
