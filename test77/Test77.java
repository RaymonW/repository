package test77;
import java.util.*;

public class Test77 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 2;
		int k = 2;	
		List<List<Integer>> ans = test.combine(n,k);
		for(List<Integer> list:ans) 
			System.out.println(list);
	}
}

class Solution { //别人类似的思路，不过combine1的for循环里面的处理很聪明
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine1(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	public static void combine1(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine1(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
}

//class Solution { // 递归方法，由于有两个递归，很慢
//	List<List<Integer>> ans = new ArrayList<List<Integer>>();
//	
//    public List<List<Integer>> combine(int n, int k) {
//    	List<Integer> list = new ArrayList<>();
//    	dp(n,k,list,1);
//        return ans;
//    }
//    
//    public void dp(int n, int k, List<Integer> list, int start) {
//    	if(start+k>n+1) return;
//    	else if(k==0) {
//    		if(!ans.contains(list)) ans.add(list);
//    	}
//    	else {
//    		List<Integer> temp1 = new ArrayList<>(list);
//    		List<Integer> temp2 = new ArrayList<>(list);
//    		temp1.add(start);
//    		dp(n,k-1,temp1,start+1);
//    		dp(n,k,temp2,start+1);
//    	}
//    }
//}