package test4;
import java.util.*;

public class Test4 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums1= {5};
		int[] nums2= {2,3,4};
		System.out.println(test.findMedianSortedArrays(nums1, nums2));
	}
}

class Solution { //别人的答案，由于都是有序数组，两端分界，直到找到合适的边界，在边界确定中值
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

//class Solution {  //我的方法一，复杂度太高
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    	int midIndex1,midIndex2;
//    	double result;
//        List list = new ArrayList ();
//
//        for(int i=0;i<nums1.length;i++) {
//        	list.add(nums1[i]);
//        }
//        for(int i=0;i<nums2.length;i++) {
//        	list.add(nums2[i]);
//        }
//        list.sort(null);
//        
//        if(list.size()%2==0) {
//        	midIndex1=list.size()/2-1;
//        	midIndex2=midIndex1+1;
//        }
//        else midIndex1=midIndex2=list.size()/2;
//        result = ((double)(int)list.get(midIndex1)+(int)list.get(midIndex2))/2;
//        return result;
//    }
//}