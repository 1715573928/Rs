package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.CashierModel;
import com.stx.Model.CookerPickUp;
import com.stx.Model.YCL_Out;


public class OutTable {
		
		ArrayList<CashierModel> CashierList=new ArrayList<CashierModel>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String time=df.format(new Date());// new Date()为获取当前系统时间 

		JdbcConnect jc=new JdbcConnect();
		Statement st=jc.Connect();
		public void method(ArrayList<YCL_Out> arr)
		{
			try {
//				for(int i=0;i<arr.size();i++)
//				{
//					System.out.println(arr.get(i).getOut_name());
//				}
//				
//			ArrayList<YCL> arr=new ArrayList<YCL>();
				
//				String sql="insert into System_InTable values("+arr.get(i).getYcl_name()+")";
				for(int i=0;i<arr.size();i++)
				{
					String sql="insert into System_InTable(ycl_name,ycl_num,ycl_time) values('"+arr.get(i).getOut_name()+"',"+arr.get(i).getOut_num()+",'"+arr.get(i).getOut_date()+"')";
					
//								insert into System_InTable(ycl_name,ycl_price,ycl_num) values('白菜',2,20)
					System.out.println(sql);
					st.executeUpdate(sql);
				}
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ArrayList<CookerPickUp> LookPickUp(){
			
			ArrayList<CookerPickUp> al=new ArrayList<CookerPickUp>();
			String Sql="select * from system_cookerpickup where cl_data='"+time+"'"; 
			try {
				ResultSet rt=st.executeQuery(Sql);
				while(rt.next()){
					
					CookerPickUp cp=new CookerPickUp();
					cp.setCl_id(rt.getInt("cl_id"));
					cp.setName(rt.getString("cl_name"));
					cp.setQuantity(rt.getInt("cl_quantity"));
					cp.setData(rt.getString("cl_data"));
					cp.setPeoplename(rt.getString("cl_people"));
					cp.setZhuangtai(rt.getString("cl_zhuangtai"));
					al.add(cp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
		
		public ArrayList<CookerPickUp> SeePickUp(String data){
			
			ArrayList<CookerPickUp> all=new ArrayList<CookerPickUp>();
			String Sql="select * from system_cookerpickup where cl_data='"+data+"'";
			try {
				ResultSet rt=st.executeQuery(Sql);
				while(rt.next()){
					
					CookerPickUp cp=new CookerPickUp();
					cp.setName(rt.getString("cl_name"));
					cp.setQuantity(rt.getInt("cl_quantity"));
					cp.setData(rt.getString("cl_data"));
					cp.setPeoplename(rt.getString("cl_people"));
					cp.setZhuangtai(rt.getString("cl_zhuangtai"));
					all.add(cp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return all;
		}
		
		public int GgZt(ArrayList<YCL_Out> arr){
			
			int x=0;
			for(int i=0;i<arr.size();i++){
				
				String Sql="update SYSTEM_COOKFINDPU set ycl_zhuangtai='正在路上' where ycl_name='"+arr.get(i).getOut_name()+"'";
				String Sql2="update SYSTEM_COOKERPICKUP set cl_zhuangtai='已发送' where cl_name='"+arr.get(i).getOut_name()+"'";

				try {
					x=st.executeUpdate(Sql);
					st.executeUpdate(Sql2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				return x;
		}
		
		public int ChangeZhuangtai(int clid,String beizhu){
			
			int x=0;
			String Sql="update SYSTEM_COOKFINDPU set ycl_zhuangtai='"+beizhu+"' where ycl_id="+clid+"";
			String Sql2="update SYSTEM_COOKERPICKUP set cl_zhuangtai='"+beizhu+"' where cl_id="+clid+"";
			try {
				x=st.executeUpdate(Sql);
				st.executeUpdate(Sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return x;	
		}
}
