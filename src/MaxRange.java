import java.util.HashSet;

// very tricky and easy.
public class MaxRange {
	public static void main(String[] args){
		int[] arr = {5, 4, 1, 6, 3, 2};
		int beginLength = 0;
		int bestStart = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) set.add(arr[i]);
		while (set.size() > 0){
			int value = set.iterator().next();
			int start = value;
			set.remove(start);
			while (set.remove(start - 1)) start--;
			int end = value;
			while(set.remove(end + 1)) end++;
			int length = end - start + 1;
			if (length > beginLength){
				beginLength = length;
				bestStart = start;					
			}
		}
		System.out.println(bestStart + ", " + beginLength);
	}
}
