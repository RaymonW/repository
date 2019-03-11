package test72;
import java.util.*;

public class Test72 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String word1 = "industry";
		String word2 = "interest";
		System.out.print(test.minDistance(word1,word2));
	}
}

class Solution { //别人的法一，DP，每次用三种方法去试，取最小的那种。
	int[][] memo;
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        memo = new int [word1.length()][word2.length()];
        for(int[] array:memo) Arrays.fill(array,-1);
        return match(word1, word2, 0, 0);
    }
    
    private int match(String s1, String s2, int i, int j) {
        //If one of the string's pointer have reached the end of it
        if (s1.length() == i) {
            return s2.length() - j;
        }
        if (s2.length() == j) {
            return s1.length() - i;
        }
        
        if(memo[i][j]!=-1) return memo[i][j];
        
        int res;
        if (s1.charAt(i) == s2.charAt(j)) {
            res = memo[i][j] = match(s1, s2, i + 1, j + 1);
        } else {
            //Case1: insert
            int insert = match(s1, s2, i, j + 1);
            //Case2: delete
            int delete = match(s1, s2, i + 1, j);
            //Case3: replace
            int replace = match(s1, s2, i + 1, j + 1);
            res = Math.min(Math.min(insert, delete), replace) + 1;  //执行了一种操作，所以+1
        }
        
        return memo[i][j] = res;
    }
}  
