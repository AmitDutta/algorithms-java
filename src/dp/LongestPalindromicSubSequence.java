package dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubSequence {
	
	public int recursive(String str, int i, int j) {
		if (i == j) return 1;
		else if (j == i + 1) {
			return str.charAt(i) == str.charAt(j) ? 2 : 1;
		}
		else if (str.charAt(i) != str.charAt(j)) {
			return Math.max(recursive(str, i + 1, j), recursive(str, i, j - 1));
		}
		else {
			return recursive(str, i + 1, j - 1) + 2;
		}
	}
	
	public int dp(String str) {
		int[][] cost = new int[str.length()][str.length()];
		int i,j;
		for (i = 0; i < str.length(); i++) cost[i][i] = 1;
		printtwodarray(cost);
		for (int k = 1; k < str.length(); k++) {
			for (i = 0, j = i + k; i < str.length() && j < str.length(); i++, j++) {
				if (j == i + 1) cost[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
				else {
					if (str.charAt(i) == str.charAt(j)) cost[i][j] = 2 + cost[i + 1] [j - 1];
					else cost[i][j] = Math.max(cost[i + 1][j], cost[i][j - 1]);
				}
			}
		}		
		printtwodarray(cost);
		
		i = 0;
		j = str.length() - 1;
		StringBuffer buffer = new StringBuffer();
		while (!(i == 0 && j == 0)) {
			if (str.charAt(i) == str.charAt(j)) buffer.append(str.charAt(i));
			int max = Math.max(Math.max(cost[i + 1][j], cost[i][j-1]), cost[i - 1][j - 1]);
			if (max == cost[i + 1][j]) {
				i = i + 1;
			} else if (max == cost[i][j - 1]) {
				j = j - 1;
			} else {
				i = i - 1;
				j = j - 1;
			}
		}		
		System.out.println(buffer.reverse().toString());
		return cost[0][str.length() - 1];
	}
	
	public void printtwodarray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--");
	}
	
	@Test
	public void test() {
		String str = "BBABCBCAB";
		Assert.assertEquals(7, recursive(str, 0, str.length() - 1));
		Assert.assertEquals(7, dp(str));
	}
}
