package test71;
import java.io.*;
import java.util.*;

public class Test71 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String str = "/a//b////c/d//././/..";
		System.out.println(test.simplifyPath(str));
	}
}

class Solution {
    public String simplifyPath(String path) {
    	LinkedList<String> list = new LinkedList<>();
    	int l=0,r=0;
    	boolean flag_l = false, flag_r = false;
    	for(int i=0;i<path.length();i++) {
    		if(!flag_l && !path.substring(i,i+1).equals("/")) {
    			l = i;
    			flag_l = true;
    		}
    		if(flag_l&&!flag_r&&path.substring(i,i+1).equals("/")) {
    			r = i;
    			flag_r = true;
    		}
    		if(flag_l&&flag_r) {
    			String str = path.substring(l,r);
    			if(str.equals("..")) list.pollLast();
    			else if(!str.equals(".")) list.add(path.substring(l,r));
    			flag_l = false;
    			flag_r = false;
    		}
    		else if(flag_l&&i==path.length()-1) {
    			String str = path.substring(l,path.length());
    			if(str.equals("..")) list.pollLast();
    			else if(!str.equals(".")) list.add(path.substring(l,path.length()));
    		}
    	}
    	
    	StringBuffer sb = new StringBuffer("/");
    	while(!list.isEmpty()) {
    		sb.append(list.remove(0));
    		if(!list.isEmpty()) sb.append("/");
    	}
    	return sb.toString();	
    }
}
