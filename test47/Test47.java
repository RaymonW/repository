package test47;
import java.util.*;


public class Test47 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums= {1,1,2};
		System.out.println(test.permuteUnique(nums));
	}
}

class Solution{
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> permuteUnique(int[] nums) {
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
			if(list.get(i)==list.get(p)&&i!=p) continue;  //如果两个数相同，就不交换，跳过，防止重复。
			else{
				int temp = list.get(p);
				list.set(p, list.get(i));
				list.set(i, temp);
				sort(p+1,list);
			}
		}
	}
}