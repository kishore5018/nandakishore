package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prepare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			System.out.println("Insert Operation");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the UserName::::::");
			String username=sc.next();
			System.out.println("Enter the PassWord::::::");
			String password=sc.next();
			System.out.println("Enter the Email:::::::::");
			String email=sc.next();
			System.out.println("Enter the Id::::::::::::");
			int id=sc.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
			PreparedStatement pstmt=c.prepareStatement("insert into empdata (password,email,id,username) values(?,?,?,?)");
			pstmt.setString(4, username);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			pstmt.setInt(3, id);
			int i=pstmt.executeUpdate();
			if(i==1){
				System.out.println("Insert Success");
			}else{
				System.out.println("Insert Not Success");
			}
			
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}

}

	