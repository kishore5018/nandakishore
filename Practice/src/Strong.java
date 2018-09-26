
public class Strong {

	public static void main(String[] args) {

		int n,num,revNum=0,i,j;
	
		int sum=0;
		for(i=1;i<=100;i++)
		{
			

			n=i;
			int temp=n;
		while(n!=0)
		{
			num=n%10;
			int fact=1;
			for(j=1;j<=num;j++)
			   {
				   fact=fact*j;
				   
			   }
			sum=sum+fact;
		
			n=n/10;
		}
      

		if(sum==i)
		{
			System.out.println(i+"  is Strong Number");
		}
		
		}
		

		
	}

}
