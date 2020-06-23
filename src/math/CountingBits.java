package math;
/*
 * https://leetcode.com/problems/counting-bits/
 * Counting Bits:
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.
 */
public class CountingBits {
	public int[] countBits(int num) {
		int result[]=new int[num+1];
		result[0]=0;

		int twoN=1;
		int count=1;
		for(int i=1;i<=num;i++){
			if(i==twoN){
				twoN=twoN<<1;
				count=1;
				result[i]=1;
			}
			else{
				result[i]=result[count]+1;
				count++;
			}
		}
		return result;

	}
}
