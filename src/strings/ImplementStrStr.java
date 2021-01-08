package strings;
/*
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr():
 * Implement strStr(). Return the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0) ){
                int count=1;
                for(int j=i+1;j<i+needle.length() && j<haystack.length();j++){
                    if((j-i)>=needle.length()){
                        break;
                    }
                    if(haystack.charAt(j) != needle.charAt(j-i) ){
                        break;
                    }
                    else{
                        count++;
                    }
                }
                if(count==needle.length())
                    return i;
            }
        }
        return -1;
    }
}
