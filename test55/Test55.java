package test55;


public class Test55 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {0};
		System.out.println(test.canJump(nums));
	}
}

class Solution{
	public boolean canJump(int[] nums) {
	    //The index to reach
	    int target = nums.length-1;
	    // max index reached so far while iterating the array
	    int reached = 0;
	    
	    for(int i = 0; i<target; i++){  //O(n)�ĸ��Ӷȣ�ֻҪ�������Χ�ڣ��Ͱ�����������������
	        //�������Χ��ͷ�����������������졣
	        if(nums[i] <1 && reached <=i){
	            return false;
	        }
	        //Update the max reach so far
	        reached = Math.max(nums[i] + i, reached);
	    }
	    //If the reach is greater than or equal to the reach, it means it is reachable
	    if(reached >= target){
	        return true;
	    } else {
	        return false;
	    }
	}
}


//class Solution {  //�ҵķ�����̫�����ˡ���������ķ�ʽ�����˸��Ӷ�
//	int ans = 0;
//	
//    public boolean canJump(int[] nums) {
//    	if(nums.length==0) return true;
//        int[] max = new int[nums.length];
//        Arrays.fill(max, -1);  //��¼ÿһλ���ܵ������Զ���룬��������
//        return dp(nums,0,max);
//    }
//    
//    boolean dp(int[] nums, int cur,int[] max) {
//    	boolean flag = false;
//    	for(int i=cur;i<=cur+nums[cur];i++) {
//    		if(ans>=nums.length-1) return true;
//			if(max[i]==-1) {
//				max[cur] = Math.max(max[cur],i+nums[i]);
//				max[i] = Math.max(max[i], i+nums[i]);
//	        	ans = max[cur]>ans? max[cur]:ans;
//	        	if(ans>=nums.length-1) return true;
//	        	else if(nums[i]>=1&&i+1<nums.length) flag = dp(nums,i+1,max);
//			}
//        }	
//    	return flag;
//    }
//}
