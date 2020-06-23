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
	Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        head=new Node(-1, -1);
        tail=new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
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
        if(cache.size()==capacity){
            Node n=head.next;
            delete(n);
            cache.remove(n.key);
        }
        Node n=new Node(key, value);
        insert(n);
        cache.put(key, n);
    }
    
    private void insert(Node n){
        //insert before tail
        n.prev=tail.prev;
        tail.prev=n;
        n.prev.next=n;
        n.next=tail;
    }
    
    private void delete(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}
