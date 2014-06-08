package puzzle;

public class TryCatch3 {
	public static void main(String[] args){
		try {
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			System.out.println("I will never be printed !");
		}
	}
}
