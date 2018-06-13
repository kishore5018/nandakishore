
public abstract class display {

	abstract void print();
	
}

   class AinnerClass
  {
	  public static void main(String[] args) {
		
		  display d=new display()
				  {

					@Override
					void print() {
						int i,sum;
						for(i=1;i<=50;i++)
						{
							sum=i*2-1;
							System.out.println(sum);
							
						}
						System.out.println("This Abstract Anonymous inner class");
						
						
					}
			  
				  };
		  
				  d.print();
				  
	}
  }
          


















