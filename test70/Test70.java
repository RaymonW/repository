package test70;


public class Test70 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 4;
		System.out.println(test.climbStairs(n));
	}
}

class Solution {  //斐波那契数 规律，减少空间复杂度
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

//class Solution {  //我的 动态规划
//    public int climbStairs(int n) {
//    	int[] memo = new int[n+1];
//    	return dp(n,memo);
//    	
//    }
//    
//    int dp(int n, int[] memo) {
//    	if(n<=2) {
//    		memo[n] = n;
//    		return n;
//    	}
//    	else {
//    		memo[n] = (memo[n-1]>0?memo[n-1]:dp(n-1,memo)) + (memo[n-2]>0?memo[n-2]:dp(n-2,memo));
//    		return memo[n];
//    	}
//    }
//}