package TASK1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PROG2 {
	
	
	
	public static void arvind(Connection c) {
		
		
		
			Scanner s=new Scanner(System.in);
			System.out.println("ename");
			String ename=s.next();
			System.out.println("esalary");
			int esalary=s.nextInt();
			System.out.println("edomain");
			String edomain=s.next();
			System.out.println("eid");
			int eid=s.nextInt();
			
			try {
				PreparedStatement ps = c.prepareStatement("insert into empdetails(ename,esalary,edomain,eid) values(?,?,?,?)");
			
					
			ps.setString(1, ename);
			ps.setInt(2,esalary);
			ps.setString(3, edomain);
			ps.setInt(4, eid);
			int i=ps.executeUpdate();
			if(i==1)
			{
				System.out.println("insertion done");
			}
			else
			{
				System.out.println("insertion not yet done");
			}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
	}
			 
	}

	public static void arvind1(Connection c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=c.prepareStatement("select * from empdetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				System.out.println("esalary...."+rs.getInt("esalary"));
				System.out.println("edomain....."+rs.getString("edomain"));
				System.out.println("eid...."+rs.getInt("eid"));
				System.out.println("ename...." +rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
			


	
}
	
			

				
					
				
			
		

