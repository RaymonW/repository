package test63;

import java.util.Arrays;

public class Test63 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] obstacleGrid = {{0,0,0,0,0},{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0}};
		
		System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
	}
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid.length==0) return 0;
    	else if(obstacleGrid[0].length==0) return 0;
    	int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
    	for(int[] me:memo) Arrays.fill(me, -1);
        return dp(0,0,obstacleGrid,memo);
    }
    
    int dp(int i, int j, int[][] obstacleGrid, int[][] memo) {
    	if(obstacleGrid[i][j]==1) return 0;
    	int ans = 0;
    	if(memo[i][j]>=0) {
    		return memo[i][j];
    	}
    	else if(i>=obstacleGrid.length-1) {
    		ans = 1;
    		for(int k=j;k<obstacleGrid[0].length&&ans == 1;k++) {
    			if(obstacleGrid[i][k]==1) ans = 0;
    		}
    	}
    	else if(j>=obstacleGrid[0].length-1) {
    		ans = 1;
    		for(int k=i;k<obstacleGrid.length&&ans == 1;k++) {
    			if(obstacleGrid[k][j]==1) ans = 0;
    		}
    	}
    	else {
    		ans = (memo[i+1][j]>0?memo[i+1][j]:dp(i+1,j,obstacleGrid,memo))
    				+(memo[i][j+1]>0?memo[i][j+1]:dp(i,j+1,obstacleGrid,memo));
    	}
    	memo[i][j] = ans;
    	return ans;
    }
}