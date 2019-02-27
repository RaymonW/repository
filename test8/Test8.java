package test8;

public class Test8 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String str = new String("-2147483649");
		System.out.println(test.myAtoi(str));
	}	
}

class Solution {
    public int myAtoi(String str) {
        int result = 0;
        StringBuilder strBdr = new StringBuilder(0);
        for(char ch:str.toCharArray()) {
        	if(ch!=' ' && (ch<48 || ch>57) && ch!='-'&&ch!='+') { //is Character.isDigit(ch)Ìæ»»
        		if(strBdr.toString().isEmpty()) return result;
        		break;
        	}
        	else if(ch==' '&& strBdr.toString().isEmpty()) continue;
        	else if((ch=='-'||ch=='+')&& strBdr.toString().isEmpty()) {
        		strBdr.append(ch);
        	}
        	else if((int) ch<=57&&(int) ch>=48){
        		strBdr.append(ch);
        	}
        	else break;
        }
        try{
        	result = Integer.valueOf(strBdr.toString());
        }
        catch(NumberFormatException e) {
        	if(strBdr.toString().isEmpty()||strBdr.toString().equals("-")||strBdr.toString().equals("+")) return 0;
        	else if(strBdr.toString().contains("-")) return Integer.MIN_VALUE;
        	else return Integer.MAX_VALUE;
        }
        return result;
    }
}