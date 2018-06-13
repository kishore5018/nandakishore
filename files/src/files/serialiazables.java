package files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class serialiazables implements Serializable {

	private String username;

	private String Password;
	private int Id;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	
	public static void main(String[] args) {

		serialiazables s=new serialiazables();
		s.setUsername("super");
		s.setPassword("password");
		s.setId(503);
		
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("d:/sdata/data.txt");
				ObjectOutputStream OOS =new ObjectOutputStream(fos);
				OOS.writeObject(s);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace(); 
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
		
	}

	}


