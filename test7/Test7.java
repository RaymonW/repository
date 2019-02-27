package test7;
import java.util.*;

public class Test7 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int x = -123;
		System.out.println(test.reverse(x));
	}
}

class Solution {  //���˵Ĵ𰸣�˼·������
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

//class Solution { //�ڶ��δ𰸣�ͨ��parseIntȷ����ֵ��Խ��
//    public int reverse(int x) {
//        int result=0;
//        StringBuilder reverse_str = new StringBuilder();
//        if(x<0) reverse_str.append("-");
//        Stack stack = new Stack();
//        while(x!=0) {
//        	int digit = x%10;    
//        	stack.push(digit);
//        	reverse_str.append(String.valueOf(Math.abs(digit)));
//        	x = x/10;      	
//        }
//        try{
//    		Integer.parseInt(reverse_str.toString());
//    	}catch(NumberFormatException e) {
//    		return result;
//    	}
//        int i = 1;
//        while(!stack.isEmpty()) {
//        	
//        	result = result+i*(int)stack.pop();
//        	i*=10;
//        }
//    	return result;
//    }
//}

//class Solution { //��һ�δ𰸣����ǲ���ȫ��ע����ֵԽ��
//    public int reverse(int x) {
//        int result=0;
//        Stack stack = new Stack();
//        while(x!=0) {
//        	int digit = x%10;    
//        	stack.push(digit);
//        	x = x/10;      	
//        }
//        int i = 1;
//        while(!stack.isEmpty()) {
//        	result = result+i*(int)stack.pop();
//        	i*=10;
//        }
//    	return result;
//    }
//}