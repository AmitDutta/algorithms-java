public class SubSet {
	public static void printset(int[] array, int sum){
		printsetI(array, new boolean[array.length], sum, new int[array.length], 0, 0);		
	}
	private static void printsetI(int[] array, boolean[] marked, int sum, int[] path, int pathindex, int start){
		if (sum < 0) return;
		if (sum == 0){
			print(path, pathindex);
			return;
		}
		// if I start from i = 0; 10, 1 and 1, 10 all will be printed ..
		for (int i = start; i < array.length; i++){
			if (marked[i]) continue;
			path[pathindex] = array[i];
			pathindex++;
			marked[i] = true;
			start++;
			printsetI(array, marked, sum - array[i], path, pathindex, start);
			marked[i] = false;
			pathindex--;
		}
	}
	public static void print(int[] array, int len){
		for (int i = 0; i < len; i++)System.out.print(array[i] + " ");
		System.out.println();
	}
	public static void main(String[] args){
		printset(new int[]{1,4,5,2,10},11);
	}
}
