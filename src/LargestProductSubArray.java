 // VERY TRICKY
public class LargestProductSubArray {
	public static int MaxSubArrayProduct(int[] input)
	{
		int size = input.length;
		int max_here = 1,max_element = input[0], min_here = 1, negatives = 0;
		boolean pairExists = false;
		int max_overall = 1;
		for(int i=0; i<size; i++)
		{
			max_element = Math.max(max_element, input[i]);
			if(input[i]>0)
			{
				max_here =  max_here*input[i];
				min_here = Math.min(min_here*input[i], 1);
			}
			else if(input[i]==0)
			{
				if(negatives>1)
					pairExists = true;
				negatives = 0;
				max_here = min_here = 1;
			}
			else
			{
				negatives++;
				int temp = max_here;
				max_here = Math.max(1, min_here*input[i]);
				min_here = temp*input[i];
			}
			max_overall = Math.max(max_overall, max_here);
		}
		if(negatives>1)
			pairExists = true;
		if(max_element > 0 || pairExists)
			return max_overall;
		else
			return max_element;
	}
	
	public static int MaxProduct(int[] array){
		int cur_max = 1, max = 0, cur_min = 1, max_elem = array[0], negatives = 0;
		int cur_start = 0, cur_end = 0, max_start = 0, max_end = 0;
		boolean pair =false;
		for (int i = 0; i < array.length; i++){
			max_elem = Math.max(max_elem, array[i]);
			if (array[i] > 0){
				cur_max = cur_max * array[i];
				cur_min = Math.min(1, cur_min * array[i]);
				cur_end = i;
			}else if (array[i] == 0){
				if (negatives > 1) pair = true;
				negatives = 0;
				cur_max = 1;
				cur_min = 1;
				cur_start = cur_end = i;
			}else{
				negatives++;
				int temp = cur_max;
				cur_max = Math.max(cur_min*array[i], 1);
				if (cur_min*array[i] > 1) cur_end = i;
				cur_min = temp*array[i];				
			}			
			if (cur_max > max){
				max  = cur_max;
				max_start = cur_start;
				max_end = cur_end;
			}
		}
		if (negatives > 1) pair = true;
		
		System.out.println(max_start);
		System.out.println(max_end);
		
		if (pair || max_elem > 0) return max;		
		return max_elem;
	}
	
	public static void main(String[] args){
		System.out.println(MaxProduct(new int[]{-10,-2,-3,-4,-1}));
		/*System.out.println(MaxSubArrayProduct(new int[]{-1,5,0}));*/
		//System.out.println(MaxSubArrayProduct(new int[]{-5,0,0})); // max_element is zero and pair is also zero 
		System.out.println(MaxProduct(new int[]{1,2,-3,-4,0,5,-8}));
	}
}

