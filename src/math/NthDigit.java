package math;
/*
 * https://leetcode.com/problems/nth-digit/
 * Nth Digit:
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 */
public class NthDigit {
	public int findNthDigit(int n) {
		long m=n;
		long start=1, len=1, count=9;
		while(m>len*count){
			m=m-len*count;
			count*=10;
			len++;
			start*=10;
		}

		start=start+(m-1)/len;

		String str=String.valueOf(start);
		return str.charAt((int) ((m-1)%len))-'0';


	}
}
