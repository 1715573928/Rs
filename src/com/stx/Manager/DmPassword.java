package com.stx.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stx.JdbcConnection.JdbcConnect;

public class DmPassword {

	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	
	public String ChangePassword(){
		
		int x=0;
		String randomcode = "";  
        String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";  
        char[] m = model.toCharArray();
        //System.out.println(m);
        for (int j=0;j<8 ;j++ )  
        {  
            char c = m[(int)(Math.random()*61)];  
            randomcode = randomcode + c;  
        }  
       // System.out.println(randomcode); 
		String Sql="update dynamicpassword set dmpassword='"+randomcode+"'";
		try {
			
			x=st.executeUpdate(Sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return randomcode;
	}
	
	public String PlasePwd(String pwd){
		
		String password="";
		String Sql="select dmpassword from dynamicpassword";
		try {
			ResultSet rs = st.executeQuery(Sql);
			while(rs.next()){
				
				password=rs.getString("dmpassword");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
}
