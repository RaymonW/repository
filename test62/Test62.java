package test62;


public class Test62 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int m = 0;
		int n = 1;
		System.out.println(test.uniquePaths(m, n));
	}
}

class Solution {
    public int uniquePaths(int m, int n) {
    	if(m==0||n==0) return 0;
    	int[][] memo = new int[m][n];
        return dp(m-1,n-1,memo); 
    }
    int dp(int m, int n, int[][] memo) {
    	if(m<=0||n<=0) {
    		memo[m][n] = Math.min(m+1, n+1);
    		return Math.min(m+1, n+1);
    	}
    	int ans = (memo[m-1][n]>0?memo[m-1][n]:dp(m-1,n,memo)) 
    			+ (memo[m][n-1]>0?memo[m][n-1]:dp(m,n-1,memo));
    	memo[m][n] = ans;
    	return ans;
    }
}