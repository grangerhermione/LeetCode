package sorting_searching;
/*
 * https://leetcode.com/problems/powx-n/
 * 
 * Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 */
public class PowXN {
	public double myPow(double x, int n) {
        long pow=n;
        if(pow<0){
            x=1/x;
            pow=-pow;
        }
        return fastPower(x,pow);
    }
    
    public double fastPower(double x, long pow){
        if(pow==0){
            return 1.0;
        }
        double val=fastPower(x,pow/2);
        if(pow%2==0){
            return val*val;
        }
        else{
            return val*val*x;
        }
    }
}
