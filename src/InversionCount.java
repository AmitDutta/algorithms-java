// This is a direct application of merge sort
// like nuts and bolts is an application of 
public class InversionCount {
	public int mergesort(int[] a, int lo, int hi){
		int count = 0;
		if (lo < hi){
			int mid = lo + (hi -lo)/2;
			count = mergesort(a, lo, mid);
			count += mergesort(a, mid+1, hi);
			count += merge(a, new int[a.length], lo, mid, hi);
		}
		return count;
	}
	public int merge(int[] A, int[] aux, int lo, int mid, int hi){
		int count = 0;
		int p = lo, q = mid + 1, i = lo;
		while(true){
			if (p > mid || q > hi) break;
			if (A[p] > A[q]){
				count += ((mid+1) - p);
				aux[i++] = A[q++];
			}else{
				aux[i++] = A[p++];
			}
		}
		if (p > mid){
			for (int k = q; k <= hi; k++) aux[i++] = A[k];
		}else{
			for (int k = p; k <= mid; k++) aux[i++] = A[k];
		}
		for (i = lo; i <= hi; i++) A[i] = aux[i];
		return count;
	}
	public static void main(String[] args){
		InversionCount cnt = new InversionCount();
		int[] arr1 = {2, 4, 1, 3, 5};
		/*int lo = 0, hi = arr1.length - 1, mid = lo + (hi - lo)/2;
		int count = cnt.merge(arr1, new int[arr1.length], 0, mid, hi);
		System.out.println(count);*/
		int count = cnt.mergesort(arr1, 0, arr1.length - 1);
		System.out.println(count);
		for (int k = 0; k < arr1.length; k++)System.out.print(arr1[k] + " ");
	}
}
