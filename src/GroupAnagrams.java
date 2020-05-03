import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, group anagrams together.
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map=new HashMap<>();
		for(String str:strs){
			char array[]= new char[26];
			for(int i=0;i<str.length();i++){
				char ch = str.charAt(i);
				array[ch-'a']++;
			}
			String s = new String(array);
			if(map.containsKey(s)){
				map.get(s).add(str);
			}
			else{
				List<String> arr=new ArrayList<>();
				arr.add(str);
				map.put(s,arr) ;  
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for(Map.Entry<String,List<String>> entry: map.entrySet()){
			result.add(entry.getValue());
		}
		return result;
	}
}
