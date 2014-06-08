public class GraphCloner {
	private boolean[] marked;
	private UGraph clone;
	private UGraph original;
	public GraphCloner(UGraph g){
		original = g;
		marked = new boolean[g.V()];
		clone = new UGraph(g.V());
		for(int i = 0; i < g.V(); i++){
			if (!marked[i]){
				dfs(i);
			}
		}
	}
	public void dfs(int u){
		marked[u] = true;
		for(int v : original.adj(u)){
			clone.addEdgeDirectional(u, v);
			if (!marked[v]) dfs(v);
		}
	}
	public UGraph cloned(){ return clone; }
	public static void main(String[] args){
		UGraph graph = new UGraph(4);
		graph.addEdge(0,1);
		graph.addEdge(1,3);
		graph.addEdge(3,2);
		graph.addEdge(2, 0);
		System.out.println(graph);
		System.out.println("---");
		UGraph cloned = new GraphCloner(graph).cloned();
		System.out.println(cloned);
	}
}
