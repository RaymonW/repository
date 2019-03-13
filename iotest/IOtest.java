package iotest;
import java.util.*;

public class IOtest {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int m = reader.nextInt();
		int n = reader.nextInt();
		int[][] mat = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j] = reader.nextInt();
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		reader.close();
	}
}
