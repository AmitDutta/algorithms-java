import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// http://community.topcoder.com/stat?c=problem_statement&pm=2998&rd=5857
public class GrafixMask {	
	private boolean[][] marked;
	private List<Integer> areas;
	private int count = 0;
	private int row = 400;
	private int col = 600;
	private class Pair{
		int i;
		int j;
		public Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
		public String toString(){ return "(" + i + ", " + j + ")";}
	}
 	public GrafixMask(String[] rectangles){
		marked = new boolean[row][col];
		areas = new ArrayList<Integer>();
		for (String rectangle : rectangles) {
			String[] parts = rectangle.split(" ");
			int row1 = Integer.parseInt(parts[0]);
			int col1 = Integer.parseInt(parts[1]);
			int row2 = Integer.parseInt(parts[2]);
			int col2 = Integer.parseInt(parts[3]);
			for (int i = row1; i <= row2; i++){
				for (int j = col1; j <= col2; j++){
					marked[i][j] = true;
				}
			}
		}
		//print();
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				if (!marked[i][j]) {
					/*count = 0;
					dfs(i, j);*/
					areas.add(dfsI(i, j));
					//print();
				}
			}
		}
	}
 	private void print(){
 		for (int i = 0; i < row; i++){
 			for (int j = 0; j < col; j++)
 				System.out.print(marked[i][j] + " ");
 			System.out.println();
 		} 		
 	}
	private boolean isInRange(int i, int j){
		if (i < 0 || j < 0 || i >= row || j >= col) return false;
		return true;
	}
	private List<Pair> getNeighbours(int i, int j){
		List<Pair> neighbours = new ArrayList<Pair>();
		if (isInRange(i-1,j))neighbours.add(new Pair(i-1,j));
		if (isInRange(i+1,j))neighbours.add(new Pair(i+1,j));
		if (isInRange(i,j-1))neighbours.add(new Pair(i,j-1));
		if (isInRange(i,j+1))neighbours.add(new Pair(i,j+1));
		return neighbours;
	}
 	public void dfs(int i, int j){
 		marked[i][j] = true; 		
 		for (Pair neighbour : getNeighbours(i, j)){ 			
 			if (!marked[neighbour.i][neighbour.j]){
 				count++;
 				dfs(neighbour.i, neighbour.j);
 			}
 		}
 	}
 	public int dfsI(int i, int j){
 		int result = 0;
 		Stack<Pair> stack = new Stack<Pair>();
 		Pair pair = new Pair(i, j); 		
 		stack.push(pair);
 		while (!stack.isEmpty()){
 			Pair node = stack.pop();
 			if (marked[node.i][node.j]) continue;
 			result++;
 			marked[node.i][node.j] = true;
 			for (Pair neighbour : getNeighbours(node.i, node.j)){
 				if (!marked[neighbour.i][neighbour.j]){
 					count++;
 					stack.push(neighbour);
 				}
 			}
 		}
 		return result;
 	}
	public List<Integer> getAreas(){ return areas; }
	public static void main(String[] args){
		String[] rectangles = {"0 192 399 207", "0 392 399 407", "120 0 135 599", "260 0 275 599"};
		List<Integer> areas = new GrafixMask(rectangles).getAreas();
		Collections.sort(areas);
		for (Integer i : areas){
			System.out.println(i);
		}
	}
}
