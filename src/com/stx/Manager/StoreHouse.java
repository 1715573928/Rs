package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.StoreHouse_Model;

public class StoreHouse {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	
	public ArrayList<StoreHouse_Model> method2()
	{		
		ArrayList<StoreHouse_Model> arr = new ArrayList<StoreHouse_Model>();
		try {
			
			String sql ="select ycl_name,sum(ycl_num) from System_InTable group by ycl_name";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				StoreHouse_Model shm=new StoreHouse_Model();
				shm.setName(rs.getString("ycl_name"));
				shm.setNum(rs.getInt("sum(ycl_num)"));
				arr.add(shm);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

}

