import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
	   
		System.out.println("Enter a String:");
		Scanner scan =new Scanner(System.in);
		String s=scan.nextLine();
		String res=s.replace(s, "Duper");
		String re=res.replace(res, "hiper");
		System.out.println(res);
		System.out.println(re);
        
		System.out.println(res+"  "+re+" "+s);
		
	}

}