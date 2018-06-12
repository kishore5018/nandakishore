//package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	
	System.out.println("INSERT DETAILS");
	System.out.println("Enter studentname");
	Scanner sc=new Scanner(System.in);
	String studentname=sc.next();
	System.out.println("Enter collegename");
	String collegename=sc.next();
	System.out.println("Enter marks");
	int marks=sc.nextInt();
	System.out.println("Enter percentage");
	int percentage=sc.nextInt();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","raj","raj");
	PreparedStatement pst=cn.prepareStatement("insert into student(studentname,collegename,marks,percentage) values(?,?,?,?)");
	pst.setString(1,studentname);
	pst.setString(2,collegename);
	pst.setInt(3,marks);
	pst.setInt(4,percentage);
	
	int i=pst.executeUpdate();
	if(i==1) {
		System.out.println("insert success");
	}else {
		System.out.println("insert not success");
	}
	
	
	
	
	
	
}catch(Exception e) {
	System.out.println(e);
	
}
	}

}
