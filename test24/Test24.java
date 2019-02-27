package test24;


public class Test24 {
	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode head = new ListNode(0);
		int[] nums1 = {1,2,3,4,5};
		ListNode temp = head;
		for(int i=0;i<nums1.length;i++) {
			temp.next = new ListNode(nums1[i]);
			temp = temp.next;
		}
		head = head.next;
		System.out.println(test.swapPairs(head));		
	}
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        if(head==null) return null;
//        if(head.next==null) return head;
        
        while(head!=null) {
        	if(head.next==null) break;
        	int first = head.val;
        	head = head.next;
        	int second = head.val;
        	head = head.next;
        	temp.next = new ListNode(second);
        	temp = temp.next;
        	temp.next = new ListNode(first);
        	temp = temp.next;
        }
        if (head!=null) temp.next = head;
        ans = ans.next;
        return ans;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}