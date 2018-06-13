package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OIS {

	public static void main(String[] args) {
		
		try {
			FileInputStream f=new FileInputStream("d:/sdata/data.txt");
			ObjectInputStream Os =new ObjectInputStream(f);
			serialiazables oo=(serialiazables)Os.readObject();
			System.out.println(oo.getUsername());
			System.out.println(oo.getPassword());
			System.out.println(oo.getId());
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
