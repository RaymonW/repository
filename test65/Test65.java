package test65;

import java.util.regex.Pattern;

public class Test65 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s="1 a";
		System.out.println(test.isNumber(s));
	}
}

class Solution {  //正则表达式
    public boolean isNumber(String s) {
    	String pattern = "(\\-|\\+)?(\\d*\\.?\\d+|\\d+\\.?\\d*)(e(\\-|\\+)?\\d+)?";
    	String content = s.trim();
    	return Pattern.matches(pattern, content);
    }
}
//class Solution {
//    public boolean isNumber(String s) {
//        String str = s.trim();
//        if(str.length()==0) return false;
//        char[] ca = str.toCharArray();
//        boolean eFlag = false;
//        boolean dotFlag = false;
//        if(ca[0]!='-'&&ca[0]!='+'&&(ca[0]<'0'||ca[0]>'9')&&ca[0]!='.') return false;
//        if(ca[0]=='.') dotFlag = true;
//        if(ca[0]=='e') eFlag = true;
//        for(int i=1;i<ca.length;i++) {
//        	if(ca[i]!='e'&&ca[i]!='.'&&ca[i]!='+'&&ca[i]!='-'&&(ca[i]<'0'||ca[i]>'9')) return false;
//        	if(ca[i]=='e') {
//        		if(ca[i-1]<'0'||ca[i-1]>'9') return false;
//        		if(i==ca.length-1) return false;
//        		if(eFlag) return false;
//        		else eFlag = true;
//        	}
//        	else if(ca[i]=='.') {
//        		
//        		if(eFlag||dotFlag) return false;
//        		else dotFlag = true;
//        	}
//        	else if(ca[i]=='+'||ca[i]=='-') {
//        		if(i==ca.length-1) return false;
//        		if(ca[i-1]!='e') return false;
//        	}
//        }
//        if(ca.length==1&&ca[ca.length-1]<'0'||ca[ca.length-1]>'9') return false;
//        else return true;
//    }
//}