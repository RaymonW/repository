package test76;
import java.util.*;

public class Test76 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.print(test.minWindow(s,t));
	}
}

class Solution{  //�ҵĸ��ֻ����������ƺ�������contains�������жϣ�����ʱ�ˡ����˵ķ�������map��¼ÿ���ַ����ֵ�����
	//ֻ��Ҫ�Ƚϳ��������Ƿ���Ⱦ����ˡ�����ÿ���ƶ���ʱ�����һ�μӼ������ͱȽϾ����ˡ�
	public String minWindow(String s, String t) {
		if(t.length()==0) return "";
		int l = 0,r = 1;
		int min = -1;
		int[] ans = {-1,-1};
		while(r<=s.length()) {
			if(contains(s.substring(l,r), t)) {
				if(min<0||r-l<min) {
					ans[0] = l;
					ans[1] = r;
					min = r-l;
				}
			}
			while(contains(s.substring(l,r),t)&&l<r) {
				if(r-l<min) {
					ans[0] = l;
					ans[1] = r;
					min = r-l;
				}
				l++;
			}
			r++;
		}
		if(min<0) return "";
		else return s.substring(ans[0],ans[1]);
	}
	
	public boolean contains(String s1,String s2) {
		List<Character> list = new ArrayList<>();
		for(char ch:s1.toCharArray()) list.add(ch);
		for(char ch:s2.toCharArray()) {
			if(list.contains(ch)) list.remove(list.indexOf(ch));
			else return false;
		}
		return true;
	}
}

//class Solution { //���˵ķ������������ڣ��Ȼ��ұ�ֱ������t��Ȼ�����ֱ��������t���ٻ��ұ�������ˡ�
//	  public String minWindow(String s, String t) {
//
//	      if (s.length() == 0 || t.length() == 0) {
//	          return "";
//	      }
//
//	      // Dictionary which keeps a count of all the unique characters in t.
//	      Map<Character, Integer> dictT = new HashMap<Character, Integer>();
//	      for (int i = 0; i < t.length(); i++) {
//	          int count = dictT.getOrDefault(t.charAt(i), 0);
//	          dictT.put(t.charAt(i), count + 1);
//	      }
//
//	      // Number of unique characters in t, which need to be present in the desired window.
//	      int required = dictT.size();
//
//	      // Left and Right pointer
//	      int l = 0, r = 0;
//
//	      // formed is used to keep track of how many unique characters in t
//	      // are present in the current window in its desired frequency.
//	      // e.g. if t is "AABC" then the window must have two A's, one B and one C.
//	      // Thus formed would be = 3 when all these conditions are met.
//	      int formed = 0;
//
//	      // Dictionary which keeps a count of all the unique characters in the current window.
//	      Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
//
//	      // ans list of the form (window length, left, right)
//	      int[] ans = {-1, 0, 0};
//
//	      while (r < s.length()) {
//	          // Add one character from the right to the window
//	          char c = s.charAt(r);
//	          int count = windowCounts.getOrDefault(c, 0);
//	          windowCounts.put(c, count + 1);
//
//	          // If the frequency of the current character added equals to the
//	          // desired count in t then increment the formed count by 1.
//	          if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
//	              formed++;
//	          }
//
//	          // Try and contract the window till the point where it ceases to be 'desirable'.
//	          while (l <= r && formed == required) {
//	              c = s.charAt(l);
//	              // Save the smallest window until now.
//	              if (ans[0] == -1 || r - l + 1 < ans[0]) {
//	                  ans[0] = r - l + 1;
//	                  ans[1] = l;
//	                  ans[2] = r;
//	              }
//
//	              // The character at the position pointed by the
//	              // `Left` pointer is no longer a part of the window.
//	              windowCounts.put(c, windowCounts.get(c) - 1);
//	              if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
//	                  formed--;
//	              }
//
//	              // Move the left pointer ahead, this would help to look for a new window.
//	              l++;
//	          }
//
//	          // Keep expanding the window once we are done contracting.
//	          r++;   
//	      }
//
//	      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//	  }
//	}

//class Solution {  //������tû���ظ���ĸʱ��дTreeMap�õ�����������TreeMap��ֵ����ʲô�Ļ���ѧ���˺ܶ�
//    public String minWindow(String s, String t) {
//    	if(t.length()==0) return s;
//    	if(s.length()<t.length()) return "";
//    	
//    	TreeMap<String,Integer> map = new TreeMap<>();
//    	TreeMap<Integer,Integer[]> ansmap = new TreeMap<>();
//    	
//    	for(int i = 0;i<s.length();i++) {
//    		if(t.contains(s.substring(i,i+1))) {
//    			map.put(s.substring(i,i+1),i);
//    			if(map.size()==t.length()) {
//    				//��mapת��Ϊlist����value����
//    				LinkedList<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
//    				Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
//    					public int compare(Map.Entry<String,Integer> en1,Map.Entry<String,Integer> en2) {
//    						return en1.getValue().compareTo(en2.getValue());
//    					}
//    				});
//    				//�õ�������ĸ������
//    				int l = list.getFirst().getValue();
//    				int r = list.getLast().getValue();
//    				int len = r-l+1;
//    				if(ansmap.keySet().contains(len)) {
//    					Integer[] temp = {1,l,r};
//    					ansmap.put(len,temp);
//    				}
//    				else {
//    					Integer[] temp = {0,l,r};
//    					ansmap.put(len,temp);
//    				}
//    			}
//    		}
//    	}
//    	
//    	for(Map.Entry<Integer,Integer[]> en:ansmap.entrySet()) {
//			if(en.getValue()[0]==0) {
//				int l = en.getValue()[1];
//				int r = en.getValue()[2];
//				return s.substring(l,r+1);
//			}
//		}
//		return "";
//    }
//}

//class Solution {  //������ʱ������hard�⻹��Ҫ���ȿ���һ���㷨���Ӷ�
//    public String minWindow(String s, String t) {
//        
//        if(t.length()==0) return s;
//        int window = t.length();
//        if(s.length()<window) return "";
//        
//        String ans = "";
//        ArrayList<String> strs = new ArrayList<>();
//        while(window<=s.length()) {
//        	for(int i=0;i+window<=s.length();i++) {
//        		boolean flag = true;
//            	ArrayList<Character> list = new ArrayList<>();
//            	for(char ch:s.substring(i,i+window).toCharArray()) list.add(ch);
//            	for(char ch:t.toCharArray()) {
//            		if (list.contains(ch)) list.remove(list.indexOf(ch));
//            		else {
//            			flag = false;
//            			break;
//            		}
//            	}
//            	if(flag) strs.add(s.substring(i,i+window));
//            }
//        	if(strs.size()==1) return strs.get(0);
//        	else window++;
//        }
//        return ans;
//    }
//}