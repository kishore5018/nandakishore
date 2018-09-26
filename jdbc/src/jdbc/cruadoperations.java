package jdbc;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.HashSet;
	import java.util.Scanner;

	public class cruadoperations {

		public static void insert() {
			
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
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda");
				PreparedStatement pstmt=conn.prepareStatement("insert into empdata (username,password,email,id) values(?,?,?,?)");
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, email);
				pstmt.setInt(4, id);
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

		public static void fetch() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda");
			PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println("UserName::::"+rs.getString("username"));
				System.out.println("PassWord::::"+rs.getString(2));
				System.out.println("Email:::::::"+rs.getString("email"));
				System.out.println("Id::::::::::"+rs.getInt("id"));
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
			
		}

		public static void update() {
			try{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the UserName to Update:::::");
				String username=sc.next();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda");
				PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
				ResultSet rs=pstmt.executeQuery();
				HashSet<String> hs=new HashSet<>();
				while(rs.next()){
					hs.add(rs.getString("username"));
				}
				
				if(hs.contains(username)){
					System.out.println("Record Found");
					System.out.println("Enter the PassWord::::::");
					String password=sc.next();
					System.out.println("Enter the Email:::::::::");
					String email=sc.next();
					System.out.println("Enter the Id::::::::::::");
					int id=sc.nextInt();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda");
					PreparedStatement pstmt1=conn.prepareStatement("update empdata set password=?,email=?,id=? where username=?");
					pstmt1.setString(1, password);
					pstmt1.setString(2, email);
					pstmt1.setInt(3, id);
					pstmt1.setString(4, username);
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

		public static void delete() {
			try{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the UserName to Delete:::::");
				String username=sc.next();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda");
				PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
				ResultSet rs=pstmt.executeQuery();
				HashSet<String> hs=new HashSet<>();
				while(rs.next()){
					hs.add(rs.getString("username"));
				}
				
				if(hs.contains(username)){
					System.out.println("Record Found");
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda");
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


