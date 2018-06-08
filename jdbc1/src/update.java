import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the password to Update:::::");
			String password=sc.next();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
			PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
			ResultSet rs=pstmt.executeQuery();
			HashSet<String> hs=new HashSet<>();
			while(rs.next()){
				hs.add(rs.getString("password"));
			}
			
			if(hs.contains(password)){
				System.out.println("Record Found");
				
				System.out.println("Enter the Email:::::::::");
				String email=sc.next();
				System.out.println("Enter the Id::::::::::::");
				int id=sc.nextInt();
				System.out.println("Enter the username::::::");
				String username=sc.next();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
				PreparedStatement pstmt1=conn.prepareStatement("update empdata set email=?,id=?,username=? where password=?");
				pstmt1.setString(4, password);
				pstmt1.setString(1, email);
				pstmt1.setInt(2, id);
				pstmt1.setString(3, username);
				int i=pstmt1.executeUpdate();
				if(i==1){
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

		
	


	


