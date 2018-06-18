package sallauddin;

import java.sql.Connection;
import java.sql.DriverManager;


public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","raj","raj");
		//resultprocess.data(con);
		registration.data(con);
		
			}

		
	

}
