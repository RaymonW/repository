package test9;
import java.util.*;

public class Test9 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int x = 1331;
		System.out.println(test.isPalindrome(x));
	}
}

class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0) return false;
    	int copy_x = x;
    	int reverse_x = 0;
    	while(x>0) {
    		int pop = x%10;
    		reverse_x = reverse_x*10+pop;
    		x = x/10;
    	}
    	if (reverse_x == copy_x) return true;
    	else return false;
    }
}