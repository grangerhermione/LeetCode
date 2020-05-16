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
	Map<Node,Node> visited=new HashMap<>();
	public Node cloneGraph(Node node) {
		if(node==null){
			return null;
		}
		if(visited.containsKey(node)){
			return visited.get(node);
		}

		Node newNode=new Node(node.val);
		visited.put(node, newNode);

		for(Node neighbour: node.neighbors){
			newNode.neighbors.add(cloneGraph(neighbour));
		}

		return newNode;
	}
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
