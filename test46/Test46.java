package test46;
import java.util.*;



public class Test46 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums= {};
		System.out.println(test.permute(nums));
	}
}

class Solution{
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		for(int num:nums) list.add(num);
		sort(0,list);
		return ans;
	}
	
	void sort(int p, List<Integer> lastlist){
		List<Integer> list= new ArrayList<>(lastlist);
		if(p==list.size()-1) ans.add(list);
		for(int i=p;i<list.size();i++) {
			int temp = list.get(p);
			list.set(p, list.get(i));
			list.set(i, temp);
			sort(p+1,list);
		}
	}
}