package test695;

import java.util.*;

public class Test695 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] grid = 
						{{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		long begin = System.currentTimeMillis();
		System.out.println(test.maxAreaOfIsland(grid));
		long end = System.currentTimeMillis();
		System.out.println(end-begin+"ms");
	}
}

class Solution{
	private int ans = 0;
	int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
	public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]==1) {
        			dfs(grid,i,j);
        			max = Math.max(max, ans);
        			ans = 0;
        		}
        	}
        }
        return max;
    } 
	
	public void dfs(int[][] grid, int i, int j) { // 递归改循环，内存占用少了一点点，时间满了一倍
		ans++;
		grid[i][j] = 0;
		Stack<int []>stack = new Stack<>();
		int[] cor = {i,j};
		stack.add(cor);
		while(!stack.isEmpty()) {
			cor = stack.pop();
			i = cor[0];
			j = cor[1];
			
			for(int[] d:dir) {
				if(i+d[0]>=0&&i+d[0]<grid.length&&j+d[1]>=0&&j+d[1]<grid[0].length&&grid[i+d[0]][j+d[1]]==1) {
					ans++;
					int[] newcor = {i+d[0],j+d[1]};
					stack.add(newcor);
					grid[newcor[0]][newcor[1]]=0;
				}
			}
		}
	}
	
//	public void dfs(int[][] grid, int i, int j) { //递归实现dfs
//		if(grid[i][j]==0) {
//			return;
//		}
//		else ans++;
//		grid[i][j] = 0;
//		for(int[] d:dir) {
//			if(i+d[0]>=0&&i+d[0]<grid.length&&j+d[1]>=0&&j+d[1]<grid[0].length&&grid[i+d[0]][j+d[1]]==1)
//				dfs(grid, i+d[0], j+d[1]);
//		}
//	}
}