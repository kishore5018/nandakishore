

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class update {

	public static void updateData(Connection cn) {
	
		try{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Id to Update : ");
			System.out.println("____________________________\n");
			int id=sc.nextInt();
			PreparedStatement ps=cn.prepareStatement("select * from EmployeeDetails");
			ResultSet rs=ps.executeQuery();
			HashSet hs=new HashSet();
			while(rs.next()){
				hs.add(rs.getInt("Id"));
			}
			
			if(hs.contains(id)){
				System.out.println("Record Found.");
				
				
				System.out.println("Enter User Name : ");
				String un=sc.next();
				System.out.println("Enter Password :");
				String pwd=sc.next();
				System.out.println("Enter  Email :");
				String email=sc.next();
				System.out.println("Enter  Id :");
				int id1=sc.nextInt();
				
				PreparedStatement pst=cn.prepareStatement("update EmployeeDetails set Username=? ,Password=?,Email=? where Id=? ");
				pst.setString(1, un);
				pst.setString(2, pwd);
				pst.setString(3, email);
				pst.setInt(4, id);
				int i=pst.executeUpdate();  
				
				PreparedStatement pst1=cn.prepareStatement("update EmployeeDetails set Id='"+id1+"' where Username='"+un+"' ");
			
				int j=pst1.executeUpdate();
				if(i==1 && j==1){
					System.out.println("Update Success");
				}else{
					System.out.println("Update Not Success");
				}
				
				
			}else{
				System.out.println("Record Not Found");
			}
			
			
		}catch(Exception e){
			System.out.println(e); 
			
		}
		
	}
}
