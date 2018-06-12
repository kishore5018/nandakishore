package TASK2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class prog2 {
	
		public static void arvind()
		{
		try {	// TODO Auto-generated method stub;
			Scanner s =new Scanner(System.in);
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
			PreparedStatement ps=c.prepareStatement("insert into bankdetails1(bankname,balance,address,pincode) values(?,?,?,?)");
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

	 
		// TODO Auto-generated method stub
		
	

	public static void update() {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter bankname to update");
			String bankname=s.next();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
			PreparedStatement ps=c.prepareStatement("select * from bankdetails1");
			ResultSet rs=ps.executeQuery();
		HashSet<String> hs=new HashSet<String> ();
		while(rs.next()) 
		{		
			
			hs.add(rs.getString("bankname"));
		}
		
		if(hs.contains(bankname))
		{
			System.out.println("record found");
		
			
			
				System.out.println("Enter new bankname");
				String bankname1=s.next();
				String bankname2=bankname.replace(bankname, bankname1);
				
				
				System.out.println("enter the balance");
				int balance=s.nextInt();
				System.out.println("enter the address");
				String address=s.next();
				System.out.println("enetr the pincode");
				int pincode=s.nextInt();
		
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
				PreparedStatement ps1=c1.prepareStatement("update bankdetails1 set balance=?,address=?,pincode=?,bankname=?");
								ps1.setInt(1,balance );
				ps1.setString(2, address);
				ps1.setInt(3, pincode);
				ps1.setString(4, bankname2);
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
}
	
		

	

	
	


