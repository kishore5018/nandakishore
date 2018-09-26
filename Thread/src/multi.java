
public class multi extends Thread {

	public void run(){
		
		System.out.println("this is thread");
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
multi m=new multi();
m.start();
	}

}
