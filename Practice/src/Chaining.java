
public class Chaining {

	 Chaining(int a) {
		 int sum =a*a;
		 System.out.println("First Print : "+sum);
	}
    
   Chaining(int a,int b) {
		 this(5);
		 int sum =a+b;
		 System.out.println("Second Print : "+sum);
	}
   
	
   
  Chaining(int a,int b,int c)
  {
		 this(1,2);
		 int sum=a*b*c;
		 System.out.println("third Print : "+sum);
	}
	
  
 Chaining() {
		 this(2,3,2);
		 System.out.println("Default Print");
	}
	
	
 public static void main(String[] args) {
	Chaining c=new Chaining();
}
}
