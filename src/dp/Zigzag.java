package dp;

public class Zigzag {	
	public static void print(int[] arr){
		for (int i  = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] array ={ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };

		int[] diff = new int[array.length];
		int[] cost = new int[diff.length];
		cost[0] = 1;
		for(int i = 1; i < array.length; i++){
			diff[i] = array[i] - array[i - 1];
		}
		
		for (int i = 0; i < diff.length; i++){
			for (int j = i - 1; j >= 0; j--){
				if (diff[i] > 0){
					if (diff[j] < 0 && (cost[j] +1) > cost[i]){
						cost[i] = cost[j] + 1;
					}
				}else if (diff[i] < 0){
					if (diff[j] > 0 && (cost[j] +1) > cost[i]){
						cost[i] = cost[j] + 1;
					}
				}else{
					if (cost[j] > cost[i]) cost[i] = cost[j];
				}
			}
		}
		System.out.println(cost[cost.length - 1] + 2);
	}
}
