package puzzle;

public class TryCatch2 {
	private TryCatch2 obj = new TryCatch2();
	//private static TryCatch2 obj = new TryCatch2(); // this will be done once and no stackoverflow erro
	public TryCatch2(){
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		TryCatch2 tc = new TryCatch2();
	}
}
