package test31;
import java.util.*;

public class Test31 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {3,2,1};
		test.nextPermutation(nums);
		System.out.println();
	}
}

class Solution {
    public void nextPermutation(int[] nums) {
    	boolean flag = false;
        for(int i=nums.length-1;i>0;i--) {
        	if(nums[i]<=nums[i-1]) continue;
        	else{
        		flag = true;
        		for(int j=nums.length-1;j>i-1;j--) {
        			if(nums[j]>nums[i-1]) {
        				int temp = nums[i-1];
                		nums[i-1] = nums[j];
                		nums[j] = temp;
                		for(int k=0;k<(nums.length-i)/2;k++) {
                			temp = nums[i+k];
                    		nums[i+k] = nums[nums.length-1-k];
                    		nums[nums.length-1-k] = temp;
                		}
                		break;
        			}
        		}
        		break;
        	}
        }
        if(!flag) {
        	for(int i=0;i<nums.length/2;i++)
        	{
        		int temp = nums[i];
        		nums[i] = nums[nums.length-1-i];
        		nums[nums.length-1-i] = temp;
        	}
        }
    }
}