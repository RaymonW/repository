package test22;
import java.util.*;

public class Test22 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 3;
		System.out.println(test.generateParenthesis(n));		
	}
}

class Solution {  //���˵�backtrack,�����
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {  
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max); //���б仯���ں����������棬�Ͳ�������ظ������ͬ����������
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}

//class Solution {  //�ҵķ�����backtrack�ķ���
//	List<String> ans = new ArrayList<>();
//	
//    public List<String> generateParenthesis(int n) {
//    	sub(n,0,n,n,"");
//    	return ans;
//    }
//    
//    void sub(int n,int sum,int add,int minus,String s) {
//    	boolean flag = false;
//    	if(minus>0 && sum-1>=0) {
//    		s = s + ")";
//			minus -=1;
//			sum -=1;
//			flag = true;
//			if (s.length() == 2*n) ans.add(s);
//			sub(n,sum,add,minus,s);
//    	}
//    	if(add>0) {
//    		if(flag) {
//    			s=s.substring(0,s.length()-1);
//    			minus +=1;
//    			sum +=1;
//    		}
//    		s = s + "(";
//    		add -=1;
//    		sum +=1;
//    		if (s.length() == 2*n) ans.add(s);
//    		sub(n,sum,add,minus,s);
//    	}	
//    }  
//}