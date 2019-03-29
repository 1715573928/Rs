package com.stx.Manager;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.JdbcConnection.JdbcConnect;
import com.stx.Model.Sccp;

public class Rank_Dao {
	JdbcConnect jc=new JdbcConnect();
	Statement st=jc.Connect();
	/*µ„≤Õ≈≈––∞Ò*/
	public ArrayList<Sccp> method()
	{
		int[] arr = new int[100];
		int[] arr2 = new int[100];
		int i = 0;
		ArrayList<Sccp> list = new ArrayList<Sccp>();
		String sql="select count(cai_id),cai_id from system_sumoftable group by cai_id order by count(cai_id) desc";
		try {
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				arr[i]=rs.getInt("cai_id");
				arr2[i]=rs.getInt("count(cai_id)");
				i++;
			}
			for(int z = 0;z<arr.length;z++)
			{
				System.out.println(arr[z]);
				
			}
			System.out.println("=======================");
			for(int x = 0; x <8;x++)
			{
				String sql2="select cai_name,cai_filename from system_menu where cai_id="+arr[x]+"";
				ResultSet rs2 = st.executeQuery(sql2);
				while(rs2.next())
				{
				Sccp s = new Sccp();
				s.setName(rs2.getString("cai_name"));
				s.setFilename(rs2.getString("cai_filename"));
				s.setPrice(arr2[x]);
				list.add(s);
				}
			}
			for(int j = 0; j < list.size(); j++)
			{
				System.out.println(list.get(j).getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
