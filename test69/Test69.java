package test69;


public class Test69 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int x = 2147483647;
		System.out.println(test.mySqrt(x));
	}
}

class Solution {  //mid>x/mid可以防止mid*mid数值越界
    public int mySqrt(int x) {
    	if(x==0) return 0;
        int l=0, r=x;
        while(l<r) {
        	int mid = (l+r)/2;
        	if(mid>x/mid) r = mid;
        	else if(mid<x/mid) l = mid+1;
        	else return mid;
        }
        if(l>x/l) return l-1;
        else return l;
    }
}

//class Solution {
//    public int mySqrt(int x) {
//        int ans = 1;
//        if(x==0) ans = 0;
//        for(int i=1;i<=x;i++) {
//        	if(Math.pow(i, 2)>x) return i-1;
//        }
//        return ans;
//    }
//}