package test27;
import java.util.*;

public class Test27 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {2,3};
		int val = 2;
		System.out.println(test.removeElement(nums,val));
	}
}

class Solution{
	public int removeElement(int[] nums, int val) {
	    int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	}
}
