package test10;
import java.util.*;

public class Test10 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = new String("ab");
		String p = new String(".*");
		System.out.println(test.isMatch(s, p));
	}
}


class Solution {  //模仿Top down动态规划写的，用memory数组记录回溯过程中已经遇到过的匹配情况，减少计算复杂度
	Boolean[][] memory;

	public boolean isMatch(String s, String p) {
		memory = new Boolean[s.length()+1][p.length()+1];
		return dp(0, 0, s, p);
	}
	
	boolean dp(int i, int j, String s, String p)
	{
		Boolean ans;
		if (memory[i][j]!=null) return memory[i][j];
		
		if(j==p.length()) {
			ans = i == s.length();
		}
		else {
			boolean firstmatch = (i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'));
			if (j+1<p.length()&&p.charAt(j+1)=='*') {
				ans = dp(i,j+2,s,p)||
						(firstmatch &&dp(i+1,j,s,p));
			}
			else {
				ans = firstmatch && dp(i+1,j+1,s,p);
			}
		}
		memory[i][j] = ans;
		return ans;
	}
}
//class Solution {
//    public boolean isMatch(String s, String p) {
//    	int i=0,j=0;
//    	int firstDot = 0, firstStar = 0;
//    	int lastDot = 0, lastStar = 0;
//    	String tempP = new String(p);
//    	String tempS = new String(s);
//    	firstStar = tempP.indexOf("*");
//    	lastStar = tempP.lastIndexOf("*");
//    	String str1 = new String(tempP.substring(0,firstStar-1));
//    	String str2 = new String(tempP.substring(lastStar+1,tempP.length()));
//    	
//    	if (!dotMatch(str1,s.substring(0,firstStar-1)) || !dotMatch(str2,s.substring(lastStar,s.length()))) return false;
//
//    	tempP = tempP.substring(firstStar-1,lastStar+1);
//    	
//    	return true;
//    }
//    
//    boolean dotMatch(String s1, String s2) {
//    	int firstDot = 0;
//    	StringBuilder str = new StringBuilder(s2);
//    	while(s1.contains(".")) {
//    		firstDot = s1.indexOf(".", firstDot+1);
//    		if(firstDot<0) break;
//    		str.setCharAt(firstDot, '.');
//    	}
//    	if(s1.equals(str.toString())) return true;
//    	else return false;
//    }
//}
    
