package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.RegisteredModel;

public class SuperManager {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	RegisteredModel rm=new RegisteredModel();
	ArrayList<RegisteredModel> list=new ArrayList<RegisteredModel>();
	//查询所有员工信息
	public ArrayList<RegisteredModel> LookWorker(){
		
		String Sql="select * from system_workerinfo";
		try {
			ResultSet rs = st.executeQuery(Sql);
			while(rs.next()){
				
				RegisteredModel rm=new RegisteredModel();
				rm.setWorkerid(rs.getInt("workerid"));
				rm.setWorkerName(rs.getString("workername"));
				rm.setWorkerSex(rs.getString("workersex"));
				rm.setWorkerData(rs.getString("workerdata"));
				rm.setWorkerPhoneNumber(rs.getString("workerphonenumber"));
				rm.setWorkerright(rs.getString("workerright"));
				rm.setStatus(rs.getString("status"));
				rm.setWage(rs.getInt("wage"));
				list.add(rm);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	//给新员工赋权限
	public int GiveAuthority(int workerid,String Authority){
		
		int ReturnAuthority=0;
		String Sql="update system_workerinfo set workerright='"+Authority+"' where workerid="+workerid+"";
		try {
			ReturnAuthority=st.executeUpdate(Sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReturnAuthority;
	}
	
	public void ModifyInfo(int workerid,String username,String sex,String workerdata,String phonenumber,int workwage){
		
		String Sql="update system_workerinfo set workername='"+username+"',workersex='"+sex+"',workerdata='"+workerdata+"',workerphonenumber='"+phonenumber+"',wage="+workwage+" where workerid="+workerid+"";
		try {
			st.executeUpdate(Sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SeeAllMoney(){
		


	
	}	
}
