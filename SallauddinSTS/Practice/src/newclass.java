
public class newclass extends classes
{

	/*public void display()
	{
		this.a();
		super.a();
		System.out.println(this.b);
		System.out.println(super.b);
		
	}*/
	
	newclass(int x) {
		super(x);
		// TODO Auto-generated constructor stub
		System.out.println("this is super constructor");
	}

	public static void main(String[] args) 
	{
             newclass nc=new newclass(0);
             
	//	nc.display();
	}
}
