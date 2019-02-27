package test50;



public class Test50 {
	public static void main(String[] args) {
		Solution test = new Solution();
		double x = 2.00000;
		int n = -2147483648;
		System.out.println(test.myPow(x,n));
	}
}

class Solution {
    public double myPow(double x, int n) {
        return ( (n%2==0)?1:( (n%2==1)?x:1/x ) )*( (n%2==n)?1:myPow( x*x, n/2 ) ); //�����ɱȱ������̫���̫С
    }
}

//class Solution {
//    public double myPow(double x, int n) {
//        if(n == 0)
//            return 1;
//        if(n<0){
//            n = -n;
//            x = 1/x;
//        }
//        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);  //n/2��֤������������ֵ�߽硣
//    }
//}

//class Solution {  //�ҵķ�����û���ǵ���ֵԽ�磨�����̫��ᳬʱ��
//    public double myPow(double x, int n) {
//    	double ans = 1;
//        if(n>=0) {
//        	int i=0;
//        	while(i<n) {
//        		ans = ans*x;
//        		i++;
//        	}
//        }
//        else {
//        	int i=n;
//        	while(i<0) {
//        		ans = ans/x;
//        		i++;
//        	}
//        }
//        return ans;
//    }
//}