package test36;
import java.util.*;


public class Test36 {
	public static void main(String[] args) {
		Solution test = new Solution();
		char[][] board = {
//				{'5','3','.','.','7','.','.','.','.'},
//				{'6','.','.','1','9','5','.','.','.'},
//				{'.','9','8','.','.','.','.','6','.'},
//				{'8','.','.','.','6','.','.','.','3'},
//				{'4','.','.','8','.','3','.','.','1'},
//				{'7','.','.','.','2','.','.','.','6'},
//				{'.','6','.','.','.','.','2','8','.'},
//				{'.','.','.','4','1','9','.','.','5'},
//				{'.','.','.','.','8','.','.','7','9'}
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(test.isValidSudoku(board));
	}
}

class Solution {  //别人的方法，注意set的巧用,另外这里i和j都不只是代表行、列，有时候互换定义，是个trick。
    public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3); //当i固定，变化j可以遍历整个cube；当j固定时，变化i同样可以全部遍历。
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
}

//class Solution {  //我的暴力方式,超时，主要是理解错误，我的是直到找到正确解，答案是题目符合要求就行。
//    public boolean isValidSudoku(char[][] board) {
//    	boolean ans =false;
//        String numstr = "123456789";
//        char[][] newboard = new char[board.length][board.length];
//    	for(int i=0;i<board.length;i++) {
//    		for(int j=0;j<board.length;j++) {
//    			newboard[i][j]=board[i][j];
//    		}
//    	}
//    	for(int i=0;i<board[0].length;i++) {
//    		ArrayList<Character> nums = new ArrayList<>();  //数字列表
//    		for(char ch: numstr.toCharArray()) nums.add(ch); 
//    		ArrayList<Character> row = new ArrayList<>();  //初始行列表
//    		for(char ch:newboard[i]) row.add(ch);
//    		
//    		for(int j=0;j<row.size();j++) {
//    			if(nums.contains(row.get(j))) nums.remove(row.get(j));  //还没填的数字
//    		}
//    		if(i==8&&nums.size()==1) {
//    			System.out.println("stop");
//    		}
//      		for(int j=0;j<row.size();j++) {
//      			if(newboard[i][j]=='.') {
//      				for(char ch: nums) {
//      					newboard[i][j]=ch;
//      					row.set(j, ch);
//      					ArrayList<Character> column = new ArrayList<>();
//              			for(int k=0;k<newboard[0].length;k++) column.add(newboard[k][j]);  //列列表
//              			ArrayList<Character> cube = new ArrayList<>();
//              			int r = i/3*3;
//              			int c = j/3*3;
//              			for(int m = 0;m<3;m++) {
//              				for(int n=0;n<3;n++) {
//              					cube.add(newboard[r+m][c+n]);  //方阵列表
//              				}
//              			}
//              			if(check(row,numstr)&&check(column,numstr)&&check(cube,numstr)) {
//              				if(i==board.length-1&&nums.size()==1) return true;
//              				else if(isValidSudoku(newboard)) {
//              					return true;
//              				}
//              			}
//              			else if(nums.indexOf(ch)==nums.size()-1) return false;  //所有数字都不行
//      				}
//      			}
//      			else continue;
//      		}
//    	}
//    	return ans;
//    }
//    
//    boolean check(ArrayList<Character> list, String numstr) {
//    	ArrayList<Character> nums = new ArrayList<>();  //数字列表
//		for(char ch: numstr.toCharArray()) nums.add(ch);
//		
//		ArrayList<Character> list1 = (ArrayList<Character>) list.clone();
//		
//		for(int j=0;j<nums.size();j++) {
//    		if(list.contains(nums.get(j))) list1.remove(nums.get(j));
//    	}
//		
//		for(char ch:list1) {
//			if(ch!='.') return false;
//		}
//    	return true;
//    }
//    
//}