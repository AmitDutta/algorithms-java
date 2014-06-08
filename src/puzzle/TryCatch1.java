package puzzle;

public class TryCatch1 {
	
	public void somemethod(){
		try{
			System.out.println("AT try");
			return;
		}finally{
			System.out.println("At finally !!");
			return;
		}
	}
	
	public static void main(String[] args){
		TryCatch1 c = new TryCatch1();
		c.somemethod();
	}

}
