package design;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lru-cache/
 * 
 * LRU Cache:
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item 
 * before inserting a new item.
 * The cache is initialized with a positive capacity..
 */
public class LRUCache {
	int size;
	Map<Integer,Node> cache;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		cache=new HashMap<>();
		size=capacity;
	}

	public int get(int key) {
		if(!cache.containsKey(key)){
			return -1;
		}
		Node n=cache.get(key);
		delete(n);
		insert(n);
		return n.value;
	}

	public void put(int key, int value) {
		if(cache.containsKey(key)){
			Node n=cache.get(key);
			n.value=value;
			delete(n);
			insert(n);
			return;
		}
		if(cache.size()>=size){
			cache.remove(head.key);
			delete(head);
		}

		Node n=new Node(key,value);
		cache.put(key, n);
		insert(n);

	}

	private void insert(Node n){
		if(tail!=null){
			tail.next=n;
		}
		n.prev=tail;
		n.next=null;
		tail=n;
		if(head==null){
			head=tail;
		}

	}

	private void delete(Node n){
		if(n.prev!=null){
			n.prev.next=n.next;
		}
		else{
			head=n.next;
		}

		if(n.next!=null){
			n.next.prev=n.prev;
		}
		else{
			tail=n.prev;
		}
	}

	class Node{
		int key;
		int value;
		Node next;
		Node prev;

		public Node(int key, int value){
			this.key=key;
			this.value=value;
		}
	}
}
