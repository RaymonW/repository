package test15;
import java.util.*;

public class Test15 {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		Solution15 test = new Solution15();
		System.out.println(test.threeSum(nums));
	}
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i1,i2,i3;
        
        for(i1=0;i1<nums.length-2;i1++) {
        	if(i1!=0&&nums[i1]==nums[i1-1]) continue; 
        	i3 = nums.length-1;
        	i2=i1+1;
        	while(i2<i3) {
        		if(nums[i1]+nums[i2]+nums[i3]==0) {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(nums[i1]);
        			list.add(nums[i2]);
        			list.add(nums[i3]);
        			result.add(list);
        			++i2;
        			while(i2<i3&&nums[i2]==nums[i2-1]) i2++;
        		}
        		else if(nums[i1]+nums[i2]+nums[i3]>0) {
        			i3--;
        		}
        		else i2++;
        	}      	
        }
        return result;
    }
}