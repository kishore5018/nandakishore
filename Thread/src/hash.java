
public class hash extends Thread {

	
	
	
	
	
	public void run() {
		for(int i=1; i<=5; i++) {
			
			
				try {
					Thread.sleep(1000);
					
					System.out.println(i);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		}
	}

