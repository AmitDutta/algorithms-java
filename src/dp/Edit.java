package dp;

public class Edit {
	private int[][] cost;
	private String s1, s2;
	// turn s1 into s2
	public Edit(String s1, String s2){
		cost = new int[s1.length() + 1][s2.length() + 1];
		this.s1 = s1;
		this.s2 = s2;
		calculateCost();
	}
	private void calculateCost(){
		int i, j;
		for (i = 0; i <= s1.length(); i++) {
			cost[i][0] = i;			
		}
		for (j = 0; j <= s2.length(); j++){
			cost[0][j] = j;
		}
		for (i = 1; i <= s1.length(); i++){
			for (j = 1; j <= s2.length(); j++){
				int transpose = cost[i-1][j-1] + (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1);
				int insert = cost[i][j-1] + 1;
				int del = cost[i-1][j] + 1;
				cost[i][j] = Math.min(Math.min(transpose, insert), del);
			} 
		}
		printmatrix();
	}
	private void printmatrix(){
		for (int i = 0; i <= s1.length(); i++){
			for (int j = 0; j <= s2.length(); j++){
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}
	}
	public int getDistance() { return cost[s1.length()][s2.length()]; }
	public void printpath(){
		int i = s1.length();
		int j = s2.length();
		while (true){
			if (i == 0 && j == 0) break;
			if (i == 1 && j == 0){
				// there is still a row above
				System.out.println("Delete from s1:" + s1.charAt(i - 1));
				break;
			}
			else if(i == 0 && j == 1){
				System.out.println("Insert from s1: " + s1.charAt(j - 1));
				break;
			}
			int trans = cost[i-1][j-1];
			int del = cost[i-1][j];
			int insert = cost[i][j-1];
			int min = Math.min(Math.min(trans, insert), del);
			if (min == trans){
				if (s1.charAt(i-1) != s2.charAt(j-1)){
					System.out.println("Transpose s1:" + s1.charAt(i-1) + " with s2:" + s2.charAt(j-1));
				}
				i--;
				j--;
			}else if (min == del){
				System.out.println("Delete from s1:" + s1.charAt(i-1));
				i--;
			}else{
				System.out.println("Insert from s2:" + s2.charAt(j-1));
				j--;
			}
		}
	}
	public static void main(String[] args){
		Edit ed = new Edit("deff", "abc");
		System.out.println(ed.getDistance());
		ed.printpath();
	}
}
