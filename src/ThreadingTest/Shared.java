package ThreadingTest;

public class Shared {
	private Object lock1 = new Object();
	private int ii = 0;
	
	public Shared(){
		
	}
	
	public synchronized	 void sharedmethod(){
		//synchronized (lock1) {
			try {
				for (int i = 0;  i < 5; i++){
					ii++;
					System.out.println(Thread.currentThread().getName() + ": " + ii);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
	}
}
