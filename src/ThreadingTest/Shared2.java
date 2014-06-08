package ThreadingTest;

public class Shared2 {
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	
	public void method1(String name) throws Exception{
		synchronized (lock1) {
			System.out.println("Lock 1: method 1");
			Thread.sleep(500);
			synchronized (lock2) {
				System.out.println("Lock 2 : Method 1");
				
			}
		}
	}
	
	public void method2(String name) throws Exception{
		synchronized (lock2) {
			System.out.println("Lock 2: Method 2");
			Thread.sleep(500);
			synchronized (lock1) {
				System.out.println("Lock 1: Method 2");
			}
		}
	}
	
	// how to resolve; apply order on locks
	//but may be not possible always..we need concurrent executions
	/*public void method2(String name) throws Exception{
		synchronized (lock1) {
			System.out.println("Lock 1: Method 2");
			Thread.sleep(500);
			synchronized (lock2) {
				System.out.println("Lock 2: Method 2");
			}
		}
	}	*/
}
