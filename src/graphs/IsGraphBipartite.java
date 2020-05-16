package graphs;

import java.util.Arrays;
import java.util.Stack;

/*
 * https://leetcode.com/problems/is-graph-bipartite/
 * Is Graph Bipartite?:
 * Given an undirected graph, return true if and only if it is bipartite.
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets 
 * A and B such that every edge in the graph has one node in A and another node in B.
 */
public class IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
		int visited[]=new int[graph.length];
		Arrays.fill(visited,-1);

		for(int i=0;i<graph.length;i++){
			if(visited[i]==-1){
				Stack<Integer> stack=new Stack<>();
				stack.push(i);
				visited[i]=1;

				while(!stack.isEmpty()){
					Integer x=stack.pop();
					for(int neighbour: graph[x]){
						if(visited[neighbour]==-1){
							stack.push(neighbour);
							visited[neighbour] = visited[x]^1;
						}
						else if(visited[neighbour]==visited[x]){
							return false;
						}
					}
				}
			}
		}
		return true;

	}
}
