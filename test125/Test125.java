package test125;

public class Test125 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = new String("0P");
		System.out.println(test.isPalindrome(s));
	}
}

class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<=r) {
        	while(!isAlphanumeric(s.charAt(l))&&l<r) l++;
        	while(!isAlphanumeric(s.charAt(r))&&l<r) r--;
        	if(!isEquals(s.charAt(l), s.charAt(r))) return false;
        	l++;
        	r--;
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
    	if((c>='A'&&c<='Z')||(c>='a'&&c<='z'||c>='0'&&c<='9')) return true;
    	else return false;
    }
    
    public boolean isEquals(char a, char b) {
    	if(a-b==0||(a-b==32&&b>='A'&&b<='Z')||(b-a==32&&a>='A'&&a<='Z')) return true;
    	else return false;
    }
}