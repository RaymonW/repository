package test18;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test18 {
	public static void main(String[] args) {
		Solution18 test = new Solution18();
		int[] nums = {-1,-3,-4,1,2,3,4};
		int target = 0;	
		System.out.println(test.fourSum(nums, target));		
	}
}

//class Solution18 {  //我的答案
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//    	List<List<Integer>> result = new ArrayList<List<Integer>>();
//    	int i1,i2,i3,i4;
//    	for(i1=0;i1<nums.length;i1++) {
//    		for(i2=i1+1;i2<nums.length;i2++) {
//    			for(i3=i2+1;i3<nums.length;i3++) {
//    				int need = target-nums[i1]-nums[i2]-nums[i3];
//    				ArrayList nums_list = new ArrayList();
//    				for(i4=i3+1;i4<nums.length;i4++) {
//    					nums_list.add(nums[i4]);
//    				}
//    				if(nums_list.contains(need)) {
//    					List<Integer> ans = new ArrayList<Integer>();
//    					ans.add(nums[i1]);
//    			    	ans.add(nums[i2]);
//    			    	ans.add(nums[i3]);
//    			    	ans.add(need);
//    			    	ans.sort(null);
//    			    	if(!result.contains(ans)) {
//    			    		result.add(ans);
//    			    	}
//    				}
//    			}
//    		}
//    	}
//    	return result; 
//    }
//}

//别人的答案
//先排序，然后确定前两个数字，
//后两个数字从j+1开始和数组末尾往中间按求和条件搜索，
//一轮搜索完之后第二个数再后换一个数直到搜索结束，
//再把第一个数往后换一个数直到搜索结束。
class Solution18 { 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums.length<4)
            return list;
        Arrays.sort(nums);
        boolean iFirst=false;
        for(int i=0;i<nums.length-3;i++){
            if(i>=1&&nums[i]==nums[i-1])
                continue;
            iFirst=true;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1)
                    iFirst=false;
                if((!iFirst)&&j>=2&&nums[j]==nums[j-1])
                    continue;
                int m=j+1,n=nums.length-1;
                while(m<n){
                    if(nums[i]+nums[j]+nums[m]+nums[n]==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;n--;
                        while(m<n&&nums[m]==nums[m-1])m++;  //换个新数字
                        while(m<n&&nums[n]==nums[n+1])n--;  //换个新数字
                    }else if(nums[i]+nums[j]+nums[m]+nums[n]>target)
                        n--;
                    else 
                        m++;
                    
                }
            }
        }
        return list;
    }
}
