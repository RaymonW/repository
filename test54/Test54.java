package test54;
import java.util.*;


public class Test54 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int[][] matrix = {{3},{2}};
		System.out.println(test.spiralOrder(matrix));
	}
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length==0) return ans;
        if(matrix.length==1) {
        	for(int j=0;j<matrix[0].length;j++)ans.add(matrix[0][j]);
        	return ans;
        }
        if(matrix[0].length==1) {
        	for(int i=0;i<matrix.length;i++)ans.add(matrix[i][0]);
        	return ans;
        }
        
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int k;
        for(k=0;k<(Math.min(len1,len2)+1)/2;k++) {
        	for(int j=k;j<len2-k;j++) 
        		ans.add(matrix[k][j]);
        	for(int i=k+1;i<len1-k;i++) 
        		ans.add(matrix[i][len2-k-1]);
        	for(int j=len2-k-2;j>=k+1&&len1-k-1!=k;j--) 
        		ans.add(matrix[len1-k-1][j]);
        	for(int i=len1-k-1;i>=k+1&&k!=len2-k-1;i--) 
        		ans.add(matrix[i][k]);
        }
        return ans;
    }
}
