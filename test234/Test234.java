package test234;
import java.util.*;
public class Test234 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {1,2,3,4,5,4,3,2,1};
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for(int num:nums) {
			temp.next = new ListNode(num);
			temp = temp.next;
		}
		head = head.next;
		System.out.print(test.isPalindrome(head));
	}
}

// 用双指针遍历，当fast走完，slow将前一半链表反向，next指向后一半的起始位置。pre记录反向的首节点。
// 然后slow指回pre，将slow和next同时移动，对比前后两半是否相同。
// 注意通过fast.next==null判断链表是奇数还是偶数长度。这决定了第二次对比时slow的起点节点。
class Solution { 
    public boolean isPalindrome(ListNode head) {
    	if(head == null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        ListNode next = head.next;
        while(fast.next!=null&&fast.next.next!=null) {
        	slow = next;
        	next = next.next;
        	fast = fast.next.next;
        	slow.next = pre;
        	pre = slow;
        }
        if(fast.next==null) {
        	slow = pre.next;
        }
        while(next!=null) {
        	if(slow.val!=next.val) return false;
        	next = next.next;
        	slow = slow.next;
        }
        return true;
    }
}

class ListNode{
	ListNode next;
	int val;
	ListNode(int val){
		this.val = val;
	}
}