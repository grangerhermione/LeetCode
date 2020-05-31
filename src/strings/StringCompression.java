package strings;
/*
 * https://leetcode.com/problems/string-compression/
 * String Compression:
 * Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array
 */
public class StringCompression {
	public int compress(char[] chars) {
		int i=0,j=0;
		while(j<chars.length){
			int count=1;
			chars[i++]=chars[j];
			while(j<chars.length-1 && chars[j]==chars[j+1]){
				count++;
				j++;
			}
			if(count>1){
				String str=String.valueOf(count);
				for(char c:str.toCharArray()){
					chars[i++]=c;
				}
			}
			j++;

		}
		return i;
	}
}
