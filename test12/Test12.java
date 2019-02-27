package test12;
import java.util.*;

public class Test12 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int num = 1994;
		System.out.println(test.intToRoman(num));
		
	}
}

class Solution{
	String intToRoman(int num) { // 别人的方法,找到特殊的数字
	    int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String str[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < values.length; i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(str[i]);
	        }
	    }
	    return sb.toString();
	}
} 

//class Solution {  //我的笨办法
//    public String intToRoman(int num) {
//        StringBuilder ans = new StringBuilder("");
//        Stack<Character> stackChar = new Stack<>();
//        stackChar.push('I');
//        stackChar.push('V');
//        stackChar.push('X');
//        stackChar.push('L');
//        stackChar.push('C');
//        stackChar.push('D');
//        stackChar.push('M');
//        Stack<String> strdigit = new Stack<>();
//        while(num>0) {
//        	StringBuilder str = new StringBuilder();
//        	int digit = num%10;
//        	if(stackChar.size() == 1) { //到达千位，写完结束循环
//        		for(int i=0;i<digit;i++) str.append(stackChar.get(0));
//        		strdigit.push(str.toString());
//        		break;
//        	}
//            if (digit<4) {
//            	for(int i=0;i<digit;i++) str.append(stackChar.get(0));
//            }
//            else if(digit==4) {
//            	str.append(stackChar.get(0));
//            	str.append(stackChar.get(1));
//            }
//            else if(digit>=5&&digit<=8) {
//            	str.append(stackChar.get(1));
//            	for(int i=0;i<digit-5;i++) str.append(stackChar.get(0));
//            }
//            else {  //=9
//            	str.append(stackChar.get(0));
//            	str.append(stackChar.get(2));
//            }
//            strdigit.push(str.toString());
//            num = num/10;
//            stackChar.remove(0);
//            stackChar.remove(0);
//        }
//        while(!strdigit.isEmpty()) {
//        	ans.append(strdigit.pop());
//        }            
//        return ans.toString();
//    }
//}