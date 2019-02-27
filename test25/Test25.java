package test25;
import java.util.*;

public class Test25 {
	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode head = new ListNode(0);
		int k = 3;
		int[] nums1 = {1,2,3,4,5};
		ListNode temp = head;
		for(int i=0;i<nums1.length;i++) {
			temp.next = new ListNode(nums1[i]);
			temp = temp.next;
		}
		head = head.next;
		System.out.println(test.reverseKGroup(head,k));		
	}
}

class Solution{  //别人的方法，先找到链表长度，然后每次取前k个，继续递归直到找完。
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)    return null;
        ListNode l = head;
        int n = 0;
        while (l!=null){
            l = l.next;
            n++;
        }
        if(n<k){
            return head;
        }
        int inx = 0;
        ListNode next=null,p = head,pre=null;
        while (inx<k){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
            inx++;
        }
        if(n-k>=k){
            head.next = reverseKGroup(next,k);
        }else{
            head.next = next;
        }

        return pre;

    }
}

//class Solution {  //我的方法，取出前k个数字放入栈中，再弹出到ans链表。时间内存都较高
//    public ListNode reverseKGroup(ListNode head, int k) {
//    	ListNode ans = new ListNode(0);
//        ListNode temp = ans;
//        if(head==null) return null;
//        boolean flag = true;
//        Stack<Integer> stack = new Stack<>();
//        ListNode tail = new ListNode(0);
//        
//        while(head!=null&&flag) {
//        	tail = head;
//        	for(int i=0;i<k;i++) {
//            	if(head.next==null) {
//            		flag = false;
//            		stack.push(head.val);
//            		break;
//            	}
//            	else {
//            		stack.push(head.val);
//            		head = head.next;
//            	}
//            	
//            }
//        	if(stack.size()==k) {
//        		while(stack.size()!=0) {
//            		temp.next = new ListNode(stack.pop());
//                	temp = temp.next;
//            	}
//        		tail =null;
//        	}
//        }
//        if (tail!=null&&stack.size()!=k) temp.next = tail;
//        ans = ans.next;
//        return ans;
//    }
//}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}