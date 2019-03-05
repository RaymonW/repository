package test66;


public class Test66 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] digits = {0};
		System.out.println(test.plusOne(digits));
	}
}

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
        	if(digits[i]==9) digits[i]=0;
        	else {
        		digits[i] += 1;
        		break;
        	}
        }
        if (digits[0]==0) {
        	int[] newdigits = new int[digits.length+1];
        	newdigits[0] = 1;
        	for(int i=0;i<digits.length;i++) newdigits[i+1] = digits[i];
        	return newdigits;
        }
        else return digits;
    }
}