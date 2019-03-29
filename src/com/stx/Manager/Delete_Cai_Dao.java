package com.stx.Manager;

import java.sql.*;

import com.stx.JdbcConnection.JdbcConnect;

public class Delete_Cai_Dao {
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	public int method(String name)
	{
		int i=0;
		try {
		
			String sql = "delete from system_menu where CAI_FILENAME='"+name+"'";
			i = st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
