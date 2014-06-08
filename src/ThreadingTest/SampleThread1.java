package ThreadingTest;

public class SampleThread1 extends Thread{
	private String name;	
	public SampleThread1(String name){
		this.name = name;
		this.setName(name);
		this.start();
	}
	
	public void run(){
		try {
			for (int i = 0; i < 5; i++){
				System.out.println(this.name);
				Thread.sleep(500);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
