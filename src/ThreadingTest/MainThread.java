package ThreadingTest;

public class MainThread {
	public static void main(String[] args){
		Shared sh = new Shared();
		Sample2 t1 = new Sample2("first", sh);
		Sample2 t2 = new Sample2("second", sh);
		Sample2 t3 = new Sample2("third", sh);
		Sample2 t4 = new Sample2("fourth", sh);
		try {
			t1.t.join();
			t2.t.join();
			t3.t.join();
			t4.t.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("Main exiting");
	}
}
