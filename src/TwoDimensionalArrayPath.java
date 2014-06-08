import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Backtracking to get all paths in a mxn maze

public class TwoDimensionalArrayPath {
	private int[][] maze;
	private boolean[][] marked;
	private StringBuffer paths;
	private Stack<Pair> tracks;
	private int count;
	private class Pair{
		private int i;
		private int j;
		public Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
		public String toString(){
			return "(" + i + "," + j + ")";
		}
	}
	private boolean isInRange(int i, int j){
		return !(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length);
	}
	public TwoDimensionalArrayPath(int m, int n){
		maze = new int[m][n];
		marked = new boolean[m][n];
		count = 0;
		paths = new StringBuffer();
		tracks = new Stack<Pair>();
		tracks.push(new Pair(0,0));		
		// paths.append(new Pair(0,0).toString());
		dfs(0,0);
	}	
	public List<Pair> getNeighbours(int i, int j){
		List<Pair> neighbours = new ArrayList<Pair>();
		if (isInRange(i,j+1)) neighbours.add(new Pair(i, j+1));
		if (isInRange(i+1,j)) neighbours.add(new Pair(i+1, j));
		return neighbours;
	}
	public void dfs(int i, int j){
		if (i == maze.length - 1 && j == maze[0].length - 1){
			for (int p = 0; p < tracks.size(); p++){			
				System.out.print(tracks.get(p));
			}
			System.out.println();
			System.out.println("--");
			count++;
			return;
		}
		marked[i][j] = true;
		for(Pair neighbour : getNeighbours(i, j)){			
			if (!marked[neighbour.i][neighbour.j]){
				//paths.append(neighbour.toString());
				tracks.push(neighbour);
				dfs(neighbour.i, neighbour.j);				
				//paths.setLength(paths.length() - 1); // Strings won't work :) I need to remove a pair :D
				tracks.pop();
			}
		}
		marked[i][j] = false;		
	}
	public int getTotalPaths(){ return count; }
	public static void main(String[] args){
		TwoDimensionalArrayPath path = new TwoDimensionalArrayPath(3, 3);
		System.out.println("Total paths: " + path.getTotalPaths());
	}
}
