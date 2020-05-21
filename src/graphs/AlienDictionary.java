package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/alien-dictionary/
 * Alien Dictionary:
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. You receive a list of non-empty words 
 * from the dictionary, where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.
 */
public class AlienDictionary {
	public String alienOrder(String[] words) {
		Map<Character,List<Character>> adjList=new HashMap<>();
		Map<Character, Boolean> visited=new HashMap<>();

		for(String s:words){
			for(char ch:s.toCharArray()){
				adjList.putIfAbsent(ch, new ArrayList<>());
			}
		}

		for(int i=0;i<words.length-1;i++){
			if(words[i].length()>words[i+1].length() && words[i].startsWith(words[i+1])){
				return "";
			}

			for(int j=0;j<words[i].length() && j<words[i+1].length();j++){
				if(words[i].charAt(j)!=words[i+1].charAt(j)){
					adjList.get(words[i+1].charAt(j)).add(words[i].charAt(j));
					break;
				}
			}
		}
		StringBuilder sb=new StringBuilder();

		for(char ch: adjList.keySet()){
			boolean result = dfs(ch, visited, adjList, sb);
			if(!result){
				return "";
			}

		}
		if (sb.length() < adjList.size()) {
			return "";
		}
		return sb.toString();
	}

	private boolean dfs(char ch, Map<Character, Boolean> visited, Map<Character,List<Character>> adjList, StringBuilder sb){
		if(visited.containsKey(ch)){
			return visited.get(ch);
		}
		visited.put(ch, false);
		for(Character nei: adjList.get(ch)){
			boolean result = dfs(nei, visited, adjList, sb);
			if(!result){
				return false;
			}
		}
		visited.put(ch, true);
		sb.append(ch);
		return true;
	}
}
