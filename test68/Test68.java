package test68;
import java.util.*;

public class Test68 {
	public static void main(String[] args) {
		Solution test = new Solution();
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//		String[] words = {"What","must","be","acknowledgment","shall","be"};
//		String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
//		         "to","a","computer.","Art","is","everything","else","we","do"};
		String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
		int maxWidth = 16;
		System.out.println(test.fullJustify(words,maxWidth));
	}
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
        	int len = words[i].length()+1;
        	int j = i;
        	String str = "";
        	while(len<maxWidth&&j+1<words.length) {
        		j++;
        		len += words[j].length()+1;
        	}
        	if(len>maxWidth+1) {
        		len -= (words[j].length()+1);
        		j--;
        	}
        	
        	int space = maxWidth+1 - len;
        	int ave = j==i?space/(j-i+1):space/(j-i);
            int mod = j==i?space%(j-i+1):space%(j-i);

            for(int k=i;k<=j;k++) {
            	String temp = words[k];
            	if(j==words.length-1||j==i) {  		
            		if(k==j) for(int n=0;n<space;n++) temp += " ";
            		else temp = temp + " ";
            	}
            	else {
            		if(k<i+mod) {
                		temp = temp + " ";
                		for(int n=0;n<ave+1;n++)  temp +=" ";
                	}
            		else if(k<j) {
            			temp = temp + " ";
                		for(int n=0;n<ave;n++)  temp +=" ";
            		}        	
            	}
            	str += temp;
            }
           
        	i = j;	
        	ans.add(str);
        }
        return ans;
    }
}

//class Solution {
//    public List<String> fullJustify(String[] words, int maxWidth) {
//    	List<String> ans = new ArrayList<>();
//        for(int i=0;i<words.length;i++) {
//        	int len = 0;
//        	int j = i;
//        	String str = "";
//        	while(len<maxWidth+1&&j<words.length) {
//        		len += words[j].length()+1;
//        		j++;
//        	}
//        	if(len>maxWidth+1) {
//        		len -= (words[--j].length()+1);
//        		j--;
//        	}
//        	if(j == words.length) j--;
//        	
//        	int space = (j==words.length-1||j==i)?(maxWidth-len):(maxWidth+1 - len);
//
//        	int ave = (j==words.length-1||j==i)?space/(j-i+1):space/(j-i);
//            int mod = (j==words.length-1||j==i)?space%(j-i+1):space%(j-i);
//
//        	for(int k=i;k<i+mod;k++) {
//        		String temp = words[k]+" ";
//        		for(int n=0;n<ave+1;n++)  temp +=" ";
//        		str += temp;
//        	}
//        	for(int k=i+mod;k<((j==words.length-1||j==i)?j+1:j);k++) {
//        		String temp = words[k]+" ";
//        		for(int n=0;n<ave;n++)  temp +=" ";
//        		str += temp;
//        	}
//        	if(j!=words.length-1) str += words[j];
//        	i = j;	
//        	ans.add(str);
//        }
//        return ans;
//    }
//}