import java.util.LinkedList;
import java.util.List;

public class UGraph {
	private final int v;
	private List<Integer>[] adj;
	public UGraph(int V){
		this.v = V;
		adj = (LinkedList<Integer>[]) new LinkedList[v];
		for (int i = 0; i < v; i++) adj[i] = new LinkedList<Integer>();
	}
	public void addEdge(int u, int v){
		adj[u].add(v);
		adj[v].add(u);
	}
	public void addEdgeDirectional(int u, int v){
		adj[u].add(v);
	}
	public Iterable<Integer> adj(int u){
		return adj[u];
	}
	public int V(){ return v; }
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < v; i++){
			buffer.append(i + ": ");
			List<Integer> kids = adj[i];
			for (int v : kids){
				buffer.append(v + " ");
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
