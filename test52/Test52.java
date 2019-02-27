package test52;
import java.util.*;

public class Test52 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 4;
		System.out.println(test.totalNQueens(n));
	}
}

class Solution {
    int tot = 0;
    public int totalNQueens(int n) {
        int[] col = new int[n];  //记录每一列上皇后所在行
        int cur = 0;
        return totalQueens(n,cur,col);
    }
    
    private int totalQueens(int n,int cur,int[] col){
        if(cur == n) tot++;  //最后一列也放置成功，方法加1。
        else{
            for(int i = 0; i < n; i++){
                boolean ok = true;
                col[cur] = i;  //在当前行放置皇后
                for(int j = 0; j < cur; j++){  //判断是否与已放置的其他列上的皇后冲突，由于一列一个，只需要判断行和对角线冲突。
                    if(col[cur] == col[j] || cur+col[cur] == j + col[j] || cur-col[cur] == j - col[j]){
                    	//第一个是行冲突，第二个是左斜线，第三个是右斜线。
                        ok = false;  //冲突就换一行放本列的皇后
                        break;
                    }
                }
                if(ok){
                    totalQueens(n,cur+1,col);  //如果不冲突就去下一列放皇后
                }
            }
        }
        return tot;
    }
}