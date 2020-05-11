package design;

/*
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * 
 * Add and Search Word - Data structure design:
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string 
 * containing only letters a-z or .. A . means it can represent any one letter.
 */
public class AddAndSearchWord {
	TrieNode root;
	/** Initialize your data structure here. */
	public AddAndSearchWord() {
		root=new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode curr=root;
		for(int i=0;i<word.length();i++){
			char ch=word.charAt(i);
			if(curr.children[ch-'a']==null){
				TrieNode temp=new TrieNode();
				curr.children[ch-'a']=temp;
				curr=temp;
			}
			else{
				curr=curr.children[ch-'a'];
			}
			if(i==word.length()-1){
				curr.isLeaf=true;
			}
		}
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return search(root, 0, word);
	}

	private boolean search(TrieNode root, int k, String word){
		if(root.isLeaf && k==word.length()){
			return true;
		}
		if(k>=word.length()){
			return false;
		}
		char ch=word.charAt(k);
		if(ch!='.'){
			if(root.children[ch-'a']==null){
				return false;
			}
			else{
				return search(root.children[ch-'a'], k+1, word);
			}
		}
		else{
			boolean flag=false;
			for(int i=0;i<26;i++){
				if(root.children[i]!=null){
					if(search(root.children[i], k+1, word)){
						flag=true;
						break;
					}
				}
			}
			if(flag){
				return true;
			}
		}
		return false;
	}

}
class TrieNode{
	TrieNode children[];
	boolean isLeaf;

	TrieNode(){
		children=new TrieNode[26];
		isLeaf=false;

	}
}