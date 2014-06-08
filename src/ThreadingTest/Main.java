package ThreadingTest;

public class Main {	
	
	public static void main(String[] args){
		Q q = new Q();
		Producer producer = new Producer(q);
		Consumer consumer = new Consumer(q);		
	}
}
