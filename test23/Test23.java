package test23;

import java.util.*;

public class Test23 {
	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode l3 = new ListNode(0);
		int[] nums1 = {1,4,6};
		int[] nums2 = {-1,5};
		int[] nums3 = {4,5,6};
		
		ListNode temp = l1;
		for(int i=0;i<nums1.length;i++) {
			temp.next = new ListNode(nums1[i]);
			temp = temp.next;
		}
		temp = l2;
		for(int i=0;i<nums2.length;i++) {
			temp.next = new ListNode(nums2[i]);
			temp = temp.next;
		}
		temp = l3;
		for(int i=0;i<nums3.length;i++) {
			temp.next = new ListNode(nums3[i]);
			temp = temp.next;
		}
		l1=l1.next;
		l2=l2.next;
		l3=l3.next;
		ListNode tes = new ListNode(0);
		tes = tes.next;
		ListNode[] lists = {l1,l2,l3,tes};
		System.out.println(test.mergeKLists(lists));		
	}
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	boolean nullInitial=true;
    	int minHead = 0;
    	for(ListNode list:lists) {
    		if(list!=null) {
    			nullInitial = false;
    			minHead = list.val;
    		}
    	}
    	if (lists.length == 0 || nullInitial) return null;
    	
    	ListNode ans = new ListNode(0);
    	ListNode end = ans;
    	List<Integer> minIndexList = new ArrayList<>();
    	
    	int notNull = 0;
    	ListNode lastList = new ListNode(0);
    	while(notNull!=1) {
    		notNull = 0;
    		for(int i=0;i<lists.length;i++) {
        		if(lists[i] == null) continue;
        		else {
        			notNull++;
        			if(notNull == 1) minHead = lists[i].val;
        			if(lists[i].val<minHead) {
            			minHead = lists[i].val;
            			minIndexList.clear();
            			minIndexList.add(i);
            		}
            		else if(lists[i].val==minHead) {
            			minIndexList.add(i);
            		}
        		}
        	}
    		
        	for(int i:minIndexList) {
        		lists[i] = lists[i].next;
        		end.next = new ListNode(minHead);
            	end = end.next;
        	}
        	notNull = 0;
        	for(ListNode list2:lists) {
        		if (list2!=null) notNull++;
        		lastList = null;
        	}
        	if (notNull==0) break;
        	if (notNull<=1) {
        		for(ListNode list:lists) {
        			if(list!=null) {
        				lastList = list;
        				break;
        			}
        			else lastList = null;
        		}
        	}
        	minIndexList.clear();
    	}
    	if(lastList!=null) end.next = lastList;
    	ans = ans.next;
    	return ans;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}