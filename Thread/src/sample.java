
public class sample implements Runnable{

	
	public void run() {
		System.out.println("thread is running");
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
sample s=new sample();
Thread t=new Thread(s);
t.start();

	}

}
