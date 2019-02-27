package test35;


public class Test35 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {5,7,7,10};
		int target = 7;
		System.out.println(test.searchInsert(nums,target));
	}
}

class Solution {
    public int searchInsert(int[] nums, int target) {
    	int l=0,r=nums.length;
        while(l<r) {
       	int mid = (l+r)/2;
        	if(target<=nums[mid]) r = mid;
        	else l = mid+1;
        }
        return r;    
    }
}