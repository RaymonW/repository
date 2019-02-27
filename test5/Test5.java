package test5;

public class Test5 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "cccc";
		System.out.println(test.longestPalindrome(s));
	}
}

class Solution { //我的方法，两个while的地方可以不嵌套，直接分成两种情况并列求解，减少复杂度。可参考Approach4
    public String longestPalindrome(String s) {
    	String result = new String(s);
    	int l=0,m=0,r=0;
    	int maxlen=1;
    	for(m=0;m+maxlen/2<s.length();m++) {
    		int len = 1;
    		l=r=m;
    		while(s.length()>1&&l>=0 && r<s.length()) {
    			if(l==r) {
    				while(r<s.length()-1&&s.charAt(r)==s.charAt(r+1)) {
        				r=r+1; //偶数情况
        				if(l!=0&&s.charAt(l)==s.charAt(l-1)) l=l-1; //又变奇数情况
        			}
    			}
    			if(s.charAt(l)==s.charAt(r)) {
    				len = r-l+1;
    				if(len>=maxlen) {
    					maxlen = len;
    					result = s.substring(l,r+1);
    				}
    				l--;
    				r++;
    			}
        		else break;
    		}
    		
    	}
    	return result;
    }
}