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

class Solution { //���˵ķ�������col0����ע���Ͻ��Ƿ�Ϊ0������������һ�е�һ���Ƿ���0
	//Ȼ������ڲ����󣬵�һ�α�����0Ԫ�ص�����ͶӰ����һ�е�һ�У�������ȫ����0����ֹ������һ��ʱ����
	//�ڶ��α����õ�һ�е�һ�е�0��������������Ԫ���Ƿ���0��ͬʱ��һ�е�һ�и���col0�����Ƿ���0
	//�÷���ֻ����1��������O(1)
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

//class Solution { //�ҵı����취,������ǿ��ռ临�Ӷȣ�ʱ�临�Ӷ���С����M x N
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