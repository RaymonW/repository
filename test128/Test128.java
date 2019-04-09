package test128;

import java.util.HashMap;
import java.util.Map;

public class Test128 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {100,4,200,1,3,2};
		System.out.println(test.longestConsecutive(nums));
	}
}

class Solution {
    public int longestConsecutive(int[] nums) {
    	Map<Integer, Integer> countForNum = new HashMap<Integer, Integer>();
        for(int num:nums) {
        	countForNum.put(num, 1);
        }
        for(int num:countForNum.keySet()) {
        	if(countForNum.get(num)==1) findLonger(countForNum, num);  //找过的序列中不包含num
        }
        int max = 0;
        for(int len:countForNum.values()) {
        	max = Math.max(len, max);
        }
        return max;
    }
    
    public void findLonger(Map<Integer, Integer> countForNum,int num) {
    	int count = num;
    	while(countForNum.containsKey(count+1)) {
    		count++;
    		if(countForNum.get(count)>1) {
    			countForNum.put(num, countForNum.get(count)+countForNum.get(num)); //如果count已经计过长度，直接用就行了，然后退出
    			break;
    		}
    		else {
    			countForNum.put(num, countForNum.get(num)+1);
    			countForNum.put(count, 2);  //在某次序列中出现过的就把它标记为2，主循环中如果遇到就不用再次调用方法找一次了，因为肯定更短
    		}
    	}
    }
}