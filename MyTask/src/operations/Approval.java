package operations;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class Approval {

public static void Approve(Connection cn) {
	   int n=1;
		while(n>0)
		{
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println(" 1.User Login");
			System.out.println(" 2.Admin Login");
			System.out.println(" 3.Registration\n");
			
			System.out.println("Enter a digit:");
			System.out.print("_____________________\n");
			int value=sc.nextInt();
		     switch(value)
		     {
		case 1: 
			    System.out.println("User Login");
			    System.out.println("___________________\n");
			    System.out.println("Enter User Nmae :");
				String uname=sc.next();
				System.out.println("Enter Password :");
				
				String passwd=sc.next();
			
				PreparedStatement pst2=cn.prepareStatement("select*from EmployeeDetails where Register=? ");
				pst2.setString(1, "Approved");
			    ResultSet rs=pst2.executeQuery();
			    
			    HashSet hs=new HashSet();
				while(rs.next())
				{
					hs.add(rs.getString(1));
					hs.add(rs.getString(2));
				
				}
				
				if(hs.contains(uname) && hs.contains(passwd)){
				
			    	PreparedStatement pt=cn.prepareStatement("select*from EmployeeDetails where UserName=? AND Password=? ");
				   pt.setString(1, uname);
				   pt.setString(2, passwd);
			    	ResultSet rs4=pt.executeQuery();
			    
			    	System.out.println("Your Profile");
			    	while(rs4.next()) {
			    		System.out.println("[<--------------------------------------------------->]");
			    		System.out.println(" User Name		 : "+rs4.getString(1));
			    		
			    		System.out.println(" Email	 		 : "+rs4.getString(3));
			    		System.out.println(" Id      		 : "+rs4.getString(4));
			    		
						System.out.println(" Address 		 : "+rs4.getString(6));
						System.out.println(" Phone Number 	 : "+rs4.getInt(5));
			    		System.out.println("[<--------------------------------------------------->]\n");
						
			    	   }
			    }
			    
			    else
			    {
			    	System.out.println("invalid Details\n Or");
			    	System.out.println("Admin didn't give Permission to Access You Account,\n Please wait for Approval.");
			    	System.out.println("[<--------------------------------------------------->]\n");
					
			    }
			   
		        break;
		    	 
		 case 2:
			    System.out.println("Admin login");
			    System.out.println("___________________\n");
	    	    System.out.println("Enter Admin Username :");
				String Aun=sc.next();
				System.out.println("Enter Admin Password :");
				String pd=sc.next();
				
				if((Aun.equals("Admin") && pd.equals("Admin")) )
				{
	            String r1="Request";
				PreparedStatement pst1=cn.prepareStatement("select*from EmployeeDetails where Register=? ");
			    pst1.setString(1, "Request");
				ResultSet rs1=pst1.executeQuery();
			    
			    System.out.println(" list of Users ");
			    System.out.println("________________________________\n");
			    while(rs1.next()) {
				System.out.println("User name :"+rs1.getString(1));
				System.out.println("Email :"+rs1.getString(3));
				System.out.println("Id :"+rs1.getInt(4));
				System.out.println("Phone Number :"+rs1.getInt(5));
				System.out.println("Address :"+rs1.getString(6));
			    System.out.println("\n");
			    }
				System.out.println("Enter Id to Approve-:");
				int App=sc.nextInt();
				
				PreparedStatement pst3=cn.prepareStatement("update EmployeeDetails set Register=? where Id=? ");
				pst3.setString(1, "Approved");
				pst3.setInt(2, App);
				int j=pst3.executeUpdate();
				if(j==1){
					System.out.println("## Approved ##");
				}else{
					System.out.println("User Id is Not Valid.");
				}
				}
				else
				{
					System.out.println("invalid details.");
				
				}
				
	    	    break;
	     
	    case 3: System.out.println("Registration form");
	            System.out.println("~~~~~~~~~~~~~~~~~~~\n");
	    	    System.out.println("Enter your  Details ::");
	            System.out.println("___________________\n");
				System.out.println("Enter User Nmae : ");
				String un=sc.next();
				System.out.println("Enter Password : ");
				String pwd=sc.next();
				System.out.println("Enter Your Email : ");
				String email=sc.next();
				System.out.println("Enter Your Id : ");
				int id=sc.nextInt();
				System.out.println("Enter  Your Phone Number : ");
				int phno=sc.nextInt();
				System.out.println("Enter Your Address : ");
				String add=sc.next();
				
				PreparedStatement pst=cn.prepareStatement("insert into EmployeeDetails(Username,Password,Email,Id,Mobile_Number,Address,Register) values(?,?,?,?,?,?,?)");
				pst.setString(1,un);
				pst.setString(2,pwd);
				pst.setString(3,email);
				pst.setInt(4,id);
				pst.setInt(5,phno);
				pst.setString(6,add);
				pst.setString(7, "Request");
				int i=pst.executeUpdate();
				if(i==1) {
					System.out.println("Registration  Successfull.");
				}else {
					System.out.println("Not success");
				}
				break;
		       default :
		       {
		    	   System.out.println("This  Number is invalid!");
		    	   System.out.println("Please Enter valid digit 1 to 3\n");
		       }
				
		     }
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
			}
}
	
}
