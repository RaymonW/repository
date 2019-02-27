package test29;


public class Test29 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int dividend = -2147483648;
		int divisor = -1;
		System.out.println(test.divide(dividend, divisor));
	}
}

class Solution {
    public int divide(int dividend, int divisor) {

    	int ans = 0;
    	if(Math.abs(dividend+divisor)== Math.abs(dividend)+Math.abs(divisor)) {
    		if(dividend>=0) {
    			while(dividend>=divisor) {
    				dividend -= divisor;
    				ans++;
    			}
    		}
    		else {
    			while(dividend<=divisor) {
    				dividend -= divisor;
    				ans++;
    			}
    		}
 		   
    	}
    	else {
    		if(dividend>=0) {
    			while(dividend>=-divisor) {
    				dividend += divisor;
    				ans--;
    			}
    		}
    		else {
    			while(-dividend>=divisor) {
    				dividend += divisor;
    				ans--;
    			}
    		}
    		
    	}
    	return ans;        
    }
}