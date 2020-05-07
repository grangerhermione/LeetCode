package sorting_searching;
/*
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * Divide Two Integers:
 * Given two integers dividend and divisor, divide two integers without using multiplication, 
 * division and mod operator. Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero, which means losing its fractional part. 
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        int sign='+';
        long dividendL=(long)dividend;
        long divisorL=(long)divisor;
        if((dividendL<0 && divisorL>0) || (divisorL<0 && dividendL>0)){
            if(dividendL<0){
                dividendL=-dividendL;
                sign='-';
            }
            if(divisorL<0){
                divisorL=-divisorL;
                sign='-';
            }
        }
        if(dividendL<0 && divisorL<0){
            dividendL=-dividendL;
            divisorL=-divisorL;
        }
        int count=0;
        while(dividendL>=divisorL){
           int numShift = 0; 
            while(dividendL>=(divisorL<<numShift)){
                numShift++;
            }
            count += 1<<(numShift-1);
            dividendL -= (divisorL<<(numShift-1));
        }
        
        if(sign=='-'){
            count=-count;
        }
        return count;
    }
}
