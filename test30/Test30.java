package test30;
import java.util.*;

public class Test30 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "aaaaaaaa";
		String[] words = {"aa","aa","aa"};
		System.out.println(test.findSubstring(s, words));
	}
}

class Solution{ //代码简洁了，但仍然很慢
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> ans = new ArrayList<>();
		if(s.length()==0||words.length==0||words[0]=="") return ans;
		
		int lenWord = words[0].length();
		for(int i=0;i<=s.length()-lenWord*words.length;i++) {
			List<String> wordsList = new ArrayList<>();
			for(String word:words) wordsList.add(word);
			int j = i;
			while(wordsList.contains(s.substring(j,j+lenWord))) {
				wordsList.remove(s.substring(j,j+lenWord));
				j += lenWord;
				if(j>s.length()-lenWord) break;
			}
			if(wordsList.size()==0) ans.add(i);

		}
		return ans;
	}
}

//class Solution {  //我的方法，超级慢，占用空间大
//	List<Integer> ans = new ArrayList<>();
//	
//    public List<Integer> findSubstring(String s, String[] words) {
//    	if(s.length()==0||words.length==0||words[0]=="") return ans;
//    	int len = s.length();
//    	search(len,s,words);
//    	return ans;
//    }
//    
//    void search(int len, String s, String[] words) {
//    	List<String> wordsList = new ArrayList<>();
//    	List<String> wordsList1 = new ArrayList<>();
//
//    	for(String word:words) {
//    		wordsList.add(word);
//    		wordsList1.add(word);
//    	}
//    	int lenWord = wordsList.get(0).length();
//    	int head = 0;
//    	
//    	int i=0,j=i+lenWord;
//    	for(i=0;i<=s.length()-wordsList.size()*lenWord;i++) {
//    		j=i+lenWord;
//    		if(wordsList1.contains(s.substring(i,j))) {
//    			wordsList1.remove(s.substring(i,j));
//    			head = i;
//    			break;
//    		}
//    	}
//    	if(i <= s.length()-wordsList.size()*lenWord) {
//    		i=i+lenWord;
//    		while(wordsList1.size()!=0) {
//    			j=i+lenWord;
//        		if(wordsList1.contains(s.substring(i,j))) {
//        			wordsList1.remove(s.substring(i,j));
//        			i=i+lenWord;
//        		}
//        		else {
//        			search(len,s.substring(head+1),words);
//        			break;
//        		}
//        	}
//    		if(wordsList1.size()==0) {
//    			ans.add(head+len-s.length());
//    			
//    			if(head+wordsList.size()*lenWord<s.length()) {
//    				search(len,s.substring(head+1),words);
//    			}
//    		}
//    	}
//    	
//    }
//}