package ThreadingTest;


public class Sample2 implements Runnable{	
	private String name;
	private Shared shared;
	Thread t;
	public Sample2(String name, Shared shared){
		this.name = name;
		this.shared = shared;
		t = new Thread(this, this.name);
		t.start();
	}
	
	@Override
	public void run() {
		try {
			shared.sharedmethod();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
