package arrays;
/*
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Container With Most Water:
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains 
 * the most water.
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int max=0;
		int l=0;
		int r=height.length-1;
		while(l<r){
			max=Math.max(max,(r-l)*Math.min(height[l],height[r]));
			if(height[l]<height[r]){
				l++;
			}
			else{
				r--;
			}
		}
		return max;

	}
}
