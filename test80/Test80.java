package test80;

import java.util.*;

public class Test80 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(test.removeDuplicates(nums));
	}
}

class Solution{
	public int removeDuplicates(int[] nums) {
		if(nums.length<=2) return nums.length;
        int replaced = nums[nums.length-1]+1;
        int cur = nums[0];
        int count = 0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]==cur) {
        		count++;
        		if(count>2) nums[i] = replaced;
        	}
        	else {
        		cur = nums[i];
        		count = 1;
        	}
        }
        Arrays.sort(nums);
        int replacednum = 0;
        for(int i=nums.length-1;i>=0;i--) {
        	if(nums[i]!=replaced) {
        		replacednum = i;
        		break;
        	}
        }
        return replacednum+1;
    }
}