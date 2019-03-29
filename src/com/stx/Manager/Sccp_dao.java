package com.stx.Manager;

import java.sql.Statement;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.Sccp;

public class Sccp_dao {

	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	public int method3(Sccp s)
	{
		int x = 0;
		try {
			
			String sql = "insert into system_menu values (menu_xl.nextval,'"+s.getName()+"',"+s.getPrice()+",'"+s.getCai_class()+"','"+s.getFilename()+"')";
			x = st.executeUpdate(sql);
			//System.out.println("xxxxxxxxxxxxxxxx"+x);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
}
