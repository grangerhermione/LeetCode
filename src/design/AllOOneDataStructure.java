package design;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/all-oone-data-structure/
 * All O`one Data Structure:
 * Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
 */
public class AllOOneDataStructure {
	Node head, tail;
	Map<String, Node> map;

	/** Initialise your data structure here. */
	public AllOOneDataStructure() {
		head=new Node("", 0);
		tail=new Node("", 0);
		head.next=tail;
		tail.prev=head;
		map=new HashMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		if(map.containsKey(key)){
			Node n=map.get(key);
			n.val++;
			moveToHead(n);
		}
		else{
			Node n=new Node(key, 1);
			map.put(key, n);
			insert(n, tail);
		}
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if(map.containsKey(key)){
			Node n=map.get(key);
			n.val--;
			if(n.val==0){
				remove(n);
				map.remove(key);
			}
			else{
				moveToTail(n);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if(map.isEmpty()){
			return "";
		}
		return head.next.key;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if(map.isEmpty()){
			return "";
		}
		return tail.prev.key;
	}

	private void insert(Node n, Node back){
		n.next=back;
		back.prev.next=n;
		n.prev=back.prev;
		back.prev=n;
	}

	private void remove(Node n){
		n.prev.next=n.next;
		n.next.prev=n.prev;
	}

	private void moveToHead(Node n){
		while(n.prev!=head && n.val>n.prev.val){
			Node prev = n.prev;
			remove(n);
			insert(n, prev);
		}
	}

	private void moveToTail(Node n){
		while(n.next!=tail && n.val<n.next.val){
			Node next=n.next;
			remove(next);
			insert(next, n);
		}
	}

	class Node{
		String key;
		int val;
		Node prev;
		Node next;
		Node(String key, int val){
			this.key=key;
			this.val=val;
		}
	}
}
