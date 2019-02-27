package test17;

import java.util.*;

public class Test17 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String digits = "";
		System.out.println(test.letterCombinations(digits));
		
	}
}

class Solution { //别人的方法，backtrack，写法类似迭代
	  Map<String, String> phone = new HashMap<String, String>() {{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	  }};

	  List<String> output = new ArrayList<String>();

	  public void backtrack(String combination, String next_digits) {
	    // if there is no more digits to check
	    if (next_digits.length() == 0) {
	      // the combination is done
	      output.add(combination);
	    }
	    // if there are still digits to check
	    else {
	      // iterate over all letters which map 
	      // the next available digit
	      String digit = next_digits.substring(0, 1);
	      String letters = phone.get(digit);
	      for (int i = 0; i < letters.length(); i++) {
	        String letter = phone.get(digit).substring(i, i + 1);
	        // append the current letter to the combination
	        // and proceed to the next digits
	        backtrack(combination + letter, next_digits.substring(1));
	      }
	    }
	  }

	  public List<String> letterCombinations(String digits) {
	    if (digits.length() != 0)
	      backtrack("", digits);
	    return output;
	  }
	}
//class Solution { //我的方法
//    public List<String> letterCombinations(String digits) {
//    	List<String> ans = new ArrayList<>();
//    	if (digits.length()==0) return ans;
//    	ans.add("");
//    	
//    	Map<Character,String> map = new HashMap<>();
//    	map.put('2', "abc");map.put('3', "def");map.put('4', "ghi");
//    	map.put('5', "jkl");map.put('6', "mno");map.put('7', "pqrs");
//    	map.put('8', "tuv");map.put('9', "wxyz");
//    	
//    	List<String> temp = new ArrayList<>();
//    	for(char ch:digits.toCharArray()) {
//    		temp.add(map.get(ch));
//    	}
//    	
//    	for(String s:temp) { //按顺序将每个按键的所有可能字符依次往已经排出的结果后面加上去
//    		List<String> ans1 = new ArrayList<>(ans);
//    		for(int i=0;i<ans.size();i++) {
//        		for(int j=0; j<s.length();j++) {
//        			StringBuilder sb = new StringBuilder(ans1.get(i));
//        			ans1.add(sb.append(s.charAt(j)).toString());
//        		}
//    		}
//    		for(String former : ans) ans1.remove(former);
//    		ans = ans1;
//    	}
//       	return ans;   
//    }
//}
    