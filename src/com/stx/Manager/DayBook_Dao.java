package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.DayBookModel;
import com.stx.Model.DayBookModel2;

public class DayBook_Dao {
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	/*流水账功能*/
	public ArrayList<DayBookModel> method()
	{
        String sql="select sum(cai_price),order_date from  system_sumoftable,system_menu where system_sumoftable.cai_id=system_menu.cai_id group by system_sumoftable.order_date order by system_sumoftable.order_date desc ";
		ArrayList<DayBookModel> list = new ArrayList<DayBookModel>();
		try {
			ResultSet rs=st.executeQuery(sql);

			while(rs.next())
			{
				DayBookModel dbm=new DayBookModel();
				dbm.setMoney(rs.getInt("sum(cai_price)"));
				dbm.setDate(rs.getString("order_date"));
				list.add(dbm);
			}
			//System.out.println("===================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i<list.size();i++)
		{
			System.out.println(list.get(i).getMoney());
			System.out.println(list.get(i).getDate());
		}
		System.out.println("-----------------------------------------");
		return list;
		
	}
	public ArrayList<DayBookModel2> method2()
	{
		String sql2="select sum(ycl_money),ycl_time from system_intable group by ycl_time order by ycl_time desc";
		ResultSet rs2;
		 ArrayList<DayBookModel2> list2 = new ArrayList<DayBookModel2>();
		try {
			rs2 = st.executeQuery(sql2);
			while(rs2.next())
			{
				DayBookModel2 dbm2=new DayBookModel2();
				dbm2.setYcl_money(rs2.getInt("sum(ycl_money)"));
				dbm2.setTime(rs2.getString("ycl_time"));
				list2.add(dbm2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i<list2.size();i++)
		{
			System.out.println(list2.get(i).getYcl_money());
			System.out.println(list2.get(i).getTime());
		}
		return list2;
		
	}
}
