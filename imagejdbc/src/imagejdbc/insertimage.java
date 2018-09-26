package imagejdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertimage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
	PreparedStatement pstmt=con.prepareStatement("insert into image values(?,?)");
	pstmt.setString(1, "nand");
	FileInputStream fis=new FileInputStream("d:images"
			+ "\\nanda2.jpg");
pstmt.setBinaryStream(2,fis,fis.available() );
int i=pstmt.executeUpdate();
System.out.println(i+"image went");
con.close();
	}catch(Exception e){
		System.out.println(e);
	}
		
	}

}
