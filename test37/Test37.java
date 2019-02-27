package test37;
import java.util.*;


public class Test37 {
	public static void main(String[] args) {
		Solution test = new Solution();
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}

		};
		test.solveSudoku(board);
	}
}

class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private boolean dfs(char[][] board, int d) {
        if (d==81) return true; //found solution 通过改变d，改变i，j来实现全局搜索
        int i=d/9, j=d%9;
        if (board[i][j]!='.') return dfs(board,d+1);//prefill number skip
        
        boolean[] flag=new boolean[10];
        validate(board,i,j,flag);
        for (int k=1; k<=9; k++) {
            if (flag[k]) {
                board[i][j]=(char)('0'+k);
                if (dfs(board,d+1)) return true;
            }
        }
        board[i][j]='.'; //if can not solve, in the wrong path, change back to '.' and out
        return false;
    }
    private void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag,true);
        for (int k=0; k<9; k++) {
            if (board[i][k]!='.') flag[board[i][k]-'0']=false;
            if (board[k][j]!='.') flag[board[k][j]-'0']=false;
            int r=i/3*3+k/3;
            int c=j/3*3+k%3;
            if (board[r][c]!='.') flag[board[r][c]-'0']=false;
        }
    }
}

//class Solution {  //太慢了，而且返回不了结果
//	public void solveSudoku(char[][] board) {
//		boolean flag = isValidSudoku(board);
//		System.out.println(flag);
//	}
//	public boolean isValidSudoku(char[][] board) {
//    	boolean ans =false;
//        String numstr = "123456789";
//        char[][] newboard = new char[board.length][board.length];
//    	for(int i=0;i<newboard.length;i++) {
//    		for(int j=0;j<newboard.length;j++) {
//    			newboard[i][j]=board[i][j];
//    		}
//    	}
//    	for(int i=0;i<board.length;i++) {
//    		ArrayList<Character> nums = new ArrayList<>();  //数字列表
//    		for(char ch: numstr.toCharArray()) nums.add(ch); 
//    		ArrayList<Character> row = new ArrayList<>();  //初始行列表
//    		for(char ch:board[i]) row.add(ch);
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
//              				if(i==newboard.length-1&&nums.size()==1) {
//              					board = newboard;
//              					return true;
//              				}
//              				else if(isValidSudoku(newboard)) {
//              					board = newboard;
//              					return true;
//              				}
//              			}
//              			else if(nums.indexOf(ch)==nums.size()-1) {
//              				return false;  //所有数字都不行
//              			}
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
//		ArrayList<Character> list1 = new ArrayList<>(list);
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