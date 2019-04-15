package test79;
import java.util.*;

public class Test79 {
	public static void main(String[] args) {	
		Solution test = new Solution();
		char[][] board = 
				{
				  {'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}
				};
		String word = new String("ABCB");
		System.out.print(test.exist(board, word));
		
	}
}

class Solution {
	boolean[][] memo;
	int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public boolean exist(char[][] board, String word) {
    	if(board.length==0||board[0].length==0) return false;
    	memo = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(exist2(board, word, i, j)) return true;
        	}
        }
    	return false;
    }
    public boolean exist2(char[][] board, String word, int row, int col) {
    	if(board[row][col]!=word.charAt(0)) return false;
    	else {
    		if(word.length()==1) return true;
    		memo[row][col] = true;
    		for(int[] dir:dirs) {
    			int rowNext = row+dir[0];
    			int colNext = col+dir[1];
    			if(rowNext>=0&&rowNext<board.length
    					&&colNext>=0&&colNext<board[0].length
    					&&(!memo[rowNext][colNext])
    					&&exist2(board, word.substring(1), rowNext, colNext)) return true;
    		}
    		memo[row][col] = false;
    		return false;
    		
    	}
    }
}