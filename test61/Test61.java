package test61;


public class Test61 {
	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode head = new ListNode(0);
		ListNode temp = head;
		int[] nums = {0,1,2};
		for(int i=0;i<nums.length;i++) {
			temp.next = new ListNode(nums[i]);
			temp = temp.next;
		}
		head=head.next;
		int k = 4;
		System.out.println(test.rotateRight(head, k));
	}
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null||head.next==null) return head;
    	
    	ListNode temp = head;
    	int len = 1;
        while(temp!=null) {
        	if(temp.next!=null) {
        		temp = temp.next;
        		len++;
        	}
        	else {
        		temp.next = head;
        		break;
        	}
        }
        for(int i=0;i<len-(k%len);i++) {
        	temp = temp.next;        	
        }
        ListNode temp2 = temp.next;
        temp.next = null;
        return temp2;
   
    }
}

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}