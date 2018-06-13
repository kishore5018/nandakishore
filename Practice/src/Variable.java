
public class Variable {

	static int a=254;
	
	public void Show()
	{
		System.out.println("instance variable");
	}
	
	public void display() {
		String s="Instance variable";
	}

	public static void main(String[] args) {
		
	
		
		Variable var=new Variable();
		var.Show();
		System.out.println(a);

	}
	

	
}
