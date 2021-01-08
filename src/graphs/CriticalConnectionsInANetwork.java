package graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 
 * Critical Connections in a Network:
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections 
 * forming a network where connections[i] = [a, b] represents a connection between servers a and b. 
 * Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to 
reach some other server.

Return all critical connections in the network in any order.
 */
public class CriticalConnectionsInANetwork {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<Integer>[] graph= new ArrayList[n];
		for(int i=0;i<n;i++){
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<connections.size();i++){
			List<Integer> conn=connections.get(i);
			graph[conn.get(0)].add(conn.get(1));
			graph[conn.get(1)].add(conn.get(0));
		}

		int low[]=new int[n];
		int visited[]=new int[n];
		List<List<Integer>> res = new ArrayList<>();
		dfs(low, visited, 0, 0, res, graph, 0);
		return res;
	}

	private void dfs(int low[], int visited[], int curr, int parent, List<List<Integer>> res,  List<Integer>[] graph, int seq){
		if(visited[curr]>0){
			return;
		}
		seq++;
		visited[curr]=seq;
		low[curr]=seq;
		for(int nei:graph[curr]){
			if(nei==parent){
				continue;
			}
			if(visited[nei]==0){
				dfs(low, visited, nei, curr, res, graph, seq);
			}
			low[curr]=Math.min(low[curr], low[nei]);
		}
		if(curr!=0 && low[curr]>visited[parent]){
			List<Integer> temp=new ArrayList<>();
			temp.add(parent);
			temp.add(curr);
			res.add(temp);
		}
	}
}
