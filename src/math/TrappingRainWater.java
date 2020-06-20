package math;
/*
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Trapping Rain Water:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int left=0, right=height.length-1;
		int ans=0;
		int leftMax=0, rightMax=0;
		while(left<right){
			if (height[left] > leftMax) leftMax = height[left]; 
			if (height[right] > rightMax) rightMax = height[right];
			if (leftMax < rightMax) {
				ans += Math.max(0, leftMax-height[left]); 
				left++; 
			} else {
				ans += Math.max(0, rightMax-height[right]); 
				right--; 
			}
		}
		return ans;
	}
}
