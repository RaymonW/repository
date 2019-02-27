package test59;



public class Test59 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 5;
		int[][] ans = test.generateMatrix(n);
		System.out.println(ans);
	}
}

class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] ans = new int[n][n];
    	int i=0,j=0;
    	int start=0,end=n-1;
    	boolean state1=true,state2=false,state3=false,state4=false;
    	for(int k=1;k<=n*n;k++) {
    		if(state1) {
    			ans[i][j]=k;
    			if(j==end) {
    				i++;
    				state1=false;
    				state2=true;
    			}
    			else j++;
    		}
    		else if(state2) {
    			ans[i][j]=k;
    			if(i==end) {
    				j--;
    				state2=false;
    				state3=true;
    			}
    			else i++;
    		}
    		else if(state3) {
    			ans[i][j]=k;
    			if(j==start) {
    				i--;
    				state3=false;
    				state4=true;
    			}
    			else j--;
    		}
    		else {
    			ans[i][j]=k;
    			if(i==start+1) {
    				j++;
    				state4=false;
    				state1=true;
    				start++;
    				end--;
    			}
    			else i--;
    		}

    	}
    	return ans;
    }
}