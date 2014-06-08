public class ThreeWayPartition {
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	// sorting an array with 0,1,2 .. simple use 3 way partitioning Dutch national flag problem
	// will be inplace and not stable
	// we can do counter based sort as well..but that will take extra space but stable
	public static void sort012(int[] A){		
		int lt = 0, gt = A.length -1, i = 0;
		while (i <= gt){
			if (A[i] == 1) i++;
			else if (A[i] > 1){
				swap(A, i, gt);
				gt--;
			}else{
				swap(A, i, lt);
				i++;
				lt++;
			}
		}
	}
	
	public static void partition(int[] A){
		int lo = 0, hi = A.length -1, lt = lo, gt = hi, i = 0;
		int x = A[hi];
		while (i <= gt){
			if (A[i] == x) i++;
			else if (A[i] < x){
				swap(A, lt, i);
				lt++;
				i++;
			}else{
				swap (A, gt, i);
				gt--;
			}
		}
		for (i = 0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	public static void quicksort(int[] A, int lo, int hi){
		if (lo >= hi) return;
		int lt = lo, i = lo, gt = hi;
		int x = A[hi];
		while (i <= gt){
			if (A[i] == x) i++;
			else if (A[i] > x){
				swap(A, i, gt);
				gt--;
			}else{
				swap(A, i, lt);
				i++;
				lt++;
			}
		}
		quicksort(A, lo, lt - 1);
		quicksort(A, gt + 1, hi);
	}
	public static void print(int[] A){
		for (int i = 0; i < A.length; i++) System.out.println(A[i]);
		System.out.println();
	}
	// this will partition positives and negatives, but will not maintain the relative order
	public static void partition2(int[] A){
		int hi = A.length -1, i = -1;
		int x = 0;
		for (int j = 0; j <= hi; j++){
			if (A[j] < x){
				i++;
				swap(A, i, j);
			}
		}
		print(A);
	}
	
	// jumble sort
	// same idea goes for array with n kind of data, where we just want to group.
	// O(n) space, O(n) time. counting is the key
	public static void jumbleSort(int[] A){
		int positives = 0, negatives = 0;
		int[] output = new int[A.length];
		for (int i = 0; i < A.length; i++){
			if (A[i] > 0) positives++;
			else negatives++;
		}
		int k = 0; // 0 - negatives - 1 are -ve numbers
		int l = negatives; // rest are +ve numbers
		for (int i = 0; i < A.length; i++){
			if (A[i] > 0) output[l++] = A[i];
			else output[k++] = A[i];
		}
		print(output);
	}
	
	public static void main(String[] args){
		//partition(new int[]{5,2,1,1,9,8,5});
		int[] A = new int[]{5,2,1,1,9,8,5};
		quicksort(A, 0, A.length - 1);
		int[] B = new int[] {100, 5, -6,-5,20,1,-25};
		//partition2(B);
		jumbleSort(B);
		
		
		int[] z = new int[]{0,1,2,2,0,1,2};
		sort012(z);
		print(z);
	}
}
