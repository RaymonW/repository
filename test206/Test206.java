package test206;

public class Test206 {
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6};
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for(int num:nums) {
			temp.next = new ListNode(num);
			temp = temp.next;
		}
		head = head.next;
		
		Solution test = new Solution();
		head = test.reverseList(head);
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}

class Solution{
	public ListNode reverseList(ListNode head) {
		if(head==null) return head;
        ListNode former = head;
        ListNode latter = head.next;
        while(latter!=null) {
        	former.next = latter.next;
        	latter.next = head;
        	head = latter;
        	latter = former.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}