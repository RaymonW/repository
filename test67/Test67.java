package test67;


public class Test67 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String a = "1010";
		String b = "1011";
		System.out.println(test.addBinary(a,b));
	}
}

class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        String ans = "";
        if(len1>len2) for(int i=0;i<len1-len2;i++) b = "0"+b;
        else for(int i=0;i<len2-len1;i++) a = "0"+a;
        int flag = 0;
        for(int i=a.length()-1;i>=0;i--) {
        	int sum = a.charAt(i)-('0')+b.charAt(i)-('0')+flag;
        	if(sum>=2) {
        		ans = (sum-2)+ans;
        		flag = 1;
        	}
        	else {
        		ans = sum+ans;
        		flag = 0;
        	}
        }
        if(flag == 1) ans = '1'+ans;
        return ans;
    }
}