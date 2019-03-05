package test64;


public class Test64 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] grid = {{1,2,5},{3,2,1}};
		System.out.println(test.minPathSum(grid));
	}
}

class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid.length==0) return 0;
    	else if(grid[0].length==0) return 0;
        int[][] memo = new int[grid.length][grid[0].length];
    	return dp(0,0,grid,memo);
    }
    
    int dp(int i,int j,int[][] grid,int[][] memo) {
    	int ans = 0;
//    	if(i>=grid.length||j>=grid[0].length) {
//    		return 0;
//    	}
//    	else {
    		if(i+1>=grid.length) 
    			ans = (j+1>=grid[0].length?0:(memo[i][j+1]>0?memo[i][j+1]:dp(i,j+1,grid,memo)));
    		else {
    			ans = j+1>=grid[0].length?(memo[i+1][j]>0?memo[i+1][j]:dp(i+1,j,grid,memo)):
    				Math.min((memo[i+1][j]>0?memo[i+1][j]:dp(i+1,j,grid,memo))
    	    				,(memo[i][j+1]>0?memo[i][j+1]:dp(i,j+1,grid,memo)));
    		}		
//    	}
    	ans = grid[i][j]+ans;
    	memo[i][j] = ans;
    	return ans;
    }
}