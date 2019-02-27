package test48;


public class Test48 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] matrix= {{}};
		test.rotate(matrix);
		System.out.println();
	}
}
//别人的方法，先上下颠倒，然后再斜对角交换。
class Solution { // 我的方法， 转换坐标系
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length/2;i++) {  //行
        	for(int j=i;j<matrix.length-1-i;j++) { //列
        		int last_x = i,last_y = j;
        		int temp1 = matrix[i][j];
        		int k=0;
        		while(k<4) {
        			int x = last_y;
            		int y = matrix.length-1-last_x;
            		int temp2 = matrix[x][y];
            		matrix[x][y] = temp1;
            		temp1 = temp2;
            		last_x = x;
            		last_y = y;
            		k++;
        		}
        	}
        }
    }
}