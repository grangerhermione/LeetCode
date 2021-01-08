package strings;
/*
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * Compare Version Numbers:
 * Given two version numbers, version1 and version2, compare them.
 * Version numbers consist of one or more revisions joined by a dot '.'. 
 * Each revision consists of digits and may contain leading zeros. 
 * Every revision contains at least one character. Revisions are 0-indexed from left to right, 
 * with the leftmost revision being revision 0, the next revision being revision 1, and so on. 
 * For example 2.5.33 and 0.1 are valid version numbers.
 * To compare version numbers, compare their revisions in left-to-right order. 
 * Revisions are compared using their integer value ignoring any leading zeros. 
 * This means that revisions 1 and 001 are considered equal. 
 * If a version number does not specify a revision at an index, then treat the revision as 0. 
 * For example, version 1.0 is less than version 1.1 because their revision 0s are the same, 
 * but their revision 1s are 0 and 1 respectively, and 0 < 1.
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String tokens1[]=version1.split("\\.");
		String tokens2[]=version2.split("\\.");
		int i=0, j=0;
		while(i<tokens1.length && j<tokens2.length){
			int num1=Integer.parseInt(tokens1[i]);
			int num2=Integer.parseInt(tokens2[j]);
			if(num1>num2){
				return 1;
			}
			if(num1<num2){
				return -1;
			}
			i++;
			j++;
		}
		while(i<tokens1.length){
			int num1=Integer.parseInt(tokens1[i]);
			if(num1!=0){
				return 1;
			}
			i++;
		}
		while(j<tokens2.length){
			int num1=Integer.parseInt(tokens2[j]);
			if(num1!=0){
				return -1;
			}
			j++;
		}
		return 0;
	}
}
