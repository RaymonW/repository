package test2;

public class Test2{
	public static void main(String[] args){
		Solution2 sol = new Solution2();
		ListNode sum;
		ListNode l1 = new ListNode(9);
//		l1.next = new ListNode(3);
//		l1.next.next = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode temp = l2;
		int i=1;
		while(i<10) {
			temp.next =new ListNode(9);
			temp = temp.next;
			i++;
		}
//		temp.next = new ListNode(9);
		sum = sol.addTwoNumbers(l1, l2);
		System.out.println(sum);		
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x;} 
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode sumList = new ListNode(0);
    	int add1 = 0;
    	int add2 = 0;
    	int sum = 0;
    	int flag = 0;
    	ListNode temp1 = l1;
    	ListNode temp2 = l2;
    	ListNode tempsum = sumList;
    	
    	while(temp1!=null || temp2!=null || flag==1) {
    		if (temp1!=null) {
    		add1 = temp1.val;
    		}
    		else add1 = 0;
    		if (temp2!=null) {
    		add2 = temp2.val;
    		}
    		else add2 = 0;
    		
    		sum = add1+add2+flag;
    		if (sum>=10) {
    			flag = 1;
    		}
    		else flag = 0;
    		tempsum.val=sum % 10;
    		
    		if(temp1!=null) {
    			temp1 = temp1.next;
    		}
    		if(temp2!=null) {
    			temp2 = temp2.next;
    		}
    		if(temp1==null&&temp2==null&&flag==0) {
    			tempsum = tempsum.next;
    		}
    		else {
    			tempsum.next = new ListNode(0);
    			tempsum = tempsum.next;
    		}
    	}
    	return sumList;    
    }
}
