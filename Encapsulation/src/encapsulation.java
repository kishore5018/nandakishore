
public class encapsulation {
private int id;
private String username;
private String password;

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
encapsulation e=new encapsulation();
e.setId(327);
e.setUsername("Nanda");
e.setPassword("Nanda327");
System.out.println(e.getId());
System.out.println(e.getUsername());
System.out.println(e.getPassword());
Encap.printdata(e);

	}

}
