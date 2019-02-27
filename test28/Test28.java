package test28;


public class Test28 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String haystack = new String("hello");
		String needle = new String("ll");
		System.out.println(test.strStr(haystack,needle));
	}
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++)
        {
        	if(haystack.substring(i,i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}