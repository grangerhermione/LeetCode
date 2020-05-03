import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0){
			return 0;
		}
		Set<Character> set=new HashSet<>();
		int i=0;
		int result=1;
		for(int j=0;j<s.length();j++){
			char c=s.charAt(j);
			if(!set.contains(c)){
				set.add(c);
				result=Math.max(result,set.size());
			}
			else{
				while(i<j){
					if(s.charAt(i)==c){
						i++;
						break;
					}
					set.remove(s.charAt(i));
					i++;
				}
			}
		}
		return result;
	}
}
