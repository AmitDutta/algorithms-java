package dp;

public class BadNeighbours {
	public static int  maxDonations(int[] donations){
		int[] dp = new int[donations.length];
		dp[0] = donations[0];
		for (int i = 2; i < donations.length - 1; ++i){
			dp[i] = Math.max(dp[i-2]+donations[i],dp[i-1]);
		}
		int ans = dp[donations.length-2];
		
		dp = new int[donations.length];
		
		dp[1] = donations[1];
		for(int i = 2; i < donations.length; ++i){
			dp[i] = Math.max(dp[i-2]+donations[i],dp[i-1]);
		}
		int ans2 = dp[donations.length-2 -1];
		return Math.max(ans, ans2);
	}
	public static void main(String[] args){
		int[] input = { 10, 3, 2, 5, 7, 8};
		System.out.println(maxDonations(input));
		int[] inp2 = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		System.out.println(maxDonations(inp2));
	}
}
