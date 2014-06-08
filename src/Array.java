import java.util.Random;

public class Array {
	private static final int left = 1;
	private static final int down = 2;
	private static final int right = 3;
	private static final int up = 4;
	public static void spiralPrint(int[][] A){
		//m rows and n cols
		int dir = right, turn = 0, m = A.length - 1, n = A[0].length - 1, row = 0, col = 0;
		boolean enter = true;
		while(enter){
			if (col > (n - turn)) break;
			if (dir == right){
				for (; col <= (n - turn); col++){
					System.out.print(A[row][col] + " ");
				}
				System.out.println();
				row++;				
				dir = down;
				col--; // balance
			}
			if (row > (m - turn)) break;
			if (dir == down){
				for(;row <= (m - turn); row++){
					System.out.print(A[row][col] + " "); 
				}
				System.out.println();
				col--;
				dir = left;
				row--; // balance
			}
			if (dir == left){
				for (; col >= turn; col--){
					System.out.print(A[row][col] + " ");
				}
				System.out.println();
				row--;
				dir = up;
				col++; // balance
			}
			if (dir == up){
				for(; row > turn; row--){
					System.out.print(A[row][col] + " ");
				}
				System.out.println();
				col++;
				turn++;
				dir = right;
				row++; // balance
			}
		}
	}
	public static void main(String[] args){		
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiralPrint(array);
		System.out.println(" -- ");
		int[][] array2 = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
		spiralPrint(array2);
		System.out.println(" -- ");
		int[][] matrix =
			  {
			  { 3, 4, 5, 6, 2, 5 },
			  { 2, 4, 6, 2, 5, 7 },
			  { 2, 5, 7, 8, 9, 3 },
			  { 2, 4, 7, 3, 5, 8 },
			  { 6, 4, 7, 3, 5, 7 } };
		spiralPrint(matrix);		
	}
}
