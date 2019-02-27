package test39;
import java.util.*;

public class Test39 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] candidates = {7,3,2};
		int target = 18;
		System.out.println(test.combinationSum(candidates,target));
	}
	
}

class Solution {  //别人的答案，也是backtracking，先排序但是只要没加满就往里放，如果等于就写入，随后删除一位。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        
        return result;
    }
    
    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
    	if(target > 0){
    		for(int i = start; i < candidates.length && target >= candidates[i]; i++){
    			cur.add(candidates[i]);
    			getResult(result, cur, candidates, target - candidates[i], i);
    			cur.remove(cur.size() - 1);
    		}//for
    	}//if
    	else if(target == 0 ){
    		result.add(new ArrayList<Integer>(cur));
    	}//else if
    }
}

//class Solution { //情况考虑少了，不想写了
//	List<List<Integer>> ans = new ArrayList<List<Integer>>();
//	int original;
//	
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//    	List<Integer> cand = new ArrayList<>();
//    	for(int i:candidates) {
//    		cand.add(i);
//    	}
//    	cand.sort(null);
//    	original = target;
//    	boolean flag = sub(cand,target);
//    	return ans;
//    }
//    boolean sub(List<Integer> cand, int target) {
//    	boolean flag = false;
//    	if(cand.size()==0) return false;
//    	else {
//    		int first = cand.get(0);
//    		for(int time=0;time <= target/first;time++) {
//    			if(target==first*time) {
//            		List<Integer> temp = new ArrayList<>();
//        			for(int time2=0;time2 < time;time2++) {
//        				temp.add(first);
//        			}
//        			ans.add(temp);
//        			return true;	
//            	}
//    			if(sub(cand.subList(1, cand.size()),target-time*first)) {
//    				flag = true;
//    				for(List<Integer> list:ans) {
//    					int sum = 0;
//    					for(int i:list) sum +=i;
//    					if(sum!=original) {
//    						for(int time1=0;time1<time;time1++) {
//    							list.add(first);
//    							list.sort(null);
//    						}
//    					}
//					}	
//    				
//    			}
//    		}	
//    		
//    	}
//    	return flag;
//    }
//}