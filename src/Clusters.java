import java.util.ArrayList;
import java.util.List;

public class Clusters {
	private boolean[][] array;
	private boolean[][] marked;
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
	public Clusters(boolean[][] array){
		this.array = array;
		marked = new boolean[array.length][array[0].length];
		count = 0;
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[0].length; j++){
				if (!marked[i][j] && array[i][j]){
					count++;
					dfs(i,j);
				}
			}
		}
	}
	private boolean isInRange(int i, int j){
		if (i < 0 || j < 0 || i >= array.length || j >= array.length) return false;
		return true;
	}
	private List<Pair> getNeighbours(int i, int j){
		List<Pair> neighbours = new ArrayList<Pair>();
		if (isInRange(i-1, j-1))neighbours.add(new Pair(i-1,j-1));
		if (isInRange(i-1, j))neighbours.add(new Pair(i-1,j));
		if (isInRange(i-1, j+1))neighbours.add(new Pair(i-1,j+1));
		if (isInRange(i, j-1))neighbours.add(new Pair(i,j-1));
		if (isInRange(i, j+1))neighbours.add(new Pair(i,j+1));
		if (isInRange(i+1, j-1))neighbours.add(new Pair(i+1,j-1));
		if (isInRange(i+1, j))neighbours.add(new Pair(i+1,j));
		if (isInRange(i+1, j+1))neighbours.add(new Pair(i+1,j+1));
		return neighbours;
	}
	private void dfs(int i, int j){
		marked[i][j] = true;
		for(Pair neighbour : getNeighbours(i,j)){
			if (!marked[neighbour.i][neighbour.j]){
				if (array[neighbour.i][neighbour.j])
					dfs(neighbour.i, neighbour.j);
			}
		}
	}
	public int getClusterCount() { return count; }
	public static void main(String[] args){
		boolean[][] array = {{true, false, false, true},
							{false, true, false, false},
							{false, false, true, true},
							{false, false, false, true}};
		Clusters cls = new Clusters(array);
		System.out.println(cls.getClusterCount());
	}
}
