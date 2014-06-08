import static org.junit.Assert.*;

import org.junit.Test;

public class Cnf {
	
	private int getTotalVars(String input){
		int num = 0;
		for (int i = 0; i < input.length(); i++){
			if (input.charAt(i) != '#') num++;
		}
		return num;
	}
	
	public void generateSolutions(String input){
		int nums = getTotalVars(input);
		generateSolutionsI(input, new StringBuffer(), new boolean[input.length()], 0, new int[]{0,1});	
	}
	
	private void generateSolutionsI(String input, StringBuffer buffer, boolean[] marked, int index, int[] values){
		if (buffer.length() == getTotalVars(input)){
			System.out.println(buffer.toString());
		}
		for (int i = index; i < input.length(); i++){
			if (input.charAt(i) == '#') continue;
			if (marked[i]) continue;
			marked[i] = true;
			for (int j = 0; j < values.length; j++){				
				buffer.append(j);
				generateSolutionsI(input, buffer, marked, i + 1, values);
				buffer.setLength(buffer.length() - 1);
				
			}
			marked[i] = false;			
		}
	}
	
	/*@Test
	public void testGenerateSolutions(){
		Cnf cnf = new Cnf();
		cnf.generateSolutions("ab#cd");
	}*/
	public static void main(String[] args){
		Cnf cnf = new Cnf();
		cnf.generateSolutions("ab#cde");
	}
}
