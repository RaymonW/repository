package test21;


public class Test21 {
	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode temp = l1;
		int[] nums1 = {5};
		int[] nums2 = {1,2,4};
		for(int i=0;i<nums1.length;i++) {
			temp.next = new ListNode(nums1[i]);
			temp = temp.next;
		}
		temp = l2;
		for(int i=0;i<nums2.length;i++) {
			temp.next = new ListNode(nums2[i]);
			temp = temp.next;
		}
		l1=l1.next;
		l2=l2.next;
		System.out.println(test.mergeTwoLists(l1,l2));		
	}
}

class Solution {  //我的方法，用一个新链表每次末端指向较小节点。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode ans = new ListNode(0);
    	ListNode end = ans;
    	
    	while(l1!=null && l2!=null) {
    		if(l1.val<=l2.val) {
        		ListNode temp =end;
        		temp.next = new ListNode(l1.val);
        		end =temp.next;
        		l1 = l1.next;
        	}
        	else {
        		ListNode temp =end;
        		temp.next = new ListNode(l2.val);
        		end =temp.next;
        		l2 = l2.next; 
        	}
    	}
    	end.next = l1==null? l2:l1;
    	ans = ans.next;
    	return ans;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}