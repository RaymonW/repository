package test26;
import java.util.*;

public class Test26 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {1,1,2};
		System.out.println(test.removeDuplicates(nums));		
	}
}

class Solution{
	public int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
}

//class Solution {  //我的方法，开辟了新的空间
//    public int removeDuplicates(int[] nums) {
//    	int ans = 0;
//    	ArrayList<Integer> temp = new ArrayList<>();
//    	Set<Integer> set = new HashSet<>();
//    	for (int num:nums) {
//    		if(!set.contains(num)) {
//    			set.add(num);
//    			temp.add(num);
//    			ans++;
//    		}
//    	}
//    	nums = new int[temp.size()];
//    	for(int i=0;i<temp.size();i++) nums[i]=temp.get(i);
//    	return ans;     
//    }
//}