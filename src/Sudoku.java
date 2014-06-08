import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Sudoku {
	
	private int[][] array;	
	public Sudoku(int[][] input){
		this.array = input;
		System.out.println(solve());
		print();
	}
	private int start(int val){
		return val < 3 ? 0 : val < 6 ? 3 : 6;
	}
	public void print(){
		System.out.println("Result");
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}	
	}
	public boolean canPlace(int i, int j, int k){
		for (int m = 0; m < 9; m++){
			if (array[i][m] == k) return false;
		}
		for (int m = 0; m < 9; m++){
			if (array[m][j] == k) return false;
		}
		int q = start(i);
		int r = start(j);
		for (; q < (start(i) + 3); q++){
			for (; r < (start(j) + 3); r++){
				if (array[q][r] == k) return false;
			}
		}
		return true;
		
		/*for (int m = 0; m < 9; m += 3){
			for (int n = 0; n < 9; n += 3){
				for (int q = m; q < 3; q++){
					for (int r = n; r < 3; r++){						
					}
				}
			}
		}*/
	}
	public boolean solve(){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (array[i][j] == -1){
					for (int k = 1; k <= 9; k++){
						if (canPlace(i, j, k)){
							array[i][j] = k;
							if (solve()){
								System.out.println("YES");
								return true;
							}
							array[i][j] = -1;
						}	
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		int[][] input = new int[9][9];
		try {
			Scanner	sc = new Scanner(new File("/home/amit/Workspace/java-workspace/algortihms/codes/src/sudoku_inp1.txt"));
			for (int i = 0; i < 9; i++){
				for (int j = 0; j < 9; j++){
					input[i][j] = sc.nextInt();
				}
			}
			new Sudoku(input);
			
			/*for (int i = 0; i < 9; i++){
				for (int j = 0; j < 9; j++){
					System.out.print(input[i][j] + "  ");
				}
				System.out.println();
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
