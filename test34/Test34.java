package test34;


public class Test34 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {5,7,7,8,8,8,10};
		int target = 8;
		System.out.println(test.searchRange(nums,target));
	}
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int l=0,r=nums.length-1;
        while(l<=r) {
        	int m = (l+r)/2;
        	if(nums[m]==target) {
        		ans[0] = m;
        		ans[1] = m;
        		int k = m;
        		while(k>0&&nums[k-1]==target) {
        			ans[0] = k-1;
        			k--;
        		}
        		while(k<nums.length-1&&nums[k+1]==target) {
        			ans[1] = k+1;
        			k++;
        		}
        		return ans;        			
        	}
        	else if(nums[m]>target) {
        		r = m-1;
        	}
        	else l = m+1;
        }
        return ans;
    }
}