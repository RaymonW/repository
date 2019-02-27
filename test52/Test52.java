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
        int[] col = new int[n];  //��¼ÿһ���ϻʺ�������
        int cur = 0;
        return totalQueens(n,cur,col);
    }
    
    private int totalQueens(int n,int cur,int[] col){
        if(cur == n) tot++;  //���һ��Ҳ���óɹ���������1��
        else{
            for(int i = 0; i < n; i++){
                boolean ok = true;
                col[cur] = i;  //�ڵ�ǰ�з��ûʺ�
                for(int j = 0; j < cur; j++){  //�ж��Ƿ����ѷ��õ��������ϵĻʺ��ͻ������һ��һ����ֻ��Ҫ�ж��кͶԽ��߳�ͻ��
                    if(col[cur] == col[j] || cur+col[cur] == j + col[j] || cur-col[cur] == j - col[j]){
                    	//��һ�����г�ͻ���ڶ�������б�ߣ�����������б�ߡ�
                        ok = false;  //��ͻ�ͻ�һ�зű��еĻʺ�
                        break;
                    }
                }
                if(ok){
                    totalQueens(n,cur+1,col);  //�������ͻ��ȥ��һ�зŻʺ�
                }
            }
        }
        return tot;
    }
}