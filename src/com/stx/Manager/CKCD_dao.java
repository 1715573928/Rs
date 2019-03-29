package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.Sccp;

public class CKCD_dao {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	public ArrayList<Sccp> method()
	{
		ArrayList<Sccp> arr = new ArrayList<Sccp>();
		try {
			
			String sql="select * from system_menu";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Sccp s = new Sccp();
				s.setName(rs.getString("CAI_NAME"));
				s.setPrice(rs.getInt("CAI_PRICE"));
				s.setCai_class(rs.getString("CAI_CLASS"));
				s.setFilename(rs.getString("CAI_FILENAME"));
				s.setCai_id(rs.getInt("CAI_ID"));
				arr.add(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
	}
}
