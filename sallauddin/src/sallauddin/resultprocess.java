package sallauddin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class resultprocess {

	public static void data(Connection con) {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc=new Scanner(System.in);
			
			
			System.out.println("1.Admin Login.....");
			System.out.println("2.User Login.....");
			
			System.out.println("Enter Digit........");
			
			int value=sc.nextInt();
			
			
			switch(value) {
			
			case 1:
				System.out.println("Welcome to Admin");
			
				System.out.println("Enter the AdmiName");
			String adminusername=sc.next();
			System.out.println("Enter tha AdminPassword");
			int adminpassword=sc.nextInt();
			PreparedStatement pst=con.prepareStatement("select * from admin");
			ResultSet rs=pst.executeQuery();
			HashSet hs=new HashSet();
			while(rs.next()) {
				
				hs.add(rs.getString(1));
				hs.add(rs.getInt(2));
				
				
				
			}
			
			
			if(hs.contains(adminusername)&&hs.contains(adminpassword)) {
				System.out.println("record found");
			
				
				System.out.println("Enter studentname");
				String un=sc.next()
;
				System.out.println("Enter tha Password");
				int psw=sc.nextInt()
;
				System.out.println("Enter marks");
				System.out.println("c");
				int s1=sc.nextInt()
;
				System.out.println("java");
				int s2=sc.nextInt();
				System.out.println("python");
				int s3=sc.nextInt();
				System.out.println("hadoop");
				int s4=sc.nextInt();
				System.out.println("js");
				int s5=sc.nextInt();
				
				PreparedStatement pst1=con.prepareStatement("insert into student(studentname,password,sub1,sub2,sub3,sub4,sub5)values(?,?,?,?,?,?,?)");
				pst1.setString(1, un);
				pst1.setInt(2, psw);
				
				pst1.setInt(3, s1);
				pst1.setInt(4, s2);
				
				pst1.setInt(5, s3);
				
				pst1.setInt(6, s4);
				
				pst1.setInt(7, s5);
				
				int j=pst1.executeUpdate();
				if(j==1) {
					
					
					System.out.println("success");
					
					
				}else {
					System.out.println("not success");
				}
				
				
				
				
			}else {
				System.out.println("record not found ");
				System.out.println("enter the correct username and password");
			}
			
			break;
			case 2:
				System.out.println("Userlogin");
				System.out.println("User name");
				String uname=sc.next();
				System.out.println("password");
				int pd=sc.nextInt();
				
PreparedStatement pst2=con.prepareStatement("select * from student");
ResultSet rs2=pst2.executeQuery();
HashSet hs2=new HashSet();
while(rs2.next()) {
	
	
	hs2.add(rs2.getString(1));
	hs2.add(rs2.getInt(2));	
	
}
if(hs2.contains(uname)&&hs2.contains(pd)) {
	
	PreparedStatement pst3=con.prepareStatement("select * from student where studentname=? and password=?");
	pst3.setString(1, uname);
	pst3.setInt(2, pd);
	ResultSet rs5=pst3.executeQuery();
	System.out.println("Result");
	while(rs5.next()) {
		
		int sub1=rs5.getInt(3);
		int sub2=rs5.getInt(4);
		int sub3=rs5.getInt(5);
		
		int sub4=rs5.getInt(6);
		
		
		int sub5=rs5.getInt(7);
		
		int total=sub1+sub2+sub3+sub4+sub5;
		float percentage=total*(100)/500;
		
		System.out.println("c:"+sub1);
		
		
		System.out.println("java:"+sub2);
		
		System.out.println("python:"+sub3);
		
		System.out.println("hadoop:"+sub4);
		
		System.out.println("js:"+sub5);
		
		System.out.println("TotalMarks:"+total);
		System.out.println("percentage:"+percentage);
		
		
	}
	
}else {
	System.out.println("username and password invalid");
}
break;

	default:
		System.out.println("invalid digits");
			
			}
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
