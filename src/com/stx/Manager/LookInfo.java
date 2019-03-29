package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.RegisteredModel;


public class LookInfo {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	ArrayList<RegisteredModel>  wi=new ArrayList<RegisteredModel>();
	public ArrayList<RegisteredModel> Loofoo(int workerid){
		
	String Sql="select * from system_workerinfo where workerid='"+workerid+"'";
		try {
			ResultSet rs = st.executeQuery(Sql);
			while(rs.next()){
				
				RegisteredModel wk=new RegisteredModel();
				wk.setWorkerid(rs.getInt("workerid"));
				wk.setWorkerName(rs.getString("workername"));
				wk.setWorkerPassword(rs.getString("workerpassword"));
				wk.setWorkerSex(rs.getString("workersex"));
				wk.setWorkerData(rs.getString("workerdata"));
				wk.setWorkerPhoneNumber(rs.getString("workerphonenumber"));
				wk.setStatus(rs.getString("status"));
				wi.add(wk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wi;
	}
}
