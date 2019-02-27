package test41;

import java.util.Arrays;

public class Test41 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {3,4,-1,1};
		System.out.println(test.firstMissingPositive(nums));
	}
}

class Solution{  //通过把数放在其数字对应位置，然后再搜索第一个位置和数值不符的数的位置即是结果。
    public int firstMissingPositive(int A[]) {
    	int n = A.length;
    	for(int i = 0; i < n; ++ i) {
    		while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
    			int temp = A[i];
    			A[i] = A[temp - 1];
    			A[temp - 1] = temp;
    		}
    	}
        for(int i = 0; i < n; ++ i) {
        	if(A[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }
}

//class Solution {
//    public int firstMissingPositive(int[] nums) {
//    	if(nums.length==0) return 1;
//        int first = 0;
//        int second = 0;
//    	Arrays.sort(nums);
//    	if(nums[nums.length-1]<=0||nums[0]>1) return 1;
//    	else {
//    		for(int i=0;i<nums.length;i++) {
//    			if(nums[i]>0) {
//    				if(second!=0) {
//    					first = second;
//    					second = nums[i];
//    				}
//    				else if(first!=0) {
//    					second = nums[i];
//    				}
//    				else {
//    					first = nums[i];
//    					if(first>1) return 1;
//    				}
//    				if(second-first>1) return first+1;
//    			}
//    			
//    		}
//    	}
//    	return nums[nums.length-1]+1;
//    }
//}