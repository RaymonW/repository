package testonline;
import java.util.*;
//public class Main{
//	public static void main(String[] args) {
//		Scanner reader = new Scanner(System.in);
//		while(reader.hasNext()) {
//			int m = reader.nextInt();
//			int n = reader.nextInt();
//		}
//	}
//}

//public class TestOnline { //触宝第二题
//	public static void main(String[] args) {
//		Scanner reader = new Scanner(System.in);
//		while(reader.hasNext()) {
//			int typenum = reader.nextInt();
//			int leastneed = reader.nextInt();
////			System.out.println(typenum + " " + leastneed);
//			TreeMap<Integer, Integer> carrotsMap = new TreeMap<Integer, Integer>();
//			for(int i=0;i<typenum;i++) {
//				int temp1 = reader.nextInt();
//				int temp2 = reader.nextInt();
////				System.out.println(temp1 + " " + temp2);
//				carrotsMap.put(temp1, temp2);
//			}
//			NavigableMap<Integer,Integer> NaviMap = carrotsMap.descendingMap();
//			System.out.println(servive(NaviMap, leastneed));
//		}
//		reader.close();
//		
//		
////		int typenum = 3;
////		int leastneed = 205;
////		int[][] nums = {
////				{2,1000},
////				{4,1600},
////				{8,1804}
////				};
////		TreeMap<Integer, Integer> carrotsMap = new TreeMap<Integer, Integer>();
////		for(int i=0;i<typenum;i++) {
////			carrotsMap.put(nums[i][0],nums[i][1]);
////		}
////		NavigableMap<Integer,Integer> NaviMap = carrotsMap.descendingMap();
////		System.out.println(servive(NaviMap, leastneed));
//		
//
//	}
//	
//	public static int servive(NavigableMap<Integer, Integer> carrotsMap, int leastneed) {
//		int days = 0;
//		int eaten = 0;
//		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>();
//		for(Map.Entry<Integer, Integer> entry:carrotsMap.entrySet()) list.add(entry);
//		while (!list.isEmpty()) { //还有萝卜
//			for(int i=0;i<list.size();i++) {
//				Map.Entry<Integer, Integer> entry = list.get(i);
//				int key = entry.getKey();  //萝卜大小
//				int value = entry.getValue();  //数量
//				if(key>=leastneed) { // 先吃大于需求的萝卜
//					days += value;
//					list.remove(entry);
//					i--;
//				}
//				else { //然后从大到小依次吃饱萝卜，如果再吃就吃多了就换小一级的萝卜。
//					int times = (leastneed-eaten)/key;
//					if(i==list.size()-1&&times==0) {
//						eaten += key;
//						value --;
//					}
//					else {
//						eaten += Math.min(times, value)*key;
//						value = Math.max(value-times, 0);
//					}
//					if(value==0) {
//						if(list.size()!=1) list.remove(entry);
//						else list.clear();
//					}
//					else entry.setValue(value);
//					if(eaten>=leastneed) {
//						days++;
//						eaten=0;
//					}
//				}
//			}
//		}
//		return days;
//	}
//}


//public class TestOnline {  //触宝第一题
//	public static void main(String[] args) {
////		Scanner reader = new Scanner(System.in);
////		while(reader.hasNext()) {
////			int n = reader.nextInt();
////			int[][] mat = new double[n][4];
////			for(int i=0;i<n;i++) {
////				for(int j=0;j<4;j++)
////					mat[i][j] = reader.nextInt();
////			}
////			
////			double[] ans = findSpecial(mat);
////			double t = ans[0];
////			double dis = ans[1];
////
////			System.out.print(String.format("%.2f", t)+" "+String.format("%.2f", dis));
////			System.out.println();
////		}
////		reader.close();
//		int[][] mat = {
////				{0,0,1,0},
////				{2,0,-1,0},
//				{27, 27, 0, 2},
//				{58, 88, -8, -1},
//				{-22, 7, 1, -1},
//				{-38, -26, 5, 9}
//		};
//		double[] ans = findSpecial(mat);
//		double t = ans[0];
//		double dis = ans[1];
//
//		System.out.print(String.format("%.2f", t)+" "+String.format("%.2f", dis));
//		System.out.println();
//	}
//	
//	public static double[] findSpecial(int[][] mat) {
//		double[] ans = {0.00,20000.00};	
//		double t = -0.01;
//		while(true) {
//			double maxdis = 0;
//			double[] maxans = ans.clone();
//			
//			for(int i=0;i<mat.length;i++) {
//				for(int j=i+1;j<mat.length;j++) {
//					double xi = mat[i][0];
//					double yi = mat[i][1];
//					double xj = mat[j][0];
//					double yj = mat[j][1];
//					double vxi = mat[i][2];
//					double vyi = mat[i][3];
//					double vxj = mat[j][2];
//					double vyj = mat[j][3];
//					t+=0.01;
//					t = Math.round(t*100)/100.00;
//					xi +=t*vxi;
//					yi +=t*vyi;
//					xj +=t*vxj;
//					yj +=t*vyj;
//					xi = Math.round(xi*100)/100.00;
//					yi = Math.round(yi*100)/100.00;
//					xj = Math.round(xj*100)/100.00;
//					yj = Math.round(yj*100)/100.00;
//					double dis = Math.sqrt((xi-xj)*(xi-xj)+(yi-yj)*(yi-yj));
//					if(dis>maxdis) {
//						maxdis = dis;
//						maxans[0] = t;
//						maxans[1] = dis;
//					}	
//				}
//			}
//			if(maxans[1]>=ans[1]) break;
//			else {
//				ans = maxans.clone();
//			}
//		}
//		return ans;
//	}
//}
