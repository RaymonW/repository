package test45;


public class Test45 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] a= {1,2,1,1,1};
		System.out.println(test.jump(a));
	}
}

class Solution{  //贪心算法，每次在当前点所及范围内找到下次能跳到最远距离的点。
	int jump(int[] nums) {
	    if (nums.length <= 1)
	        return 0;
	    int step = 0;
	    int index = 0;
	    int len = nums.length;
	    int p = 0;
	    while (p <= len - 1) {
	        if (p + nums[p] >= len - 1)
	            return step + 1;
	        int max = -1;
	        for (int i = p + 1; i <= p + nums[p]; ++i) {
	            if (max < i + nums[i]) {
	                max = i + nums[i];
	                index = i;
	            }
	        }
	        step++;
	        p = index;
	    }
	    return step;
	}
}

//class Solution{  //我的dp算法，虽然基本遍历了所有途径，但是其实没有必要，应该用贪婪算法，每次只找下一次能跳的最远的点。
//	int min;
//	int ans=0;
//	Integer[] memo;
//	
//	public int jump(int[] a) {
//		int len = a.length;
//		min = len;
//		memo = new Integer[a.length];
//		memo[a.length-1] = 0;
//		sub(a,0,len);
//		return min;	
//	}
//	
//	void sub(int[] a, int i, int len) {
//		if(memo[i]!=null) {
//			ans = ans + memo[i];
//			if(ans<min) min = ans;
//			ans = ans - memo[i];
//		}
//		else {
//			if(a[i]+i>=len-1) {
//				memo[i] = 1;
//				if(ans<min) min = ans+1;
//			}
//			else {
//				for(int j=i+1;j<=i+a[i]&&j<len;j++)	{
//					ans += 1;
//					if(memo[j]!=null) {
//						if(memo[i]==null) memo[i] = memo[j]+1;
//						else memo[i] = memo[j]+1<memo[i]?memo[j]+1:memo[i];
//					}
//					sub(a,j,len);
//					ans -=1;
//				}
//			}
//		}
//		
//	}
//}