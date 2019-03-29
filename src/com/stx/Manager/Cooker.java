package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.CashierModel;
import com.stx.Model.CookerFinfModel;
import com.stx.Model.CookerModel;





public class Cooker {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	ArrayList<CashierModel> CashierList=new ArrayList<CashierModel>();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	String time=df.format(new Date());// new Date()为获取当前系统时间 
	/*厨师查看点菜菜单*/
	public ArrayList<CookerModel> LookMenu(){
		
		
		ArrayList<CookerModel> sm1 = new ArrayList<CookerModel>();
		try{
			String Sql="select system_cookerordertable.cookermakecai,system_menu.cai_name,system_cookerordertable.table_id,system_cookerordertable.order_time from system_cookerordertable,system_menu where system_menu.cai_id=system_cookerordertable.cai_id";
			ResultSet rt=st.executeQuery(Sql);
			while(rt.next()){
				
				CookerModel cm=new CookerModel();
				cm.setCookermakecai(rt.getInt("cookermakecai"));
				cm.setTableid(rt.getInt("table_id"));
				cm.setCainame(rt.getString("cai_name"));
				cm.setTime(rt.getInt("order_time"));
				sm1.add(cm);
			}
			jc.Close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
		Collections.sort(sm1,new SortByAge());  
		return sm1;
		
	}
	
class SortByAge implements Comparator {
		

	    public int compare(Object o1, Object o2) {
	    	CookerModel s1 = (CookerModel) o1;
	    	CookerModel s2 = (CookerModel) o2;
	    	  if (s1.getTime() > s2.getTime()){
	            return 1;
	           }else{
	           return -1;
	         }
	    }
	}
	
	public int MakeFinish(int CookMakeCai){
		
		int x=0;
		String Sql="delete from system_cookerordertable where cookermakecai="+CookMakeCai+"";
		try {
			
			x=st.executeUpdate(Sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	public int pickup(String name,int quantity,String people){
		
		int x=0;
		try{
			String Sql="insert into system_cookerpickup values('"+name+"',"+quantity+",'"+time+"','"+people+"','请尽快审核',findsum.nextval)";
			String Sql2="insert into SYSTEM_COOKFINDPU values('"+name+"',"+quantity+",'"+time+"','"+people+"','审核中',find_xl.nextval)";
			x=st.executeUpdate(Sql);
			st.executeUpdate(Sql2);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return x;
	}
	
	public ArrayList<CookerFinfModel> findpickup(){
		
		ArrayList<CookerFinfModel> listt=new ArrayList<CookerFinfModel>();
		String Sql="select * from SYSTEM_COOKFINDPU";
		try {
			ResultSet rt=st.executeQuery(Sql);
			while(rt.next()){
				
				CookerFinfModel cf=new CookerFinfModel();
				cf.setPk_id(rt.getInt("ycl_id"));
				cf.setYcl_name(rt.getString("ycl_name"));
				cf.setYcl_quantity(rt.getInt("ycl_quantity"));
				cf.setYcl_data(rt.getString("ycl_data"));
				cf.setYcl_people(rt.getString("ycl_people"));
				cf.setYcl_zhuangtai(rt.getString("ycl_zhuangtai"));
				listt.add(cf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listt;
	}
	
	public int updatepickup(int id,String name,int quantity,String people){
		
		int x=0;
		String ycl_zhuangtai="";
		String Sql="select ycl_zhuangtai from system_cookfindpu where ycl_id="+id+"";
		try {
			ResultSet rt=st.executeQuery(Sql);
			while(rt.next()){
				
				ycl_zhuangtai=rt.getString("ycl_zhuangtai");
			}
			System.out.println(ycl_zhuangtai);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!(ycl_zhuangtai.equals("正在路上"))){
			
			String Sql2="update system_cookfindpu set ycl_name='"+name+"',ycl_quantity="+quantity+",ycl_people='"+people+"' where ycl_id="+id+"";
			String Sql3="update SYSTEM_COOKERPICKUP set cl_name='"+name+"',cl_quantity="+quantity+",cl_people='"+people+"' where cl_id="+id+"";
			try {
				x=st.executeUpdate(Sql2);
				st.executeUpdate(Sql3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return x;
		}else{
			
			return x;
		}
		
	}
	
	public int deletepickup(int id){
		
		int x=0;
		String Sql="delete from system_cookfindpu where ycl_id="+id+"";
		String Sql2="update SYSTEM_COOKERPICKUP set cl_zhuangtai='已送达' where cl_id="+id+"";
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
