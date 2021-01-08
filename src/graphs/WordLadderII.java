package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * Word Ladder II:
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

 */
public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict=new HashSet<>(wordList);
		if(!dict.contains(endWord)){
			return new ArrayList<>();
		}
		return find(beginWord, endWord, dict);
	}


	private List<List<String>> find(String start, String end,Set<String> dict ){
		List<List<String>> results = new ArrayList<List<String>>();

		// instead of storing words we are at, we store the paths.
		Queue<List<String>> paths = new LinkedList<List<String>>();
		List<String> path0 = new LinkedList<String>();
		path0.add(start);
		paths.add(path0);
		// if we found a path ending at 'end', we will set lastLevel,
		// use this data to stop iterating further.
		int level = 1, lastLevel = Integer.MAX_VALUE;
		Set<String> wordsPerLevel = new HashSet<String>();
		while (!paths.isEmpty()) {
			List<String> path = paths.poll();
			if (path.size() > level) {
				dict.removeAll(wordsPerLevel);
				wordsPerLevel.clear();
				level = path.size();
				if (level > lastLevel)
					break; // stop and return
			}
			//  try to find next word to reach, continuing from the path
			String last = path.get(level - 1);
			char[] chars = last.toCharArray();
			for (int index = 0; index < last.length(); index++) {
				char original = chars[index];
				for (char c = 'a'; c <= 'z'; c++) {
					chars[index] = c;
					String next = new String(chars);
					if (dict.contains(next)) {
						wordsPerLevel.add(next);
						List<String> nextPath = new LinkedList<String>(path);
						nextPath.add(next);
						if (next.equals(end)) {
							results.add(nextPath);
							lastLevel = level; // curr level is the last level
						} else
							paths.add(nextPath);
					}
				}
				chars[index] = original;
			}
		}

		return results;
	}
}
