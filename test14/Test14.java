package test14;


public class Test14 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String[] strs = {"flefiower","flfiowe","flifiowerght"};
		System.out.println(test.longestCommonPrefix(strs));
		
	}
}

class Solution {  //最长前缀
	public String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
}

//class Solution {  //最长相同字符串
//    public String longestCommonPrefix(String[] strs) {
//        String ans = new String("");
//        if(strs.length==0) return ans;
//        int r=0;
//        boolean end_flag = false;
//        StringBuilder commonStr = new StringBuilder();
//        
//        while(r<strs[0].length() && end_flag==false) {
//        	commonStr.append(strs[0].charAt(r));
//            for(String s : strs) {
//            	if(!s.contains(commonStr)) {
//            		if (commonStr.length()!=1) {
//            			commonStr.delete(0, commonStr.length());
//            			strs[0]= strs[0].substring(r,strs[0].length());
//            			r=-1;
//            		}
//            		else {
//            			commonStr.delete(0, commonStr.length());
//            			strs[0]= strs[0].substring(r+1,strs[0].length());
//            			r=-1;
//            		}
//            		break;
//            	}
//            	if(commonStr.length()>s.length()) end_flag = true;
//            }
//            if(ans.length()<commonStr.length()) ans = commonStr.toString();
//            r++;
//        }
//        return ans;
//    }
//}