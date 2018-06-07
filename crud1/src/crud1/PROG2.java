package crud1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class PROG2 {

	public static void insert() {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("bankname");
			String bankname=s.next();
			System.out.println("balance");
			int balance=s.nextInt();
			System.out.println("pincode");
			 int pincode=s.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
			PreparedStatement pstmt=conn.prepareStatement("insert into bankdata (bankname,balance,pincode) values(?,?,?)");
			pstmt.setString(1, bankname);
			pstmt.setInt(2,balance);
			pstmt.setInt(3,pincode);
			int i=pstmt.executeUpdate();
			if(i==1)
			{
				System.out.println("insert success");
			}
				else
				{
					System.out.println("insert failure");
				}
		
			
			
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}
