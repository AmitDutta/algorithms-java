public class Median {
	// see the indexing..this is a smart way
	public static double getMedian(int[] array1, int[] array2){
		int n = array1.length;
		int m1 = -1, m2 = -1;
		int i = 0, j = 0;
		for (int count = 0; count <= n; count++){
			if (i == n){
				m2 = m1;
				m1 = array2[0];
				break;
			}
			else if (j == n){
				m2 = m1;
				m1 = array1[0];
				break;
			}
			if (array1[i] < array2[j]){
				m2 = m1;
				m1 = array1[i];
				i++;
			}
			else{
				m2 = m1;
				m1 = array2[j];
				j++;
			}
		}
		return (m1+m2)/2.0;
	}
	public static void main(String[] args){
		/*int[] array1 = {1, 12, 15, 26, 38};
		int[] array2 = {2, 13, 17, 30, 45};
		System.out.println(getMedian(array1, array2));*/
		int[] array3 = {4,5,6};
		int[] array4 = {1,2,3};
		System.out.println(getMedian(array3, array4));
	}
}
