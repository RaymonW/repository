package test51;
import java.util.*;

public class Test51 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 4;
		System.out.println(test.solveNQueens(n));
	}
}

class Solution {
	List<List<String>> ans = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
    	char[][] board = new char[n][n];
        fill(board,0);
        return ans;
    }
    void fill(char[][]board, int i) {
    	char[][] temp = new char[board.length][board.length];
    	for(int k=0;k<board.length;k++) System.arraycopy(board[k], 0, temp[k], 0, board.length); //¸´ÖÆËÑË÷Ç°ÆåÅÌ
    	for(int j=0;j<board.length;j++) {
    		for(int k=0;k<board.length;k++) System.arraycopy(temp[k], 0, board[k], 0, board.length); //¸´ÅÌ
    		if(board[i][j]!='.') {
    			board[i][j]='Q';
    			ban(board,i,j);
    			if(i+1<board.length) fill(board,i+1);
    			else {
    				List<String> solution = new ArrayList<>();
    	    		for(char[] row:board) solution.add(String.valueOf(row));
    	    		ans.add(solution);
    			}
    		}
    		else continue;
    	}
    }
    
    void ban(char[][] board,int p,int q) {
    	for(int i=0;i<board.length;i++) {
    		if(i!=q) board[p][i] = '.';
    		if(i!=p) board[i][q] = '.';
    		if(i!=0&&p+i<board.length&&q-i>=0) board[p+i][q-i] = '.';
    		if(i!=0&&p+i<board.length&&q+i<board.length) board[p+i][q+i] = '.';
    	}
    }
    
}