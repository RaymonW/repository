package test;
import java.lang.*;

public class Test{
	public static void main(String[] args){
		Solution1 sol = new Solution1();
		ListNode1 sum;
		ListNode1 l1 = new ListNode1(9);
//		l1.next = new ListNode1(3);
//		l1.next.next = new ListNode1(1);
		ListNode1 l2 = new ListNode1(1);
		ListNode1 temp = l2;
		int i=1;
		while(i<9) {
			temp.next =new ListNode1(9);
			temp = temp.next;
			i++;
		}
//		temp.next = new ListNode1(9);

		sum = sol.addTwoNumbers(l1, l2);
		System.out.println(sum);		
	}
}

class ListNode1 {
	int val;
	ListNode1 next;
	ListNode1(int x) { val = x;} 
}

class Solution1 {
    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
    	int add1=0;
    	int add2=0;
    	int sum;
    	ListNode1 temp = new ListNode1(0);
    	int len1=0;
    	int len2=0;
    	temp=l1;
    	while(temp!=null) {
    		add1=add1+temp.val*(int)Math.pow(10, len1);
    		temp=temp.next;
    		len1++;
    	}
    	temp=l2;
    	while(temp!=null) {
    		add2=add2+temp.val*(int)Math.pow(10, len2);
    		temp=temp.next;
    		len2++; 
    	}
    	sum=add1+add2;
    	
    	int len = 1;
    	int dig = sum % 10;
    	ListNode1 sumList = new ListNode1(dig);
    	temp = sumList;
    	while(sum>=Math.pow(10, len)) {
    		len++;
    		dig = sum % (int)Math.pow(10, len);
    		if(dig<(int)Math.pow(10, len-1)) {
    			dig = 0;
    		}
    		else {
    			dig = (int)dig/(int)Math.pow(10, len-1);
    		}
        	temp.next = new ListNode1(dig);
        	temp = temp.next;
    	}
    	return sumList;    
    }
}