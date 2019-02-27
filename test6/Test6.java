package test6;
import java.util.*;

public class Test6 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "ABADAFFDSFAEDFA";
		int numRows = 3;
		System.out.println(test.convert(s, numRows));
	}
}

class Solution { //别人的答案，直接顺着字符串挨个往数组里放，触底或触顶反弹。最后放到一个String里面。
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}

//class Solution { //我的答案，找到原字符位置和数组的坐标关系。
//    public String convert(String s, int numRows) {
//    	if(s.length()<=numRows||numRows==1) return s;
//        String result = new String("");
//        int maxCol=(s.length()/(2*numRows-2)+1)*(numRows-1);
//        char[][] rows = new char[numRows][maxCol];
//
//        for(int m=0;m<s.length();m++) {
//        	int i=0,j=0,mod=0;
//        	mod = m %(2*numRows-2);
//        	if(mod<numRows) i=mod;
//        	else i = 2*numRows-2-mod;
//        	j = (m - i)/2;
//        	rows[i][j]=s.charAt(m);
//        }
//        StringBuffer strBuffer = new StringBuffer(result);
//        for(int i=0;i<numRows;i++) {
//        	for(int j=0;j<maxCol;j++) {
//        		if(rows[i][j]!='\0') {
//        			strBuffer.append(rows[i][j]);
//        		}     		
//        	}    	
//        }
//        result = strBuffer.toString();
//    	return result;
//    }
//}