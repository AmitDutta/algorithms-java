package puzzle;

public class Variable {
	private static int i = 0;
	public Variable(){
		i++;
	}
	public int getI(){return i;}
	public static void main(String[] args){
		Variable var1 = new Variable();
		Variable var2 = new Variable();
		Variable var3 = new Variable();
		System.out.println(var1.getI() + " " + var2.getI() + " " + var3.getI());
	}
}
