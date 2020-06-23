package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/clone-graph/
 * Clone Graph:
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 */
public class CloneGraph {
	//DFS
	public Node cloneGraph(Node node) {
        Map<Node, Node> visited=new HashMap<>();
        return clone(node, visited);
    }
    
    private Node clone(Node node, Map<Node, Node> visited){
        if(node==null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        
        for(Node nei: node.neighbors){
            newNode.neighbors.add(clone(nei, visited));
        }
        return newNode;
    }
    
    //BFS
    /*
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node, Node> visited=new HashMap<>();
        LinkedList<Node> q=new LinkedList<>();
        q.add(node);
        visited.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node n=q.poll();
            for(Node nei: n.neighbors){
                if(!visited.containsKey(nei)){
                    q.add(nei);
                    visited.put(nei, new Node(nei.val));
                }
                visited.get(n).neighbors.add(visited.get(nei));
            }
        }
        
        return visited.get(node);
    }
    */
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
