package files;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readdata {

	public static void main(String[] args) throws IOException
	{
		
          FileInputStream fis = new FileInputStream("d:/sdata/data.txt");		
	     // DataInputStream dis =new DataInputStream(fis);
          int i;
          while( (i=fis.read() )!=-1 )
          {
        	  System.out.print((char)i);
        	//  System.out.println(i);
          }
}
	
		
}


