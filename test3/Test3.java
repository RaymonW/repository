package test3;
import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		Solution3 test = new Solution3();
		String s = "ddaafdaa";
		System.out.println(test.lengthOfLongestSubstring(s));
		
	}

}
class Solution3 { //���˵Ĵ�
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
//class Solution3 { //�Լ��Ĵ�
//    public int lengthOfLongestSubstring(String s) {
//    	int window = 0;  //��ǰ���ڳ���
//    	int l_window = 0;  //��С���ڳ���
//    	int u_window = s.length();  //��󴰿ڳ���
//    	int end_window = 0;
//    	int head = 0;  //����ͷ��
//    	int start = 0;  //������С�������
//    	int flag = 0;  //��ֹ��־
//        while(u_window!=l_window) {
//        	if(head>s.length()-window) {
//        		break;
//        	}
//        	for(head=start;head<=s.length()-window;head++) {
//        		String sstr = new String(s.substring(head,head+window));
//        		int flag_repeat=0;
//        		for(char e:sstr.toCharArray()) {
//        			if (sstr.indexOf(e)!=sstr.lastIndexOf(e)) {
//        				flag_repeat=1;
//        				break;
//        			}
//        		}
//        		if (flag_repeat==0) {
//        			end_window = window;
//        			l_window = window;
//        			window++; 
//        			start = head;
//        			break;	
//        		}
//        		else if(head==s.length()-window){
//        			window--;
//        			u_window = window;
//        			break;
//        		}
//        	}
//        }
//    	return end_window;
//    }
//}
