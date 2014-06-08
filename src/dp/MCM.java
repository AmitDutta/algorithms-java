package dp;

//import misc.Helper;

public class MCM {	
		
	public MCM(){}
	
	public int recmcm(int i, int j, int[] dim) {
		if (i == j) return 0;		
		int min = Integer.MAX_VALUE;
		int value = 0;
		for (int k = i; k < j; k++) {
			value = recmcm(i, k, dim) + recmcm(k + 1, j, dim) + dim[i - 1] * dim[k]*dim[j];
			if (value < min) {
				min = value;
			}
		}
		return min;		
	}
	
	private Integer[][] memo;
	
	public MCM(int j) {
		this.memo = new Integer[j][j];
		for (int i = 0; i < j; i++) {
			for (int k = 0; k < j; k++) {
				this.memo[i][k] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < j; i++) memo[i][i] = 0;
	}
	
	public int memomcm(int i, int j, int[] dim) {
		if (this.memo[i][j] != Integer.MAX_VALUE) {
			return this.memo[i][j];
		}
		
		int value = 0;
		for (int k = i; k < j; k++) {
			value = recmcm(i, k, dim) + recmcm(k + 1, j, dim) + dim[i - 1] * dim[k]*dim[j];
			if (value < memo[i][j]) {
				memo[i][j] =value;
			}
		}
		return memo[i][j];
	}
	
	private Integer[][] path;
	
	public int dpmcm(int start, int end, int[] dim) {
		int i, j, k;
		int len = end - start + 2;
		memo = new Integer[len][len];
		path = new Integer[len][len];
		for (i = start; i <= end; i++) {
			for (j = start; j <= end; j++) {
				memo[i][j] = 0;
			}
		}
		for (i = start; i < len; i++) {
			memo[i][i] = 0;
		}
		
		for (int p = 1; p <= end; p++ ) {
			for (i = 1, j = i + p; i < end && j <= end; i++, j++) {
                memo[i][j] = Integer.MAX_VALUE;
                for (k = i; k < j; k++) {
                    int val = memo[i][k] + memo[k + 1][j] + dim[i - 1] * dim[k]*dim[j];
                    if (val < memo[i][j]) {
                        memo[i][j] = val;
                        path[i][j] = k;
                    }
                }
             }
		}
		//Helper.print2darray(path);
		printpath(start, end);
		System.out.println();
		return memo[start][end];
	}
	
	public void printpath(int start, int end) {
		if (start == end) {
			System.out.print("A" + start);
		}
		else {
			System.out.print("(");
			printpath(start, path[start][end]);
			printpath(path[start][end] + 1, end );
			System.out.print(")");
		}
	}
	
	
	public static void main(String[] args) {
		MCM mcm = new MCM();
		/* System.out.println(mcm.recmcm(3, 5, new int[]{30,35,35,15,15,5,5,10,10,20,20,25}));; // just wrong input .. can you see ? yes I can :)*/
		long start = System.nanoTime();
		System.out.println("Recursive (2,5): " + mcm.recmcm(2, 5, new int[]{30,35,15,5,10,20,25}));
		System.out.println("Recursive (1,6): " + mcm.recmcm(1, 6, new int[]{30,35,15,5,10,20,25}));
		long end = System.nanoTime();		
		System.out.println("Diff:" + (end - start));
		
		
		/*start = System.nanoTime();
		mcm = new MCM(20);
		System.out.println("Memo (2,5): " + mcm.memomcm(2, 5, new int[]{30,35,15,5,10,20,25}));
		mcm = new MCM(20);
		System.out.println("Memo (1,6): " + mcm.memomcm(1, 6, new int[]{30,35,15,5,10,20,25}));
		end = System.nanoTime();
		System.out.println("Diff:" + (end - start)); */
	    System.out.println(mcm.dpmcm(1, 6, new int[]{30,35,15,5,10,20,25}));
	}
}
