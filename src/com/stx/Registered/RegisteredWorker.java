package com.stx.Registered;

import java.sql.ResultSet;
import java.sql.Statement;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.RegisteredModel;

public class RegisteredWorker {
	
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	RegisteredModel wr=new RegisteredModel();
	/*注册功能*/
	public int Worker(RegisteredModel wr){
		
		int workerid=0;
		try {
			String Sql="insert into system_workerinfo(workerid,workername,workerpassword,workersex,workerdata,workerphonenumber,workerright) "
					+ "values(workerxl.nextval,'"+wr.getWorkerName()+"','"+wr.getWorkerPassword()+"','"+wr.getWorkerSex()+"','"+wr.getWorkerData()+"','"+wr.getWorkerPhoneNumber()+"','无权限')";
			st.executeUpdate(Sql);
			String Sql1="select workerid from system_workerinfo where workername='"+wr.getWorkerName()+"'";
			ResultSet rs=st.executeQuery(Sql1);
			while(rs.next()){
				
				workerid=rs.getInt("workerid");
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workerid;
	}
}
