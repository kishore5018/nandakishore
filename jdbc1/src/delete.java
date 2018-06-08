import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the UserName to Delete:::::");
			String username=sc.next();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
			PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
			ResultSet rs=pstmt.executeQuery();
			HashSet<String> hs=new HashSet<>();
			while(rs.next()){
				hs.add(rs.getString("username"));
			}
			
			if(hs.contains(username)){
				System.out.println("Record Found");
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
				PreparedStatement pstmt1=conn.prepareStatement("delete from empdata where username=?");
				pstmt1.setString(1, username);
				int i=pstmt1.executeUpdate();
				if(i==1){
					System.out.println("Delete Success");
				}else{
					System.out.println("Delete Not Success");
				}
				
				
			}else{
				System.out.println("Record Not Found");
			}
			
			
		}catch(Exception e){
			System.out.println(e); 
			
		}
		
	}

}


