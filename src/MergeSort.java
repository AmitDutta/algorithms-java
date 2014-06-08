public class MergeSort {
	private int[] array;
 	public MergeSort(int[] array){
		this.array = array;
	}
 	public void sort(){
 		//sort(this.array, new int[array.length], 0, this.array.length - 1);
 		sortbu(this.array, new int[array.length], 0, this.array.length - 1);
 	}
 	private void sort(int[] array, int[] aux, int low, int high){
 		if (low < high){
 			int mid = low + (high - low)/2;
 			sort(array, aux, low, mid);
 			sort(array, aux, mid + 1, high);
 			merge(array, aux, low, mid, high);
 		}
 	}
 	// bottom up is not working, but the idea is this
 	private void sortbu(int[] array, int[] aux, int low, int high){
 		int N = array.length;
 		for (int sz = 1; sz < N; sz = sz + sz){
 			for (int lo = low; lo < N - sz; lo += sz + sz){
 				merge(array, aux, lo, lo + sz -1, Math.min(N-1, lo+sz+sz-1));
 			}
 		}
 	}
 	public void merge(int[] array, int[] aux, int low, int mid, int high){ 
 		int p = low, q = mid;
 		int i = low; // i need to start from low, not 0 !! Be careful !!! 		 
 		while (true){	
 			if (p >= mid || q > high) break;
 			if (array[p] < array[q]){
 				aux[i] = array[p];
 				p++;
 			}else if (array[p] > array[q]){
 				aux[i] = array[q];
 				q++;
 			}else{
 				aux[i++] = array[p];
 				aux[i] = array[q];
 				p++;
 				q++;
 			}
 			i++;
 		}
 		if (p >= mid){
 			for (int k = q; k <= high; k++){
 				aux[i++] = array[k];
 			}
 		}else{
 			for (int k = p; k < mid; k++){
 				aux[i++] = array[k];
 			}
 		}
 		for (i = low; i <= high; i++) array[i] = aux[i];
 	}
	public static void main(String[] args){
		int[] array = {1,3,2,9,5,4};
		MergeSort sorter = new MergeSort(array);
		int mid = array.length / 2;
		//sorter.merge(array, new int[array.length], 0, mid, array.length - 1);
		sorter.sort();
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
