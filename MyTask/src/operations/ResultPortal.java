package operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class ResultPortal {
	
	public static void details(Connection cn) {
		
		int n=1;
		while(n>0)
		{
			
	try {
		
		   Scanner sc=new Scanner(System.in);
			
			System.out.println(" 1.User Login");
			System.out.println(" 2.Admin Login");
			
			System.out.println("Enter a digit:");
			System.out.print("_____________________\n");
			int value=sc.nextInt();
		   
		 switch(value)
		 {
		 
		 case 1:
			 System.out.println("User Login");
			 System.out.println("______________\n");
			 System.out.println("Enter User Name :");
				String uname=sc.next();
				System.out.println("Enter Password :");
				String passwd=sc.next();
				
				PreparedStatement pst2=cn.prepareStatement("select*from Admin  ");
			  
				
				ResultSet rs=pst2.executeQuery();
			    HashSet hs=new HashSet();
				while(rs.next())
				{
					hs.add(rs.getString(1));
					hs.add(rs.getString(2));
				
				}
				
				if(hs.contains(uname) && hs.contains(passwd))
				{
				  
			    	PreparedStatement ps1=cn.prepareStatement("select * from Admin where StudentName=? And Password=? ");
			    	ps1.setString(1, uname);
			      	ps1.setString(2, passwd);
			    	ResultSet rs4=ps1.executeQuery();
				    
			    	System.out.println("Your Result");
			    	while(rs4.next()) {
			    		System.out.println("[<--------------------------------------------------->]");
			    		     int   sub1=rs4.getInt(3);
			    		     int   sub2=rs4.getInt(4);
			    		     int   sub3=rs4.getInt(5);
			    		     int   sub4=rs4.getInt(6);
			    		     int   sub5=rs4.getInt(7);
			    		     int   sub6=rs4.getInt(8);
			    		     int   Total=sub1+sub2+sub3+sub4+sub5+sub6;
			    		     float  per=(Total*100)/600;
			    		    System.out.println("C Programming : "+sub1);
			 				
			 				System.out.println("Java Programming : "+sub2);
			 				
			 				System.out.println("Phython : "+sub3);
			 				
			 				System.out.println(" #.net : "+sub4);
			 			
			 				System.out.println(" Oracle : "+sub5);
			 				
			 				System.out.println("Hibernate : "+sub6);
		 				    System.out.println("Total Marks : "+Total);
		 				    System.out.println("Percentage : "+per);
			 				
			 			System.out.println("[<--------------------------------------------------->]\n");
						
			    	   }
			    }
			    else
			    {
			    	System.out.println("Username Or Password are wrong.");
			    }
			    break;
		 case 2:
			 
			    System.out.println("Enter Admin User name : ");
			
				String un=sc.next();
				System.out.println("Enter Admin  Password :");
				String pwd=sc.next();
				
				PreparedStatement ps2=cn.prepareStatement("select*from Adminlogin  ");
			    ResultSet rs2=ps2.executeQuery();
			    
			    HashSet hs2=new HashSet();
				while(rs2.next())
				{
					hs2.add(rs2.getString(1));
					hs2.add(rs2.getString(2));
				
				}
				
				if(hs2.contains(un) && hs2.contains(pwd)){
			
				System.out.println("Welcome Admin.\n");
				
			    System.out.println("Enter Student name : ");
				
					String usn=sc.next();
					System.out.println("Enter   Password :");
					String pwdd=sc.next();
				
				System.out.println("Enter Student Marks");
				System.out.println("______________________________\n");
				System.out.print("C Programming : ");
				int s1=sc.nextInt();
				System.out.print("Java Programming : ");
				int s2=sc.nextInt();
				System.out.print("Phython : ");
				int s3=sc.nextInt();
				System.out.print(" #.net : ");
				int s4=sc.nextInt();
				System.out.print(" Oracle : ");
				int s5=sc.nextInt();
				System.out.print("Hibernate : ");
				
			
				int s6=sc.nextInt();
				int total;
				
				PreparedStatement ps=cn.prepareStatement("insert into Admin(StudentName,Password,sub1,sub2,sub3,sub4,sub5,sub6) values(?,?,?,?,?,?,?,?) ");
				ps.setString(1, usn);
				ps.setString(2, pwdd);
				ps.setInt(3, s1);
				ps.setInt(4, s2);
				ps.setInt(5, s3);
				ps.setInt(6, s4);
				ps.setInt(7, s5);
				ps.setInt(8, s6);
				int j=ps.executeUpdate();
				if(j==1) {
					System.out.println(" ## Successfully inserted Data ##.");
					System.out.println("______________________________\n");
				}else {
					System.out.println("Not success");
				}
				}else
				{
					System.out.println("User name or Password are invalid.\n Please Enter Valid details.");
					System.out.println("______________________________\n");
				}
				
				break;
		     default :
		    	 System.out.println("invalid digit you have Entered \n  Please Enter correct Details.");
					System.out.println("______________________________\n");
		 }
		
		
			
	}catch(Exception e) {
		System.out.println(e);
	}
		}
	}	
}

