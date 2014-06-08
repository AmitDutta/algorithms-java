package ThreadingTest;

public class Q {
	private int n;
	private boolean valueset = false;
	public synchronized int get(){
		if (valueset == false){
			try{
				wait();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		System.out.println("Got: " + n);
		valueset = false;
		notify();
		return n;
	}
	public synchronized void put(int n){
		if (valueset){
			try{
				wait();
			}catch(Exception ex){
				ex.printStackTrace();
			}			
		}
		this.n = n;
		valueset = true;
		System.out.println("Put: " + n);
		notify();
	}
}
