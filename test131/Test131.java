package test131;

import java.util.*;

public class Test131 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = new String("cdd");
		System.out.println(test.partition(s));
	}
}

// ��β����ʼ�����ҵ���һ�������ַ�����Ȼ���û��ݵķ������֮ǰ�ַ����Ĳ�ֽ���������б���������β����һ���ַ����� 
// ��һ����˶�̬�滮����memo��סǰ���ֹ��ַ�����������������������
// ע�⣺���԰�memo����Ԫ��ΪList<List<String>>�����飬������������ܴ�����Ԫ�أ������Ȼ����ArrayList�����档
class Solution {  
	List<List<List<String>>> memo;
    public List<List<String>> partition(String s) {
    	memo = new ArrayList<List<List<String>>>(s.length());
    	
    	for(int i=0;i<s.length();i++) {
    		List<List<String>> temp2 = new ArrayList<List<String>>();
    		memo.add(temp2);
    	}
       return  dp(s, s.length()-1);
    }
    
    public List<List<String>> dp(String s, int r){
    	List<List<String>> ans = new ArrayList<List<String>>();
    	for(int l=r;l>=0;l--) {
    		if(!isPalindrome(s, l, r)) continue;
    		if(l==0) { //�����ǰĩβ���ַ����Ѿ���������ʼ�ˣ�ֱ���������ַ�����
    			List<String> list = new ArrayList<String>();
    			list.add(s.substring(0,r+1));
    			ans.add(list);
    		}
    		else {
    			List<List<String>> pre;
    			if(memo.get(l-1).size()==0) {
    				pre = dp(s,l-1);
    				memo.set(l-1,pre);
    			}
    			else pre = memo.get(l-1);

        		for(List<String> list:pre) {
        			List<String> newlist = new ArrayList<String>(list);
        			newlist.add(s.substring(l,r+1));
        			ans.add(newlist);
        		}
    		}
    	}
    	return ans;
    }
    
    public boolean isPalindrome(String s, int l, int r) {
        while(l<=r) {
        	if(s.charAt(l)!=s.charAt(r)) return false;
        	l++;
        	r--;
        }
        return true;
    }
}

//class Solution { //��һ��û�мӶ�̬�滮
//    public List<List<String>> partition(String s) {
//       return  dp(s, s.length()-1);
//    }
//    
//    public List<List<String>> dp(String s, int r){
//    	List<List<String>> ans = new ArrayList<List<String>>();
//    	for(int l=r;l>=0;l--) {
//    		if(!isPalindrome(s, l, r)) continue;
//    		
//    		
//    		if(l==0) {
//    			List<String> list = new ArrayList<String>();
//    			list.add(s.substring(0,r+1));
//    			ans.add(list);
//    		}
//    		else {
//    			List<List<String>> pre = dp(s,l-1);
//        		for(List<String> list:pre) {
//        			list.add(s.substring(l,r+1));
//        			ans.add(list);
//        		}
//    		}
//    	}
//    	return ans;
//    }
//    
//    public boolean isPalindrome(String s, int l, int r) {
//        while(l<=r) {
//        	if(s.charAt(l)!=s.charAt(r)) return false;
//        	l++;
//        	r--;
//        }
//        return true;
//    }
//}