package files;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class writedata {

	public static void main(String[] args) {

		try {
			FileOutputStream fos=new FileOutputStream("d:/sdata/data.txt");
			DataOutputStream dos =new DataOutputStream(fos);
			dos.writeInt(200);
		  dos.writeDouble(2.2);
		  dos.writeUTF("success");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
