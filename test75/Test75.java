package test75;

public class Test75 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {1,2,2,2,2,0,0,0,1,1};
		test.sortColors(nums);
		for(int n:nums) System.out.print(n);
	}
}

class Solution {
    public void sortColors(int[] nums) {
        int l=0,r=nums.length-1;
        for(int i=0;i<nums.length&&i<=r;i++) {
        	if(nums[i]==0) {
        		while(nums[l]==0&&l<i) l++;
        		swap(nums,i,l);
        		l++;
        	}
        	else if(nums[i]==2) {
        		while(nums[r]==2&&i<r) r--;
        		swap(nums,i,r);
        		if(nums[i]==0) {
        			swap(nums,i,l);
        			l++;
        		}
        		r--;
        	}
        }
    }
    
    public void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}