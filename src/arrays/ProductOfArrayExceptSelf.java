package arrays;
/*
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Product of Array Except Self:
 * Given an array nums of n integers where n > 1,  return an array output such that 
 * output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        result[0]=1;
        for(int i=0;i<nums.length-1;i++){
            result[i+1]=result[i]*nums[i];
        }
        
        int prod=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]=result[i]*prod;
            prod=nums[i]*prod;
        }
        return result;
    }
}
