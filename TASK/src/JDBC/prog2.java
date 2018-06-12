package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class prog2 {

	public static void insert() {
	try {	// TODO Auto-generated method stub;
		Scanner s=new Scanner(System.in);
		System.out.println("bankname");
		String bankname=s.next();
		System.out.println("balance");
		int balance=s.nextInt();
		System.out.println("address");
		String address=s.next();
		System.out.println("pincode");
		int pincode=s.nextInt();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
		PreparedStatement ps=c.prepareStatement("insert into bankdetails(bankname,balance,address,pincode) values(?,?,?,?)");
		ps.setString(1, bankname);
		ps.setInt(2, balance);
		ps.setString(3, address);
		ps.setInt(4, pincode);
		int i=ps.executeUpdate();
		if(i==1)
		{
			System.out.println("insert success");
		}
		else
		{
			System.out.println("insert failure");
		}
		
		
		
		
	
	}
		
		
		catch(Exception e) {
			System.out.println(e);
		
	}
	}
	

	public static void fetch() {
		// TODO Auto-generated method stub
	
				
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 				
			
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
			PreparedStatement ps=c.prepareStatement("select* from bankdetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("bankname ::::"+rs.getString("bankname"));
				System.out.println("balance::::"+rs.getInt("balance"));
				System.out.println("address:::"+rs.getString(3));
				
					System.out.println("pincode:::"+rs.getInt("pincode"));
			}
				}
catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println(e);
				
				
			}
}


	public static void update() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter bankname to update");
			String bankname=s.next();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
			PreparedStatement ps=c.prepareStatement("select * from bankdetails");
			ResultSet rs=ps.executeQuery();
			HashSet<String> hs=new HashSet<String> ();
			while(rs.next())
			{
				hs.add(rs.getString("bankname"));
			}
			if(hs.contains(bankname))
			{
				System.out.println("record found");
				System.out.println("enter the balance");
				int balance=s.nextInt();
				System.out.println("enter the address");
				String address=s.next();
				System.out.println("enetr the pincode");
				int pincode=s.nextInt();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
				PreparedStatement ps1=c1.prepareStatement("update bankdetails set balance=?,address=?,pincode=? where bankname=?");
				ps1.setInt(1,balance );
				ps1.setString(2, address);
				ps1.setInt(3, pincode);
				ps1.setString(4, bankname);
				int i=ps1.executeUpdate();
					if(i==1)	{
					System.out.println("update success");
						}
						else 
						{
							System.out.println("update not success");
						}
			}
			else{
				System.out.println("record not found");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

	public static void delete() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter the bankname to delete");
			String bankname=s.next();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
			PreparedStatement ps=c.prepareStatement("select * from bankdetails");
			ResultSet rs=ps.executeQuery();
			HashSet<String> hs=new HashSet<String> ();
			while(rs.next())
			{
				hs.add(rs.getString("bankname"));
			}
			if(hs.contains(bankname))
			{
				System.out.println("record found");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
					PreparedStatement ps1=c.prepareStatement("delete from bankdetails where bankname=? ");
					ps1.setString(1, bankname);
					int i=ps1.executeUpdate();
					if(i==1)
					{
						System.out.println("delete success");
					}
					else 
					{
						System.out.println("delete unsuccess");
					}	}
			
					else
					{
						System.out.println("record not found");
					}
					
			}
			catch(Exception e)
			{
				System.out.println(e);
				}
				
			
	}
}
			
			
			
		
				
						

		
	

	
			
		
			
			
		
			
		 
		
	
	

