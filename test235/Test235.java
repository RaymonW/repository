package test235;

import java.util.*;


public class Test235 {
	
    public static void main(String[] args) {
    	Solution test = new Solution();
    	Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
    	TreeNode root = new TreeNode(nums[0]);
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	for(int i=1;i<nums.length;i++) {
    		TreeNode temp = queue.poll();
    		if(nums[i]!=null) {
    			temp.left = new TreeNode(nums[i]);
    			queue.add(temp.left);
    		}
    		i++;
    		if(i<nums.length&&nums[i]!=null) {
    			temp.right = new TreeNode(nums[i]);
    			queue.add(temp.right);
    		}
    	}
    	TreeNode p = new TreeNode(2);
    	TreeNode q = new TreeNode(4);
    	
    	System.out.print(test.lowestCommonAncestor(root,p,q).val);
    	
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        while(temp!=null) {
        	if(p.val<=temp.val&&temp.val<=q.val||p.val>=temp.val&&temp.val>=q.val) return temp;
        	if(temp.left!=null&&p.val<=temp.val&&q.val<=temp.val) temp = temp.left;
        	else if(temp.right!=null&&p.val>=temp.val&&q.val>=temp.val) temp = temp.right;
        }
    	return temp;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
