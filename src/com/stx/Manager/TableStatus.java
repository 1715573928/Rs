package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;

public class TableStatus {
	
	public ArrayList<Integer> Table(){
		
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		JdbcConnect jc=new JdbcConnect();
		Statement st=jc.Connect();
		String Sql="select table_id from System_OrderTable group by table_id";
		try {
			
			ResultSet rs = st.executeQuery(Sql);
			while(rs.next()){
				
				list.add(rs.getInt("table_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
