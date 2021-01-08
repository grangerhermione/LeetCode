package math;
/*
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Reverse Integer:
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean flag = false;
		if (x < 0) {
			x = 0 - x;
			flag = true;
		}
		long res=0;
		while(x>0){
			int rem=x%10;
			res = res*10+rem;
			x = x/10;
		}
		if(flag){
			res=0-res;
		}
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return 0;
		} else {
			return (int)res;
		}

	}
}
