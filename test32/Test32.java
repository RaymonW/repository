package test32;
import java.util.*;


public class Test32 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "(()()(((()";
		System.out.println(test.longestValidParentheses(s));
	}
}



class Solution {
	public int longestValidParentheses(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        for(int i=0;i<str.length();i++) {
        	if(str.charAt(i)=='(') str.setCharAt(i, ')');
        	else str.setCharAt(i, '(');
        }
		return Math.max(sub(s), sub(str.toString()));
	}
	
    int sub(String s) {
    	Map<Character,Integer> map = new HashMap<>();
    	map.put('(', 1);map.put(')', -1);
        int ans2 = 0;int maxans = 0;
        int sum = 0;
        int left = 0;int right =0;
        int i =0;
        for(char ch:s.toCharArray()) {
        	sum += map.get(ch);
        	i++;
        	if(sum>0) {
        		if(sum==1&&ch=='(') left = i;
        	}
        	else if(sum==0){
        		right = i;
        		if(left-right>1) ans2 = i- left+1;
        		else ans2 = ans2 + i-left+1;
        		maxans = Math.max(maxans, ans2);
        	}
        	else{
        		sum = 0;
        		ans2 = 0;
        	}
        }
        return maxans;
    }
}

//class Solution {
//public int longestValidParentheses(String s) {
//	Map<Character,Integer> map = new HashMap<>();
//	map.put('(', 1);map.put(')', -1);
//  int ans = 0;
//  int sum = 0;
//  int len = 0;
//  for(char ch:s.toCharArray()) {
//  	sum += map.get(ch);
//  	if(sum>0) {
//  		len++;
//  	}
//  	else if(sum==0){
//  		len+=2;
//  		ans = Math.max(ans, len);
//  	}
//  	else{
//  		len = 0;
//  		sum = 0;
//  	}
//  }
//  if(sum==0) return ans;
//  else {
//  	ans = len-ans;
//  	return ans;
//  }
//  
//}
//}