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
        	if(countForNum.get(num)==1) findLonger(countForNum, num);  //�ҹ��������в�����num
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
    			countForNum.put(num, countForNum.get(count)+countForNum.get(num)); //���count�Ѿ��ƹ����ȣ�ֱ���þ����ˣ�Ȼ���˳�
    			break;
    		}
    		else {
    			countForNum.put(num, countForNum.get(num)+1);
    			countForNum.put(count, 2);  //��ĳ�������г��ֹ��ľͰ������Ϊ2����ѭ������������Ͳ����ٴε��÷�����һ���ˣ���Ϊ�϶�����
    		}
    	}
    }
}