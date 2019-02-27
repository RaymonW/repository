package test53;


public class Test53 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {-2,-1};
		System.out.println(test.maxSubArray(nums));
	}
}

class Solution {
    public int maxSubArray(int[] nums) {
    	if(nums.length==0) return 0;
    	int former = nums[0];
    	int max = former;
        for(int i=1;i<nums.length;i++) {
        	if (former<=0) former = nums[i];
        	else former +=nums[i];
        	max = Math.max(max, former);
        }
        return max;
    }
}