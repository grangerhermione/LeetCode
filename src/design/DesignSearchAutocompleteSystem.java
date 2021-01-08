package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 
 * Design Search Autocomplete System:
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 */
public class DesignSearchAutocompleteSystem {
	TrieNode root;
	String str="";
	public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
		root=new TrieNode();
		for(int i=0;i<sentences.length;i++){
			insert(root, sentences[i], times[i]);
		}
	}

	public List<String> input(char c) {
		List<String> result=new ArrayList<>();
		if(c=='#'){
			insert(root, str, 1);
			str="";
		}
		else{
			str+=c;
			List<Node> list=search(root, str);
			Collections.sort(list, (a, b)->a.times==b.times? a.sentence.compareTo(b.sentence) : b.times-a.times);
			for(int i=0;i<Math.min(3, list.size());i++){
				result.add(list.get(i).sentence);
			}
		}
		return result;
	}

	private List<Node> search(TrieNode curr, String s){
		List<Node> list=new ArrayList<>();
		for(int i=0;i<s.length();i++){
			int c=charToInt(s.charAt(i));
			if(curr.children[c]==null){
				return new ArrayList<>();
			}
			curr=curr.children[c];
		}
		traverse(s, curr,list);
		return list;
	}

	private void traverse(String s, TrieNode curr, List<Node> list ){
		if(curr.times>0){
			list.add(new Node(s, curr.times));
		}
		for(char i='a';i<='z';i++){
			if(curr.children[i-'a']!=null){
				traverse(s+i, curr.children[i-'a'], list);
			}
		}
		if(curr.children[26]!=null){
			traverse(s+' ', curr.children[26], list);
		}
	}

	private void insert(TrieNode curr, String sentence, int times){
		for(int i=0;i<sentence.length();i++){
			int c=charToInt(sentence.charAt(i));
			if(curr.children[c]==null){
				curr.children[c]=new TrieNode();
			}
			curr=curr.children[c];
		}
		curr.times+=times;
	}

	private int charToInt(char ch){
		return ch==' '?26:ch-'a';
	}

	class TrieNode{
		TrieNode children[];
		int times;

		TrieNode(){
			children=new TrieNode[27];
			times=0;
		}
	}
}

class Node{
	String sentence;
	int times;

	Node(String sentence, int times){
		this.sentence=sentence;
		this.times=times;
	}
}

