
public class LargestSumSubArray {
	
	public static void findLargestSumSubArray(int[] array){		
		if (array.length == 0) return;
		int cur_sum, max_sum, cur_start, max_start, cur_end, max_end;
		cur_sum = max_sum = array[0];
		cur_start = max_start = cur_end = max_end = 0;
		int sum;
		for (int i = 1; i < array.length; i++){
			sum = cur_sum + array[i];
			if (sum > array[i]){
				cur_sum = sum;
				cur_end = i;
			}else{
				cur_sum = array[i];
				cur_start = cur_end = i;
			}
			if (cur_sum > max_sum){
				max_sum = cur_sum;
				max_start = cur_start;
				max_end = cur_end;
			}
		}
		System.out.println("Start: " + max_start + ", End: " + max_end + ", Sum: " + max_sum);
	}
	
	public static void main(String[] args){
		findLargestSumSubArray(new int[]{1,2,-5});
	}
}
