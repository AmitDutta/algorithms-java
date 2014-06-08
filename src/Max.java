public class Max {
	public static void main(String[] args){
		int[] arr = {1,2,2,3,4,4,4,4,5,5,5};
		int prev, cur_max, max;
		prev = arr[0];
		cur_max = max = 1;
		int max_num = arr[0];
		for (int i = 1; i < arr.length; i++){
			if (arr[i] == prev){
				cur_max++;				
			}else{
				cur_max = 1;
				prev = arr[i];
			}
			if (cur_max > max){
				max = cur_max;
				max_num = prev;
			}
		}
		System.out.println(max_num + ", " + max + " times" );
	}
}
