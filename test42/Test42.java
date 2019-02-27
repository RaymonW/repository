package test42;

import java.util.*;

public class Test42 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] height = {4,2,3};
		System.out.println(test.trap(height));
	}
}


//还可以用栈实现，一次遍历，如果当前高度小于栈顶坐标位置高度，将坐标入栈，否则弹出顶部坐标，并用新顶部坐标对应高度
//和当前高度比较，较小值就是刚弹出的位置受限的高度，然后求该位置的积水情况，只要新顶部高度小于当前高度就持续循环。
//当前位置循环结束后，再往下一个位置。。。

// 暴力求解，遍历每个数，求其向左和向右遇到的最高值，最高值的最小值与该数的差即是其上的雨水量。
// 可以用动态规划，左一次遍历，右一次遍历，分别建立max_left[]和max_right[]数组，这样可以省去每个位置都向左向右遍历一次。
// 复杂度变成O(n).
class Solution {
	public int trap(int[] height) {
	    int ans = 0;
	    int size = height.length;
	    for (int i = 1; i < size - 1; i++) {
	        int max_left = 0, max_right = 0;
	        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
	            max_left = Math.max(max_left, height[j]);
	        }
	        for (int j = i; j < size; j++) { //Search the right part for max bar size
	            max_right = Math.max(max_right, height[j]);
	        }
	        ans += Math.min(max_left, max_right) - height[i];
	    }
	    return ans;
	}
}


// 我的方法，从两边往中间移动，每次求得两端能容纳的雨水量，
// 然后移动短板直到下一个比短板值更长的位置，再次求新的两端间的容纳量（减去前一次已经加上的量），直到两端相遇。
// 别人的方法，同样移动左右小的一方，左右移动时分别更新所遇的最高值，如果不更新，当前位置雨水量则为max_left(right)-cur.
// 此方法省去了中间一个for循环。
//class Solution {  
//    public int trap(int[] height) {
//    	if(height.length<=2) return 0;
//    	int ans = 0;
//    	int l=0,r=height.length-1,min=Math.min(height[l], height[r]);
//    	for(int k=l+1;k<r;k++) {
//			if(height[k]<min) ans += min-height[k];
//		} 
//    	
//    	while(r-l>1) {
//    		if(height[l]<=height[r]) {
//    			while(height[l]<=min&&l<r) l++;
//    		}
//    		else {
//    			while(height[r]<=min&&l<r) r--;
//    		}
//    		int newmin=Math.min(height[l], height[r]);
//    		for(int k=l+1;k<r;k++) {
//    			if(height[k]<newmin) ans += newmin-Math.max(height[k], min);
//    		} 
//    		min = newmin;
//    	}
//        return ans;
//    }
//}