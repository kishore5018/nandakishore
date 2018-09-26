package TASK3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PROG2 {

	public static void ADMIN() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("[Username]");
		String username=sc.next();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
		PreparedStatement ps=c.prepareStatement("");
	
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	

}
