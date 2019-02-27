package test13;
import java.util.*;

public class Test13 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = new String("");
		System.out.println(test.romanToInt(s));
		
	}
}

class Solution {
    public int romanToInt(String s) {
    	if(s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);
        map.put('X', 10);map.put('L', 50);
        map.put('C', 100);map.put('D', 500);
        map.put('M', 1000);
        int i=s.length()-1;
        int ans=map.get(s.charAt(i));
        i--;
        while(i>=0) {
        	ans += map.get(s.charAt(i))>=map.get(s.charAt(i+1))? map.get(s.charAt(i)): -map.get(s.charAt(i));
        	i--;
        }
        return ans;
    }
}