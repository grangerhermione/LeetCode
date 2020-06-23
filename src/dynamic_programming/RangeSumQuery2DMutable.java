package dynamic_programming;
/*
 * https://leetcode.com/problems/range-sum-query-2d-mutable/
 * 
 * Range Sum Query 2D - Mutable:
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its 
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 * The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
	int[][] matrix;
    int[][] sum;
    public RangeSumQuery2DMutable(int[][] matrix) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return;   
        }
        this.matrix=matrix;
        int m=matrix.length;
        int n=matrix[0].length;
        sum=new int[m][n];
        for(int i=0;i<m;i++){
            sum[i][0]=matrix[i][0];
            for(int j=1;j<n;j++){
                sum[i][j]=sum[i][j-1]+matrix[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        for(int i=col;i<matrix[0].length;i++){
            sum[row][i]+=val-matrix[row][col];
        }
        matrix[row][col]=val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        for(int i=row1;i<=row2;i++){
            if(col1>=1){
                res+=sum[i][col2]-sum[i][col1-1];
            }
            else{
                res+=sum[i][col2];
            }
        }
        return res;
    }
}
