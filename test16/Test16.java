package test16;
import java.util.*;

public class Test16 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(test.threeSumClosest(nums, target));
		
	}
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	if (nums.length<3) return 0;
    	Arrays.sort(nums);
    	int ans = nums[0]+nums[1]+nums[2];
    	int error = Math.abs(target-ans);
    	
    	for(int i=0;i<nums.length;i++) {
    		int j=i+1,k=nums.length-1;
    		while(j<k) {
    			int sum = nums[i]+nums[j]+nums[k];
    			if(target==sum) return target;
    			if(target>sum) {
					j++;
				}
				else k--;
    			error = Math.abs(target-ans);
    			if(Math.abs(target-sum)<error) ans = sum;    			
    		}
    	}
    	return ans;
    }
}