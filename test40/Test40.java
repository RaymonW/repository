package test40;
import java.util.*;

public class Test40 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(test.combinationSum2(candidates,target));
	}
}

class Solution {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	List<Integer> cur = new ArrayList<>();
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	sub(candidates,target,0);
    	return ans;
    }
    
    void sub(int[]candidates,int target,int start) {
    	if(target>0) {
			for(int i=start;i<candidates.length&&target>=candidates[i];i++) {
					cur.add(candidates[i]);
        			sub(candidates,target-candidates[i],i+1);
					cur.remove(cur.size()-1);
			}
		}
		else if(target == 0&&!ans.contains(cur)) {
				ans.add(new ArrayList<Integer>(cur));
		}
	}
    
}