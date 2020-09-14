package graphs;
/*
 * https://leetcode.com/problems/word-search/
 * 
 * Word Search:
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(dfs(board, word, i, j , 0)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int k){
		if(board[i][j]!=word.charAt(k)){
			return false;
		}
		if(k>=word.length()-1){
			return true;
		}

		char temp=board[i][j];
		board[i][j]='*';

		int x[]={-1,0,1,0};
		int y[]={0,-1,0,1};
		for(int p=0;p<4;p++){
			int x1=i+x[p];
			int y1=j+y[p];

			if(x1>=0 && x1<board.length && y1>=0 && y1<board[0].length && board[x1][y1]==word.charAt(k+1)){
				if(dfs(board,word,x1,y1,k+1)){
					return true;
				}
			}
		}
		board[i][j]=temp;
		return false;
	} 
}
