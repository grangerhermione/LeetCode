package dynamic_programming;
/*
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * 
 * Range Sum Query 2D - Immutable:
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle 
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2D {
	int sum[][];
	public RangeSumQuery2D(int[][] matrix) {
		int m=matrix.length;
		if(m!=0){
			int n=matrix[0].length;
			sum=new int[m][n];
			for(int i=0;i<m;i++){
				sum[i][0]=matrix[i][0];
				for(int j=1;j<n;j++){
					sum[i][j]=sum[i][j-1]+matrix[i][j];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int result=0;
		for(int i=row1;i<=row2;i++){
			if(col1-1>=0){
				result+=(sum[i][col2]-sum[i][col1-1]);
			}
			else{
				result+=(sum[i][col2]-0);
			}
		}
		return result;
	}
}
