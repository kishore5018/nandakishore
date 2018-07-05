package imagejdbc;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class retrieveimage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
	PreparedStatement pstmt=conn.prepareStatement("select * from image");
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()) {
		Blob b=rs.getBlob(2);
		byte barr[]=b.getBytes(1,(int)b.length());
		FileOutputStream fout=new FileOutputStream("d://nandaer.jpg");
		fout.write(barr);
		fout.close();
		
	}
	System.out.println("ok");
	conn.close();
}catch(Exception e) {
	System.out.println(e);
}
	}

}
