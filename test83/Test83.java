package test83;

public class Test83 {
	public static void main(String[] args) {
		int[] nums= {1,1};
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for(int num:nums) {
			temp.next = new ListNode(num);
			temp = temp.next;
		}
		head = head.next;
		
		Solution test = new Solution();
		head = test.deleteDuplicates(head);
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}

class Solution {
//	public ListNode deleteDuplicates(ListNode head) {  //网上的递归方法，递归多了栈帧太多，内存和时间都略有增加
//	    if (head == null || head.next == null) return head;
//	    head.next = deleteDuplicates(head.next);
//	    return head.val == head.next.val ? head.next : head;
//	}
    public ListNode deleteDuplicates(ListNode head) {  //我的顺序修改链表，因为每次操作简单所以稍快
    	if(head == null || head.next == null) return head;
    	ListNode temp = head;
        while(temp.next!=null) {
        	if(temp.val == temp.next.val) temp.next = temp.next.next;
        	else temp = temp.next;
        }
        if(head.next!=null&&head.val == head.next.val) head = head.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}