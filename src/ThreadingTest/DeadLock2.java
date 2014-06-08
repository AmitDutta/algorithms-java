package ThreadingTest;

public class DeadLock2 {
	public static Shared2 sh = new Shared2();
	public static void main(String[] args){		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sh.method1("Thread1");
					//Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}				
			}
		}, "Thread1").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sh.method2("Thread2");
					//Thread.sleep(500);					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}, "Thread2").start();
	}
}
