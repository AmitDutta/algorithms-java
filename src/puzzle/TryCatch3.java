package puzzle;

public class TryCatch3 {
	
	public static void attachShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run() {
				System.out.println("At shutdownhook");
			}
		});
	}
	
	public static void main(String[] args){
		attachShutdownHook();
		try {
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			System.out.println("I will never be printed !");
		}
	}
}
