import java.util.HashSet;
import java.util.Set;

// find all pairs whose difference equals K
// Tricky
public class Difference {
	public static int findpairs(int[] array, int k){
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < array.length; i++){
			if (set.contains(array[i])){
				count++;
			}
			set.add(array[i]+k);
			if (array[i]-k >= 0) set.add(array[i]-k);			
		}
		return count;
	}
	
	public static void findpairs1(int[] array, int k){
		Set<Integer> set = new HashSet<Integer>();		
		for (int i = 0; i < array.length; i++) set.add(array[i]);
		for (int i= 0; i < array.length; i++){
			if (set.contains(array[i] + k)){
				System.out.println(array[i] + ", " + (array[i] + k));
			}
			if (array[i] - k >= 0 && set.contains(array[i] - k)){
				System.out.println(array[i] + ", " + (array[i] - k));
			}
			set.remove(array[i]);
		}
	}
	
	public static void main(String[] args){
		int[] arr1 = {1, 5, 3, 4, 2};
		findpairs1(arr1, 3);
		System.out.println();
		int[] arr2 = {8, 12, 16, 4, 0, 20};
		findpairs1(arr2, 4);
	}
}
