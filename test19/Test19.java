package test19;
import java.util.*;

public class Test19 {
	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for(int i=2;i<6;i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		int n = 2;
		
		System.out.println(test.removeNthFromEnd(head,n));
		
	}
}

class Solution {  //我的方法，先找出长度再删，方法二可以两个指针固定间距同时移动，直到后者移到末尾，便可找到删除节点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	ListNode temp = head;
    	List<Integer> nums = new ArrayList<>();
    	while(temp.next!=null) {
    		nums.add(temp.val);
    		temp =temp.next;
    	}
    	nums.add(temp.val);
    	if(nums.size()>=n) nums.remove(nums.size()-n);
    	
    	ListNode ans = new ListNode(0);
    	temp = ans;
    	for(int num:nums) {
    		temp.next = new ListNode(num);
    		temp=temp.next;
    	}
    	ans = ans.next;
    	return ans;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}