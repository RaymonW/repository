package test56;
import java.util.*;

public class Test56 {
	public static void main(String[] args) {
		Solution test = new Solution();
		List<Interval> intervals = new ArrayList<>();
		Interval itv1 = new Interval(1,3);
		Interval itv2 = new Interval(2,6);
		Interval itv3 = new Interval(5,10);
		Interval itv4 = new Interval(9,18);
		intervals.add(itv2);
		intervals.add(itv1);
		intervals.add(itv3);
		intervals.add(itv4);
		
		System.out.println(test.merge(intervals));
	}
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	intervals.sort(new IntervalStart());
        for(int i=0;i<intervals.size()-1;i++) {
        	if(intervals.get(i).end>=intervals.get(i+1).start) {
        		intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
        		intervals.remove(i+1);
        		i--;
        	}
        }
        return intervals;
    }
    
    class IntervalStart implements Comparator<Interval> {
    	public int compare(Interval i1, Interval i2) {
    		return (i1.start>i2.start?1:(i1.start==i2.start)?0:-1);//默认为升序，前面加负号为降序
    	}
    }
}



class Interval {
	int start;
 	int end;
 	Interval() { start = 0; end = 0; }
 	Interval(int s, int e) { start = s; end = e; }
}