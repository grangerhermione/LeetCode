package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-ladder/
 * Word Ladder:
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict=new HashSet<>();
		for(String str: wordList){
			dict.add(str);
		}
		if(!dict.contains(endWord)){
			return 0;
		}

		LinkedList<WordCount> queue=new LinkedList<>();
		queue.add(new WordCount(beginWord, 1));

		while(!queue.isEmpty()){
			WordCount curr=queue.remove();
			String word=curr.word;
			if(word.equals(endWord)){
				return curr.count;
			}

			char arr[]=word.toCharArray();
			for(int i=0;i<arr.length;i++){
				for(char c='a';c<='z';c++){
					char temp=arr[i];
					arr[i]=c;
					String newWord=new String(arr);
					if(dict.contains(newWord)){
						queue.add(new WordCount(newWord, curr.count+1));
						dict.remove(newWord);
					}
					arr[i]=temp;
				}
			}
		}

		return 0;


	}

	class WordCount{
		String word;
		int count;

		public WordCount(String word, int count){
			this.word=word;
			this.count=count;
		}
	}
}
