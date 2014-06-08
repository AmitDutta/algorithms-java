package puzzle;

public class Variables {
	private int i;
	private String str;
	
	public Variables(){
		System.out.println(i);
		System.out.println(str);
	}
	
	public static void main(String[] args){
		int i;
		boolean item;
		double val;
		String str;
		
		Variables v = new Variables();
		
		// This code does not compile if the local variables are not initialized.
		//same for primitive and objects
		//System.out.println(i + " - " + val + " - " + item + "-" + str);
		
	}
}
