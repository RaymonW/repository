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

// ��˫ָ���������fast���꣬slow��ǰһ��������nextָ���һ�����ʼλ�á�pre��¼������׽ڵ㡣
// Ȼ��slowָ��pre����slow��nextͬʱ�ƶ����Ա�ǰ�������Ƿ���ͬ��
// ע��ͨ��fast.next==null�ж���������������ż�����ȡ�������˵ڶ��ζԱ�ʱslow�����ڵ㡣
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