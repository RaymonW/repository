package test49;
import java.util.*;

public class Test49 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(test.groupAnagrams(strs));
	}
}

class Solution { //别人的方法，字符串排序后方便对比，且用map保存同类字符串，方便比较
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

//我的方法 每次都要比较，浪费时间
//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//    	List<List<String>> ans = new ArrayList<>();
//    	for(String str:strs) {
//    		if(ans.size()==0) {
//    			List<String> list = new ArrayList<>();
//    			list.add(str);
//    			ans.add(list);
//    		}
//    		else {
//    			boolean flag = false;
//    			for(List<String> lst:ans) {
//    				String head = lst.get(0);
//    				if(compare(head,str))  {
//    					lst.add(str);
//    					flag = true;
//    				}
//    			}
//    			if(!flag) {
//    				List<String> list = new ArrayList<>();
//        			list.add(str);
//        			ans.add(list);
//    			}
//    		}
//    	}
//    	return ans;
//    }
//    
//    boolean compare(String str1,String str2) {
//// 另一种比较方法，比较慢
////    	char[] ca1 = str1.toCharArray();
////    	char[] ca2 = str2.toCharArray();
////    	Arrays.sort(ca1);
////    	Arrays.sort(ca2);
////    	if(String.valueOf(ca1).equals(String.valueOf(ca2))) return true;
////    	else return false;
//    	if(str1.length()!=str2.length()) return false;
//    	else {
//    		List<Character> list = new ArrayList<>();
//    		for(char ch:str2.toCharArray()) list.add(ch);
//    		for(char ch:str1.toCharArray()) {
//    			if(list.contains(ch)) list.remove(list.indexOf(ch));
//    			else return false;
//    		}
//    		if(list.size()==0) return true;
//    		else return false;
//    	}
//    }
//}