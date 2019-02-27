package test44;


public class Test44 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "leetcode";
		String p = "*e*t?d*";
		System.out.println(test.isMatch(s,p));
	}
}

class Solution {
	Boolean[][] memo;
    public boolean isMatch(String s, String p) {
    	memo = new Boolean [s.length()+1][p.length()+1];
    	boolean ans = dp(0,0,s,p);
        return ans;
    }
    
    boolean dp(int i,int j,String s,String p) {
    	Boolean ans = false;
    	if(memo[i][j]!=null) return memo[i][j];
    	if(j==p.length()) ans = i==s.length();
    	else {
    		if(p.charAt(j)!='*') {
    			ans = (i<s.length()
    					&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
    					&&dp(i+1,j+1,s,p));
    		}
    		else if(j+1<p.length()&&i<=s.length()) {
    			if(i==s.length()) {
    				ans = true;
    				for(int k=j;k<p.length();k++) {
    					ans = ans&&p.charAt(k)=='*';
    				}
    			}
    			for(int k=i;k<s.length();k++) {
    				ans = ans||dp(k,j+1,s,p);
    			}
    		}
    		else ans =true;
    	}
    	memo[i][j] = ans;
    	return ans;
    }
}