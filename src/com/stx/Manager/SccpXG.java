package com.stx.Manager;

import java.sql.*;


import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.Sccp;

public class SccpXG {
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	public int method(Sccp s)
	{
//		System.out.println(s.getName());
//		System.out.println(s.getPrice());
//		System.out.println(s.getFilename());
		int i =0;
		try {
			
			String sql="update system_menu set CAI_PRICE="+s.getPrice()+",CAI_NAME='"+s.getName()+"',CAI_filename='"+s.getFilename()+"'WHERE cai_id="+s.getCai_id()+"";
			i = st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
