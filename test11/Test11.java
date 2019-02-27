package test11;
import java.util.*;

public class Test11 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(test.maxArea(height));
		}
}

class Solution { //堆栈实现，更慢但是据说常用
    public int maxArea(int[] height) {
        int ans=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i : height) stack.push(i);
        while(stack.size()>0) {
        	ans = Math.max(ans, (stack.size()-1)*Math.min(stack.firstElement(), stack.lastElement()));
        	if(stack.firstElement()<=stack.lastElement()) stack.remove(0);
        	else stack.pop();
        }
        return ans;
    }
}

//class Solution {  //自己实现网上方法2，巧妙
//    public int maxArea(int[] height) {
//        int ans=0;
//        int l=0,r=height.length-1;
//        while(l<r) {
//        	ans = Math.max(ans, ((height[l] < height[r])?  (height[l] * (r - l++))  :  (height[r]*(r-- - l))));
//        }
//        
//        return ans;
//    }
//}