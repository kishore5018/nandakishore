
public class sleep extends Thread {

	public void run() {
		for(int i=0;i<=5;i++) {
			
			try {
				Thread.sleep(500);
				
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
			public static void main(String[] args) {
				// TODO Auto-generated method stub
		sleep s=new sleep();
		
		sleep s1=new sleep();
		
		s.start();
		s1.start();
			
		}
	}
	
	
	

	
	
	
	
	
	
	
