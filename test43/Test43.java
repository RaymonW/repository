package test43;
import java.util.*;


public class Test43 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String num1 = "353";
		String num2 = "247";
		System.out.println(test.multiply(num1,num2));
	}
}


class Solution {  //我的方法，按正常乘法每位相乘得到字符串，再将所有字符串加和。比较慢。
    public String multiply(String num1, String num2) {
    	if(num1.length()==0||num2.length()==0) return "0";
    	else if(num1.charAt(0)=='0'||num2.charAt(0)=='0') return "0";
        String ans = "";
        List<String> list = new ArrayList<>();
        
        Stack<String> stack = new Stack<>();
        
        for(int i=num1.length()-1;i>=0;i--) {
        	int digit1 = num1.charAt(i)-'0';
        	int up = 0;
        	String str = new String("");
        	for(int k=num1.length()-1;k>i;k--) str += 0;
        	
        	for(int j=num2.length()-1;j>=0;j--) {
            	int digit2 = num2.charAt(j)-'0';
            	int mod = (digit1*digit2+up)%10;
            	str += mod;
            	up = (digit1*digit2+up)/10;
            	if(j==0&&up>0) str += up;
        	}
        	list.add(str);
        }
        for(int i=0;i<list.size();i++) {
        	ans = add(ans,list.get(i));
        }
        StringBuilder ans1= new StringBuilder(ans);
        ans1.reverse();
        return ans1.toString();
    }
    
    String add(String num1, String num2) { //数字是倒序的，12 + 34 -> "21" + "43"
    	String ans = "";
    	int len1 = num1.length();
    	int len2 = num2.length();
    	int up = 0;
    	for(int i=0;i<Math.min(len1, len2);i++) {
    		int digit1 = num1.charAt(i)-'0';
    		int digit2 = num2.charAt(i)-'0';
    		int mod = (digit1+digit2+up)%10;
    		ans += mod;
    		up = (digit1+digit2+up)/10;
    	}
    	if(len1>len2) {
    		if(up==1) ans += add("1",num1.substring(len2));
    		else ans +=num1.substring(len2);
    	}
    	else if(len2>len1){
    		if(up==1) ans += add("1",num2.substring(len1));
    		else ans +=num2.substring(len1);
    	}
    	else if(up==1) ans += "1";

    	return ans;	
    }
}