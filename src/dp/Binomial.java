package dp;

public class Binomial {
	private int[][] memo;
	public int computeWithMemo(int N, int K){
		memo = new int[N + 1][K + 1];
		/*for (int i = 0; i < N + 1; i++){
			for (int j = 0; j < K + 1; j++){
				memo[i][j] = Integer.MIN_VALUE;
			}
		}*/
		return computeWithMemoI(N, K);
	}
	private int computeWithMemoI(int N, int K){
		if (N < K) return 0;
		if (K <= 0) return 1;
		if (memo[N][K] != 0) return memo[N][K];
		else{
			memo[N][K] = computeWithMemoI(N - 1, K) + computeWithMemoI(N - 1, K - 1);
			return memo[N][K];
		}
	}
	public int computeWithDp(int N, int K){
		memo = new int[N + 1][K + 1];
		for (int i = 0; i <= N; i++) memo[i][0] = 1;
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= K; j++){
				memo[i][j] = memo[i - 1][j] + memo[i - 1][j - 1];
			}
		}
		return memo[N][K];
	}
	public static void main(String[] args){
		Binomial binomial = new Binomial();
		System.out.println(binomial.computeWithMemo(22, 2)); // expected 231
		System.out.println(binomial.computeWithMemo(1, 1));  // expected 1
		System.out.println(binomial.computeWithMemo(22, 1)); //expected 22
		
		System.out.println(binomial.computeWithDp(22, 2)); // expected 231
		System.out.println(binomial.computeWithDp(1, 1));  // expected 1
		System.out.println(binomial.computeWithDp(22, 1)); //expected 22
	}
}
