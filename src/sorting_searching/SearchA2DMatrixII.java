package sorting_searching;
/*
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Search a 2D Matrix II:
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length;
		if(m==0){
			return false;
		}
		int n=matrix[0].length;

		int i=m-1;
		int j=0;

		while(i>=0 && j<n){
			if(matrix[i][j]>target){
				i--;
			}
			else if(matrix[i][j]<target){
				j++;
			}
			else{
				return true;
			}
		}
		return false;
	}
}
