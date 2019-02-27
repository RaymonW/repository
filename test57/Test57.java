package test57;
import java.util.*;

public class Test57 {
	public static void main(String[] args) {
		Solution test = new Solution();
		List<Interval> intervals = new ArrayList<>();
		Interval itv1 = new Interval(1,2);
		Interval itv2 = new Interval(3,4);
		Interval itv3 = new Interval(5,6);
		Interval itv4 = new Interval(9,11);
		Interval itv5 = new Interval(12,16);
		Interval itv6 = new Interval(20,21);
		intervals.add(itv1);
		intervals.add(itv2);
		intervals.add(itv3);
		intervals.add(itv4);
		intervals.add(itv5);
		intervals.add(itv6);
		Interval newInterval = new Interval(0,0);
		
		System.out.println(test.insert(intervals, newInterval));
	}
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	boolean findleft = false,findright = false;
        int l=0,r=intervals.size()-1;
        int insert = -1;
        while(l<=r&&!(findleft&&findright)) {
        	if(!findleft) {
        		if(intervals.get(l).end>=newInterval.start) {
        			if(intervals.get(l).start>newInterval.end) {  //如果不是重叠而是插入
        				insert = l;
        				break;
        			}
        			else {
        				newInterval.start = Math.min(intervals.get(l).start, newInterval.start);
                		newInterval.end = Math.max(intervals.get(l).end, newInterval.end);
                		findleft = true;
        			}
            	}
            	else l++;
        	}
        		
        	if(!findright) {
        		if(intervals.get(r).start<=newInterval.end) {
        			if(intervals.get(r).end<newInterval.start) {  //如果不是重叠而是插入
        				insert = r+1;
        				break;
        			}
        			else {
        				newInterval.end = Math.max(intervals.get(r).end, newInterval.end);
                		newInterval.start = Math.min(intervals.get(r).start, newInterval.start);
                		findright = true;
        			}
            	}
            	else r--;
        	}
        		
        }
        
        if(insert>=0) intervals.add(insert,newInterval);
        else {
        	for(int i=0;i<r-l+1;i++) {
            	intervals.remove(l);
            }
            intervals.add(l, newInterval);
        }
        return intervals;
    }
}

class Interval {
	int start;
 	int end;
 	Interval() { start = 0; end = 0; }
 	Interval(int s, int e) { start = s; end = e; }
}