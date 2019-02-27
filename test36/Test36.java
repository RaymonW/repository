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

class Solution {  //���˵ķ�����ע��set������,��������i��j����ֻ�Ǵ����С��У���ʱ�򻥻����壬�Ǹ�trick��
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
            int RowIndex = 3*(i/3); //��i�̶����仯j���Ա�������cube����j�̶�ʱ���仯iͬ������ȫ��������
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
}

//class Solution {  //�ҵı�����ʽ,��ʱ����Ҫ���������ҵ���ֱ���ҵ���ȷ�⣬������Ŀ����Ҫ����С�
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
//    		ArrayList<Character> nums = new ArrayList<>();  //�����б�
//    		for(char ch: numstr.toCharArray()) nums.add(ch); 
//    		ArrayList<Character> row = new ArrayList<>();  //��ʼ���б�
//    		for(char ch:newboard[i]) row.add(ch);
//    		
//    		for(int j=0;j<row.size();j++) {
//    			if(nums.contains(row.get(j))) nums.remove(row.get(j));  //��û�������
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
//              			for(int k=0;k<newboard[0].length;k++) column.add(newboard[k][j]);  //���б�
//              			ArrayList<Character> cube = new ArrayList<>();
//              			int r = i/3*3;
//              			int c = j/3*3;
//              			for(int m = 0;m<3;m++) {
//              				for(int n=0;n<3;n++) {
//              					cube.add(newboard[r+m][c+n]);  //�����б�
//              				}
//              			}
//              			if(check(row,numstr)&&check(column,numstr)&&check(cube,numstr)) {
//              				if(i==board.length-1&&nums.size()==1) return true;
//              				else if(isValidSudoku(newboard)) {
//              					return true;
//              				}
//              			}
//              			else if(nums.indexOf(ch)==nums.size()-1) return false;  //�������ֶ�����
//      				}
//      			}
//      			else continue;
//      		}
//    	}
//    	return ans;
//    }
//    
//    boolean check(ArrayList<Character> list, String numstr) {
//    	ArrayList<Character> nums = new ArrayList<>();  //�����б�
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