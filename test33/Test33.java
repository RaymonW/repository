package test33;


public class Test33 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums= {1,2,4};
		int target =4;
		
		System.out.println(test.search(nums,target));
	}
}

class Solution {
    public int search(int[] nums, int target) {
    	if(nums.length==0) return -1;
    	
        int i=0,j=nums.length-1;
        if(target>=nums[0]) {
        	while(i<=j) {
        		if(j-i<=1) {
        			if(nums[i]==target) return i;
        			if(nums[j]==target) return j;
        			return -1;
        		}
        		int mid = (i+j)/2;
        		if (nums[mid] == target) return mid;
        		if(nums[mid]>nums[0]&&nums[mid]>target||nums[mid]<nums[0]) {
            		j = mid;
            	}
        		else {
        			i = mid;
        		}
        	}
        }
        else if(target<=nums[nums.length-1]) {
        	while(i<j) {
        		if(j-i==1) {
        			if(nums[i]==target) return i;
        			if(nums[j]==target) return j;
        			return -1;
        		}
        		int mid = (i+j)/2;
        		if (nums[mid] == target) return mid;
        		if(nums[mid]<nums[nums.length-1]&&nums[mid]<target||nums[mid]>nums[0]) {
            		i = mid;
            	}
        		else {
        			j = mid;
        		}
        	}
        	
        }
        return -1;
    }
}