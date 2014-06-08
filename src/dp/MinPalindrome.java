package dp;

//mport misc.Helper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class MinPalindrome {	
	private MinPalindrome minpal;
	public int MinPal(String str) {
		Integer[][] c = new Integer[str.length()][str.length()];		 
		boolean[][] p = new boolean[str.length()][str.length()];
		Integer[][] path = new Integer[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			c[i][i] = 0;
			p[i][i] = true;
		}
		for (int gap = 1; gap <= str.length() - 1; gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 2) {
					p[i][j] = (str.charAt(i) == str.charAt(j));
				} else {
					p[i][j] = (str.charAt(i) == str.charAt(j)) && p[i + 1][j - 1];
				}
				c[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					if (p[i][j]){
						c[i][j] = 0;
						path[i][j] = k;
					}
					else {
						int val = c[i][k] + 1 + c[k + 1][j];
						if (val < c[i][j]) {
							c[i][j] = val;
							path[i][j] = k;
						}
					}
				}
			}
		}
		
		//printpath(str, path, 0, str.length() - 1);
	//	Helper.print2darray(path);		
		System.out.println();
	//	Helper.print2darray(c);
		return c[0][str.length() - 1];
	}
	
	// print path is not working ..
	public void printpath(String str, Integer[][] path, int start, int end) {
		if (start == end) {
			System.out.print(str.charAt(start));
		} else {
			System.out.print("|");
			printpath(str, path, start, path[start][end]);			
			printpath(str, path, path[start][end] + 1, end);
			System.out.print("|");
		}
	}
	
	
	public boolean ispalindrome(String str, int i, int j) {
		if (i > j) return true;
		if (i == j) return str.charAt(i) == str.charAt(j);
		if (str.charAt(i) == str.charAt(j)) return ispalindrome(str, i + 1, j  - 1);
		else return false;
	}
	
	public int recpal(String str, int i, int j) {
		if (i == j) return 0;
		if (ispalindrome(str, i, j)) {
			return 0;
		}
		int cost = Integer.MAX_VALUE;
		for (int k = i; k < j; i++) {
			int val = recpal(str, i, k) + 1 + recpal(str, k + 1, j);
			if (cost > val) cost = val;
		}
		return cost;
	}
	
	@Test
	public void dpcostTest() {
		minpal= new MinPalindrome();
		String str2 = "ababbbabbababa";
		System.out.println(minpal.MinPal(str2));
	}
	
	@Test
	public void palindrometest() {		
		String str = "a";
		System.out.println(minpal.ispalindrome(str,0,str.length() - 1));
		str = "abba";
		System.out.println(minpal.ispalindrome(str,0,str.length() - 1));
		str = "aba";
		System.out.println(minpal.ispalindrome(str,0,str.length() - 1));
		str = "asdasdwe";
		System.out.println(minpal.ispalindrome(str,0,str.length() - 1));
	}
	
	@Test
	public void recostTest() {
		minpal = new MinPalindrome();
		String str2 = "ababbbabbababa";
		System.out.println(minpal.recpal(str2, 0, str2.length() - 1));
	}
	
	@Before
	public void setup() {
		minpal = new MinPalindrome();
	}
}
