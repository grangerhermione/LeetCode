import java.util.HashMap;
import java.util.Map;

/*
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null. Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		if(head==null){
			return null;
		}
		Map<Node,Node> map=new HashMap<>();
		Node newHead=new Node(head.val);
		Node p=head;
		Node q=newHead;

		map.put(p,q);
		p=p.next;
		while(p!=null){
			Node copy=new Node(p.val);
			q.next=copy;
			map.put(p,copy);
			q=q.next;
			p=p.next;
		}
		p=head;
		q=newHead;

		while(p!=null){
			if(p.random!=null){
				q.random=map.get(p.random);
			}
			else{
				q.random=null;
			}
			p=p.next;
			q=q.next;
		}
		return newHead;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
