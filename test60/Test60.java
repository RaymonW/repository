package test60;
import java.util.*;


public class Test60 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 4;
		int k = 9;
		System.out.println(test.getPermutation(n, k));
	}
}

class Solution {
    public String getPermutation(int n, int k) {
    	char[] ans =new char[n];
    	int[] digit = new int[n];
    	List<Character> list = new ArrayList<>();
    	for(int i=1;i<=n;i++) list.add((char)('0'+i));
    	int mod = k;	
        for(int i=n-1;i>=0;i--) {
        	int fact = factorial(i);
        	digit[n-1-i] = mod/fact;
        	if(mod%fact==0 && mod!=0) {  //如果刚好整除，下一位之后的数字排列一定是最大排列，将mod置最大。e.g. 12~6543
        		digit[n-1-i]-=1;
        		mod = factorial(i);
        	}
        	else mod = mod%fact;
        }
        for(int i=0;i<n;i++) {
        	ans[i] = list.get(digit[i]);
        	list.remove(digit[i]);
        }
        return String.valueOf(ans);
    }
    
    int factorial(int n) {
    	int ans=1;
    	for(int i=n;i>1;i--) ans = i*ans;
    	return ans;
    }
}