package test20;
import java.util.*;

public class Test20 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s="()";	
		System.out.println(test.isValid(s));		
	}
}

class Solution {
    public boolean isValid(String s) {
    	if (s.length() == 0) return true;
    	Map<Character,Character> map = new HashMap<>();
    	map.put(')', '(');
    	map.put(']', '[');
    	map.put('}', '{');
    	String left = new String("([{");
    	String right = new String(")]}");
    	Stack<Character> stack = new Stack<>();
    	for(char ch:s.toCharArray()) {
    		if (left.contains(String.valueOf(ch))) {
    			stack.push(ch);
    		}
    		else if(right.contains(String.valueOf(ch))) {
    			if(stack.size()==0) return false;
    			if(map.get(ch)!=stack.pop()) return false;
    		}
    		else return false;
    	}
    	if (stack.size() == 0) return true;
    	else return false;
    }
}
