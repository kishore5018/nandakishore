package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpDetails {

	
	public static void fetchdata(Connection con) 
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from EmployeeDetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("UserName::::"+rs.getString(1));
				System.out.println("PassWord::::"+rs.getInt(2));
				System.out.println("Email:::::::"+rs.getString(3));
				System.out.println("\n");
			
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	
	public static void insertdata(Connection con) {
		
		try {
		System.out.println("Insert Employee Details :");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Name --");
		String EmpName=sc.next();
		System.out.println("Enter Employee Id --");
		String id=sc.next();
		System.out.println("Enter Company Name --");
		String comp=sc.next();
	
		PreparedStatement pstmt=con.prepareStatement("insert into EmployeeDetails (EmpName,EmpId,company) values(?,?,?)");
		pstmt.setString(1, EmpName);
		pstmt.setString(2, id);
		pstmt.setString(3, comp);
	
		int i=pstmt.executeUpdate();
		if(i==1)
		{
			System.out.println("Insert Success");
		}else
		{
			System.out.println("Insert Not Success");
		}	
		}	
		catch(Exception e){
		System.out.println(e);
	   }
		
		}
}
	



	

	

