package linkedlists;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null. Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
        Map<Node, Node> map=new HashMap<>();
        Node curr=head;
        Node newHead=new Node(0);
        Node n=newHead;
        while(curr!=null){
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            
            map.put(curr, temp);
            n.next=temp;
            n=n.next;
            curr=curr.next;
            
        }
        curr=head;
        n=newHead.next;
        while(curr!=null){
            if(curr.random!=null){
                n.random = map.get(curr.random);
            }
            curr=curr.next;
            n=n.next;
        }
        
        return newHead.next;
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
