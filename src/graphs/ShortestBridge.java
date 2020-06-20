package graphs;
/*
 * https://leetcode.com/problems/shortest-bridge/
 * 
 * Shortest Bridge:
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 */

import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {
	public int shortestBridge(int[][] A) {
        List<Integer> x=new ArrayList<>();
        List<Integer> y=new ArrayList<>();
        boolean flag=false;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    dfs(A, x, y, i, j);
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        
        int count=0;
        while(true){
            count++;
            List<Integer> xTemp=new ArrayList<>();
            List<Integer> yTemp=new ArrayList<>();
            for(int i=0;i<x.size();i++){
                int dx=x.get(i);
                int dy=y.get(i);
                if(expand(A, xTemp, yTemp, dx+1, dy) || expand(A, xTemp, yTemp, dx, dy+1) || expand(A, xTemp, yTemp, dx-1, dy) || expand(A, xTemp, yTemp, dx, dy-1)){
                    return count;
                }
            }
            x=xTemp;
            y=yTemp;
        }
    }
    
    private boolean expand(int[][] A, List<Integer> x, List<Integer> y, int i, int j){
        if(!isValid(i, j, A.length, A[0].length)){
            return false;
        }
        if(A[i][j]==1){
            return true;
        }
        else if(A[i][j]==0){
            x.add(i);
            y.add(j);
            A[i][j]=2;
        }
        return false;
    }
    
    private void dfs(int[][] A, List<Integer> x, List<Integer> y, int i, int j){
        if(!isValid(i, j, A.length, A[0].length)){
            return;
        }
        if(A[i][j]==0){
            x.add(i);
            y.add(j);
        }
        else if(A[i][j]==1){
            A[i][j]=2;
            dfs(A, x, y, i+1,j);
            dfs(A, x, y, i,j+1);
            dfs(A, x, y, i-1,j);
            dfs(A, x, y, i,j-1);
        }
    }
    
    private boolean isValid(int x, int y, int m , int n){
        return (x>=0 && x<m && y>=0 && y<n);
    }
}
