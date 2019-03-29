package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.stx.JdbcConnection.*;
import com.stx.Model.*;




public class Cashier {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	ArrayList<CashierModel> CashierList=new ArrayList<CashierModel>();
	SimpleDateFormat df = new SimpleDateFormat("HHmm");//设置日期格式
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	 String Data=sdf.format(new Date());// new Date()
	int time=Integer.parseInt(df.format(new Date()));// new Date()为获取当前系统时间 

	/*点菜功能*/
	public int DianCai(int cai,int table){
		
		int x=0;
		try{
			String Sql="insert into System_OrderTable values("+cai+","+table+","+time+")";
			String Sql1="insert into SYSTEM_SUMOFTABLE values(sum_xl.nextval,"+cai+","+table+",'"+Data+"')";
			String Sql2="insert into system_cookerordertable values("+cai+","+table+","+time+",cookermake.nextval)";
			x=st.executeUpdate(Sql);
			st.executeUpdate(Sql1);
			st.executeUpdate(Sql2);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return x;
	}
	/*输入点菜的桌号，显示所点的菜及相应价格，算出总价格*/
	public ArrayList<CashierModel> SeeJeZhang(int tableid){
		

		try{

			String Sql="select system_menu.cai_name,system_menu.cai_price from system_menu,system_ordertable where system_ordertable.cai_id=system_menu.cai_id and system_ordertable.table_id="+tableid+"";
			ResultSet rs = st.executeQuery(Sql);
			while (rs.next()) {

				CashierModel cm = new CashierModel();
				cm.setCaiName(rs.getString("cai_name"));
				cm.setCaiPrice(rs.getInt("cai_price"));
				CashierList.add(cm);
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return CashierList;
	}
	
	public int Jiezhang(int tableid){
		
		int y=0;
		try{
			String Sqldelete="delete from system_ordertable where table_id="+tableid+"";
			y=st.executeUpdate(Sqldelete);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return y;
	}
}
