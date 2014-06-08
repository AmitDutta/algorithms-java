import java.util.ArrayList;
import java.util.List;


public class CombinationPermutation {

	private int count = 0;
	private void howmanysumI(int sum, int array[], int index, boolean[] path) {
		if (sum < 0) {
			return;
		}
		if (sum == 0) {
			count++;
			printpath(array, path);
			return;
		}
		for (int i = index; i < array.length; i++) {			
			int subsum = sum - array[i];
			path[i] = true;
			howmanysumI(subsum, array, ++index, path);
			path[i] = false;
		}
	}
	
	private void printpath(int[] array, boolean[] path) {
		for (int i = 0; i < path.length; i++) {
			if (path[i]) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}

	public int howmanusum(int array[], int sum) {
		howmanysumI(sum, array, 0, new boolean[array.length]);
		int temp = count;
		count = 0;
		return temp;
	}
	
	public void permutation(String str){
		permuteationI(str, 0, new StringBuffer(), 2, new boolean[str.length()]);
	}
	
	public void permuteationI(String str, int index, StringBuffer buffer, int length, boolean[] mark){
		if (buffer.length() == length){
			System.out.println(buffer.toString());
			return;
		}
		for (int i = index; i < str.length(); i++){
			if (mark[i]) continue;			
			buffer.append(str.charAt(i));
			mark[i] = true;
			permuteationI(str, 0, buffer, length, mark); // start from the beginning every time for permutation
			mark[i] = false;
			buffer.setLength(buffer.length() - 1);			
		}
	}
	
	public void combinationI(String str, int index, StringBuffer buffer, int length, boolean[] mark){
		if (buffer.length() == length){
			System.out.println(buffer.toString());
			return;
		}
		for (int i = index; i < str.length(); i++){
			if (mark[i]) continue;			
			buffer.append(str.charAt(i));
			mark[i] = true;
			combinationI(str, i, buffer, length, mark); // start from the ith position every time for combination
			mark[i] = false;
			buffer.setLength(buffer.length() - 1);			
		}
	}	
	
	// will produce aa, ab, ac ... as we are not marking the last path
	public void permuteWithRepeatI(String str, int index, StringBuffer buffer, int length, boolean[] mark){
		if (buffer.length() == length){
			System.out.println(buffer.toString());
			return;
		}
		for (int i = index; i < str.length(); i++){
			//if (mark[i]) continue;			
			buffer.append(str.charAt(i));
			//mark[i] = true;
			permuteWithRepeatI(str, i, buffer, length, mark); // start from the ith position every time for combination
			//mark[i] = false;
			buffer.setLength(buffer.length() - 1);			
		}
	}
	
	public void findXLcolumnByNumber(int number){
		List<Character> lst = new ArrayList<Character>();
		while (number > 0){			
			int b = number % 26;
			number = number / 26;
			b = b == 0 ? 26 : b;
			lst.add((char) (b + 64));
		}
		
		for (int i = lst.size() - 1; i >= 0; i--)System.out.print(lst.get(i));
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		CombinationPermutation cp = new CombinationPermutation();
		/*int[] array = {1,2,3,4};
		System.out.println(cp.howmanusum(array, 6));*/
		
		/*String str = "abc";
		cp.permutation(str); */
		
		cp.findXLcolumnByNumber(746);
	}
}
