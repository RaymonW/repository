package test236;

import java.util.*;

public class Test236 {
	public static void main(String[] args) {
    	Solution test = new Solution();
    	Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
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
    	TreeNode p = new TreeNode(5);
    	TreeNode q = new TreeNode(4);
    	
    	System.out.print(test.lowestCommonAncestor(root,p,q).val);
    }
}

class Solution{//直接递归
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null || root.val == p.val || root.val == q.val)
	        return root;
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    return left == null ? right : right == null ? left : root;
	}
}

//class Solution {//自己的太慢了
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//    	if(root.val==p.val||root.val==q.val) return root;
//    	TreeNode temp = root;
//    	boolean leftP = contains(temp.left, p);
//    	boolean leftQ = contains(temp.left, q);
//        if(leftP&&leftQ) temp = temp.left;
//        else if(!leftP&&!leftQ) temp = temp.right;
//        else return temp;
//    	return lowestCommonAncestor(temp,p,q);
//    }
//    public boolean contains(TreeNode root, TreeNode p) {
//    	if(root == null) return false;
//    	if(root.val == p.val) return true;
//    	return contains(root.left, p)||contains(root.right, p);
//    	
//    }
//}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}