package test58;



public class Test58 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String s = "a ";
		System.out.println(test.lengthOfLastWord(s));
	}
}

class Solution {
    public int lengthOfLastWord(String s) {
    	if(s.length()==0) return 0;
        char[] ca = s.toCharArray();
        int first = -1;
        int l=-1,r=-1;
        for(int i=s.length()-1;i>=0;i--) {
        	if(first<0&&ca[i]!=' ') {
        		first = 1;
        		r = i;
        	}
        	if(first>0&&ca[i]==' ') {
        		l = i;
        		break;
        	}
        }
        return r-l;
    }
}
