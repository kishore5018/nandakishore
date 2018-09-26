package sallauddin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class registration {

	public static void data(Connection con) {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("1.User regestration");
			System.out.println("2.Admin Login.....");
			System.out.println("3.User Login.....");
			
			System.out.println("Enter Digit........");
			
			int value=sc.nextInt();
			
			switch(value) {
			
			case 1:
				
			    System.out.println("INSERT USER DETAILS");
				System.out.println("Enter studentname");
				
				String studentname=sc.next();
				System.out.println("Enter collegename");
				String collegename=sc.next();
				System.out.println("Enter marks");
				int marks=sc.nextInt();
				
				int percentage=(marks*100)/600;
				
				
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				//Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","raj","raj");
				PreparedStatement pst=con.prepareStatement("insert into student(studentname,collegename,marks,percentage,status) values(?,?,?,?,?)");
				pst.setString(1,studentname);
				pst.setString(2,collegename);
				pst.setInt(3,marks);
				pst.setInt(4,percentage);
				pst.setString(5,"not Approve");
				int i=pst.executeUpdate();
				if(i==1) {
					System.out.println("insert success");
				}else {
					System.out.println("insert not success");
				}
				
				
			case 2:
				System.out.println("Welcome to Admin");
				
				System.out.println("Enter the AdminName");
			    String name=sc.next();
			    System.out.println("Enter the password");
		    	String password=sc.next();
			
			    PreparedStatement pstmt=con.prepareStatement("select * from admin");
			    ResultSet rs=pstmt.executeQuery();
			    HashSet<String> hs=new HashSet<>();
			    while(rs.next())   {
				hs.add(rs.getString("name"));
				hs.add(rs.getString("password"));
			}
			
			    if(hs.contains(name)&&hs.contains(password)){
				
				PreparedStatement pst10=con.prepareStatement("select * from student where status='not Approve' ");

				
				ResultSet rs9=pst10.executeQuery();
				while(rs9.next())    {
			    System.out.println("studentnames:...................."+rs9.getString(1)+"     "+"collegename:...................."+rs9.getString(2)+"     "+"marks:...................."+rs9.getInt(3)+"     "+"percentage:...................."+rs9.getInt(4)+"     "+"status:...................."+rs9.getString(5));
					
					
				} 
				System.out.println("Enter studentname");
				
				String studentname1=sc.next();
				
				
			    PreparedStatement pstmt1=con.prepareStatement("update student set status=? where studentname=?");
					
			
				
			    pstmt1.setString(1, "approved");
					
					
				pstmt1.setString(2,studentname1);
				
				

					
				int j=pstmt1.executeUpdate();
				if(j==1){
					     System.out.println("Update Success");
	} else{
					     System.out.println(" Update not Success");
	}
				
				
	   }else{
				        System.out.println("Record Not Found");
		}
			
			
    case 3:
				
				
			System.out.println("Userlogin");
			System.out.println("User name");
			String uname=sc.next();
				
				
            PreparedStatement pst2=con.prepareStatement("select * from student");
            ResultSet rs2=pst2.executeQuery();
            HashSet hs2=new HashSet();
            while(rs2.next()) {
	
	
	        hs2.add(rs2.getString(1));
	
	
  }
           if(hs2.contains(uname)) {
	
	       PreparedStatement pst3=con.prepareStatement("select * from student where studentname=? ");
	       pst3.setString(1, uname);
	 
	      ResultSet rs5=pst3.executeQuery();
	      System.out.println("Result");
	      while(rs5.next()) {
		
		
		  System.out.println("status:........"+rs5.getString(5));
		
	
		
	}
	
}else {
	     System.out.println("username and password invalid");
}
				
			
			
			
			
	}	
			
		
			
		}catch(Exception e) {
		
		  System.out.println(e);
		
		}
	}
}
	
	