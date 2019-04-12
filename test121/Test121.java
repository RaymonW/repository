package test121;

public class Test121 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] prices = {7,1,5,3,6,4};
		System.out.print(test.maxProfit(prices));
	}
}

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int min = prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i]-min);
        }
        return ans;
    }
}