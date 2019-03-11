package test73;
import java.util.*;
public class Test73 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] matrix= {
				{0,0,0,5},
				{4,3,1,4},
				{0,1,1,1},
				{1,1,1,1},
				{0,0,1,1}};
		test.setZeroes(matrix);
		System.out.println(matrix);
	}
}

class Solution { //别人的方法，用col0来标注左上角是否为0，用于最后给第一行第一列是否置0
	//然后遍历内部矩阵，第一次遍历将0元素的坐标投影到第一行第一列，而不是全部置0，防止遍历下一行时覆盖
	//第二次遍历用第一行第一列的0来决定遍历到的元素是否置0，同时第一行第一列根据col0来看是否置0
	//该方法只用了1个变量，O(1)
    public void setZeroes(int[][] matrix) {
    	int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}

//class Solution { //我的暴力办法,这道题是看空间复杂度，时间复杂度最小都是M x N
//    public void setZeroes(int[][] matrix) {
//    	if(matrix.length==0) return;
//    	int n = matrix.length;
//    	int m = matrix[0].length;
//    	Set<Integer> col = new HashSet<>();
//    	for(int i=0;i<n;i++) {
//    		boolean flag = false;
//    		for(int j=0;j<m;j++) {
//    			if(matrix[i][j]==0) {
//    				flag = true;
//    				col.add(j);
//    			}
//    		}
//    		if(flag) Arrays.fill(matrix[i],0);
//    	}
//    	for(int i=0;i<n;i++) for(int k:col) matrix[i][k] = 0;
//    }
//}