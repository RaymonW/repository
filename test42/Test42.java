package test42;

import java.util.*;

public class Test42 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] height = {4,2,3};
		System.out.println(test.trap(height));
	}
}


//��������ջʵ�֣�һ�α����������ǰ�߶�С��ջ������λ�ø߶ȣ���������ջ�����򵯳��������꣬�����¶��������Ӧ�߶�
//�͵�ǰ�߶ȱȽϣ���Сֵ���Ǹյ�����λ�����޵ĸ߶ȣ�Ȼ�����λ�õĻ�ˮ�����ֻҪ�¶����߶�С�ڵ�ǰ�߶Ⱦͳ���ѭ����
//��ǰλ��ѭ��������������һ��λ�á�����

// ������⣬����ÿ����������������������������ֵ�����ֵ����Сֵ������Ĳ�����ϵ���ˮ����
// �����ö�̬�滮����һ�α�������һ�α������ֱ���max_left[]��max_right[]���飬��������ʡȥÿ��λ�ö��������ұ���һ�Ρ�
// ���Ӷȱ��O(n).
class Solution {
	public int trap(int[] height) {
	    int ans = 0;
	    int size = height.length;
	    for (int i = 1; i < size - 1; i++) {
	        int max_left = 0, max_right = 0;
	        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
	            max_left = Math.max(max_left, height[j]);
	        }
	        for (int j = i; j < size; j++) { //Search the right part for max bar size
	            max_right = Math.max(max_right, height[j]);
	        }
	        ans += Math.min(max_left, max_right) - height[i];
	    }
	    return ans;
	}
}


// �ҵķ��������������м��ƶ���ÿ��������������ɵ���ˮ����
// Ȼ���ƶ��̰�ֱ����һ���ȶ̰�ֵ������λ�ã��ٴ����µ����˼������������ȥǰһ���Ѿ����ϵ�������ֱ������������
// ���˵ķ�����ͬ���ƶ�����С��һ���������ƶ�ʱ�ֱ�������������ֵ����������£���ǰλ����ˮ����Ϊmax_left(right)-cur.
// �˷���ʡȥ���м�һ��forѭ����
//class Solution {  
//    public int trap(int[] height) {
//    	if(height.length<=2) return 0;
//    	int ans = 0;
//    	int l=0,r=height.length-1,min=Math.min(height[l], height[r]);
//    	for(int k=l+1;k<r;k++) {
//			if(height[k]<min) ans += min-height[k];
//		} 
//    	
//    	while(r-l>1) {
//    		if(height[l]<=height[r]) {
//    			while(height[l]<=min&&l<r) l++;
//    		}
//    		else {
//    			while(height[r]<=min&&l<r) r--;
//    		}
//    		int newmin=Math.min(height[l], height[r]);
//    		for(int k=l+1;k<r;k++) {
//    			if(height[k]<newmin) ans += newmin-Math.max(height[k], min);
//    		} 
//    		min = newmin;
//    	}
//        return ans;
//    }
//}