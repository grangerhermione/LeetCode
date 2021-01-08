package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * First Unique Character in a String:
 * Given a string, find the first non-repeating character in it and return its index. 
 * If it doesn't exist, return -1.
 */
public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		Map<Character,Integer> map=new HashMap<>();
		int indexArr[] = new int[s.length()];

		for(int i=0;i<s.length();i++){
			indexArr[i]=i;
			char c = s.charAt(i);
			if(map.containsKey(c)){
				int index = map.get(c);
				indexArr[index] = (-1);
				indexArr[i] = -1;
				map.put(c, i);
			}
			else{
				map.put(c,i);
			}
		}

		for(int i=0;i<s.length();i++){
			if(indexArr[i]!=-1){
				return i;
			}
		}
		return -1;
	}

	//	public int firstUniqChar(String s) {
	//		Map<Character,Integer> map=new HashMap<>();
	//	    
	//	    for(int i=0;i<s.length();i++){
	//	        char ch=s.charAt(i);
	//	        map.put(ch, map.getOrDefault(ch, 0)+1);
	//	    }
	//	    
	//	    for(int i=0;i<s.length();i++){
	//	        char ch=s.charAt(i);
	//	        if(map.get(ch)==1){
	//	            return i;
	//	        }
	//	    }
	//	    return -1;
	//	}
}
