package dp;

public class AssemblyLine {
	
	public static int line = 1;
	public static int corner = 2;
	
	public static int cost(int n, int[][] a, int[][] t, int[] e, int[] x) {
		int[] t1 = new int[n];
		int[] p1 = new int[n];
		int[] t2 = new int[n];
		int[] p2 = new int[n];
		int[][] p = new int[2][n];
		t1[0] = e[0] + a[0][0];
		t2[0] = e[1] + a[1][0];		
		for (int i = 1; i < n; i++) {
			// t1[i] = Math.min(t1[i -1] + a[0][i], t2[i-1] + t[1][i] + a[0][i]);
			if (t1[i -1] + a[0][i] < t2[i-1] + t[1][i] + a[0][i]) {
				t1[i] = t1[i -1] + a[0][i];
				p[0][i] = line;
			}
			else {
				t1[i] = t2[i-1] + t[1][i] + a[0][i];
				p[0][i] = corner;
			}
			
			// t2[i] = Math.min(t2[i -1] + a[1][i], t1[i-1] + t[0][i] + a[1][i]);
			if (t2[i -1] + a[1][i] < t1[i-1] + t[0][i] + a[1][i]) {
				t2[i] = t2[i -1] + a[1][i];
				p[1][i] = line;
			}
			else {
				t2[i] = t1[i-1] + t[0][i] + a[1][i];
				p[1][i] = corner;
			}
		}
		
		printpath(t1, t2, p, x, n);
		return Math.min(t1[n -1] + x[0], t2[n - 1] + x[1]);
	}
	
	public static void printpath(int[] t1, int[] t2, int[][] p, int[] x, int n) {		
		int cur = 0;
		if (t1[n - 1] + x[0] < t2[n - 1] + x[1]) {
			System.out.println("0");
			cur = 0;
		} else {
			System.out.println("1");
			cur = 1;
		}
		
		for (int i = n - 1; i >= 0; i--) {
			if (p[cur][i] == line) {
				System.out.println(cur);
			} else {
				if (p[cur][i] == corner) {
					if (cur == 1) cur = 0;
					else cur = 1;
				}
				System.out.println(cur);
			}
		}
	}
	
	public static void main(String[] args) {
		int stations = 4;
		int[][] a = {{4, 5, 3, 2},{2, 10, 1, 4}};
		int[][] t = {{0, 7, 4, 5},{0, 9, 2, 8}};
		int[] e = {10,12};
		int[] x = {18,7};
		System.out.println("Cost: " +  cost(stations, a, t, e, x));;
	}
}
