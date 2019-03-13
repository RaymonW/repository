package test74;


public class Test74 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] matrix= {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}
				};
		int target = 0;
		System.out.println(test.searchMatrix(matrix,target));
	}
}

class Solution { // 二分
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0) return false;
    	else if(matrix[0].length==0) return false;
    	int l = 0, r = matrix.length-1;
        int row = searchRow(matrix, target, l, r);
        if(row == -1) return false;
        else {
        	return searchCol(matrix[row],target,0,matrix[0].length-1);
        }
    }

	public int searchRow(int[][] matrix, int target, int l, int r){
		if(l>r) return -1;
		else {
			if(target<matrix[l][0]||target>matrix[r][matrix[0].length-1]) return -1;
	    	else {
	    		if(target>=matrix[l][0]&&target<=matrix[l][matrix[0].length-1])
	    			return l;
	    		else if(target>=matrix[r][0]&&target<=matrix[r][matrix[0].length-1])
	    			return r;
	    		else if(r-l==1) return -1;
	    		else {
	    			int m = l +(r-l)/2;
	    			if (searchRow(matrix, target, l+1,m)>=0) 
	    				return searchRow(matrix, target, l+1,m);
	    			else if (searchRow(matrix,target,m,r-1)>=0) 
	    				return searchRow(matrix,target,m,r-1);
	    			else return -1;
	    		}
	    	}
		}
	}
	
	public boolean searchCol(int[] row, int target, int l, int r) {
		if(l>r) return false;
		else {
			if(row[l]==target||row[r]==target) return true;
			else {
				int m = l+(r-l)/2;
				boolean state = searchCol(row,target,l+1,m);
				if (state) return state;
				else return searchCol(row,target,m,r-1);
			}
		}
	}
		
}

//class Solution { // 原始
//    public boolean searchMatrix(int[][] matrix, int target) {
//    	if(matrix.length==0) return false;
//    	else if(matrix[0].length==0) return false;
//    	int row = -1;
//        for(int i=0;i<matrix.length;i++) {
//        	if(target>=matrix[i][0]&&target<=matrix[i][matrix[0].length-1]) {
//        		row = i;
//        		break;
//        	}
//        }
//        if(row == -1) return false;
//        else {
//        	for(int j=0;j<matrix[0].length;j++) {
//        		if(matrix[row][j]==target) return true;
//        	}
//        	return false;
//        }
//    }
//}