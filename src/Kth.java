import java.util.BitSet;
import java.util.Random;

public class Kth {
	public static int getRandom(int min, int max){
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	public static int partition(int[] A, int lo, int high){
		int x = A[high];
		int i = lo -1;
		for (int p = lo; p <= high - 1; p++){
			if (A[p] < x){
				i++;
				int temp = A[i];
				A[i] = A[p];
				A[p] = temp;
			}
		}
		i++;
		int temp = A[i];
		A[i] = A[high];
		A[high] = temp;
		return i;
	}	
	public static int partition(int[] A, int lo, int high, int position){
		int temp = A[position];
		A[position] = A[high];
		A[high] = temp;
		return partition(A, lo, high);
	}
	public static int kthLargest(int[] A, int k){
		int lo = 0;
		int hi = A.length - 1;
		while(lo < hi){
			int p = partition(A, lo, hi);
			if (p > k) hi = p - 1;
			else if ( p < k ) lo = p + 1;
			return A[k];
		}
		return A[k];
	}
	public static void nutsAndbotls(int[] nuts, int[] bolts, int lo, int high){
		if (lo < high){
			int nut_position = getRandom(lo, high);
			// partition bolts based on this nut
			// first find this nut in bolts	
			int i = -1;
			for (i = lo; i <= high; i++){
				if (bolts[i] == nuts[nut_position]) break;
			}
			int bolt_index = partition(bolts, lo, high, i);
			//now find this bolt in nut
			i = -1;
			for (i = lo; i <= high; i++){
				if (nuts[i] == bolts[bolt_index]) break;
			}
			// now the bolt array is partitioned. based on the bolt at bolt_index, partition nuts array
			int nut_index = partition(nuts, lo, high, i);
			//ok, now one nut and one bolt should be in matching position
			
			// do the same in both parts
			nutsAndbotls(nuts, bolts, lo, nut_index - 1);
			nutsAndbotls(nuts, bolts, nut_index, high);
		}
	}
	
	public static void main(String[] args){
		//kth_main_driver();
		nutsbolts_main_driver();
	}
	
	public static void nutsbolts_main_driver(){
		int[] nuts = {5,4,3,2,1};
		int[] bolts = {1,2,3,4,5};
		nutsAndbotls(nuts, bolts, 0, nuts.length - 1);
		// finally both array should be sorted
		for (int i = 0; i < nuts.length; i++)System.out.print(nuts[i] + " ");
		System.out.println();
		for (int i = 0; i < bolts.length; i++)System.out.print(bolts[i] + " ");
	}
	
	public static void kth_main_driver(){
		int[] A = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(kthLargest(A,1));
		BitSet[] bitset = new BitSet[8];		
		for (int i = 0; i < 8; i++){
			bitset[i] = new BitSet(9);
		}
		bitset[0].set(2);		
		String[] strs = new String[8];
		strs[0].length();
	}
}
