package dp;

public class KnapSack {
	private int[] v;
	private int[] w;
	private int W;
	public KnapSack(int[] v, int[] w, int W){
		this.v = v;
		this.w = w;
		this.W = W;
	}
	private void print(int[][] arr){
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	// 0 1 knapsack
	public int boundeddp(){
		int[][] cost = new int[v.length + 1][W + 1];
		for (int item = 1; item <= v.length; item++){
			for (int weight = 1; weight <= W; weight++){
				// w and v are 0 based indexed
				if (w[item -1] <= W && (weight - w[item -1]) >= 0){
					int val1 = cost[item - 1][weight - w[item - 1]] + v[item - 1];
					int val2 = cost[item -1][weight - 1];
					cost[item][weight] = val1 > val2 ? val1 : val2;
				}
			}
		}
		return cost[v.length][W];
	}
	
	// unbounded
	public int undounded(){
		int[] cost = new int[W + 1];
		int items = w.length;
		for (int i = 1; i <= W; i++){
			int max = cost[i];
			for (int item = 1; item <= v.length; item++){
				if (w[item - 1] <= i){
					int val = cost[W - w[item - 1]] + v[item -1];
					if (val > max){
						max = val;
					}
				}
			}
			cost[i] = max;
		}		
		for (int i = 1; i <= W; i++) System.out.print(cost[i] + " ");
		System.out.println();
		return cost[W];
	}
	public static void main(String[] args){		
		int[] v = {10,40,30,50};
		int[] w = {5,4,6,3};
		int[] w1 = {6, 3, 4, 2};
		int[] v1 = {30, 14, 16, 9};
		System.out.println(new KnapSack(v, w, 10).undounded());
	}
}
