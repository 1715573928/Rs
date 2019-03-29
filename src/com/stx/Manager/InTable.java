package com.stx.Manager;

import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.YCL;

public class InTable {
		
		JdbcConnect jc=new JdbcConnect();
		Statement st=jc.Connect();
		public void method(ArrayList<YCL> arr)
		{
			try {
				for(int i=0;i<arr.size();i++)
				{
					System.out.println(arr.get(i).getYcl_name());
				}
//				
//			ArrayList<YCL> arr=new ArrayList<YCL>();
				
//				String sql="insert into System_InTable values("+arr.get(i).getYcl_name()+")";
				for(int i=0;i<arr.size();i++)
				{
					String sql="insert into System_InTable values('"+arr.get(i).getYcl_name()+"',"+arr.get(i).getYcl_price()+","+arr.get(i).getYcl_number()+","+arr.get(i).getYcl_money()+",'"+arr.get(i).getYcl_time()+"')";
//			insert into System_InTable(ycl_name,ycl_price,ycl_num) values('°×²Ë',2,20)
					System.out.println(sql);
					st.executeUpdate(sql);
				}
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
