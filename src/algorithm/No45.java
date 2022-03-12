package algorithm;

import java.util.Scanner;

public class No45 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int DP[][] = new int[1000][1000];
		for(int i =1; i <= n; i++) {
			for(int j = 1; j<= m; j++) {
				int num = sc.nextInt();
				DP[i][j] = DP[i-1][j] + DP[i][j-1] + num - DP[i-1][j-1];
			}
		}
		int cnt = sc.nextInt();
		for(int i = 1; i<=cnt; i++) {
		
				int x = sc.nextInt();
				int y = sc.nextInt();
				int w = sc.nextInt();
				int z = sc.nextInt();
				DP[x][y] = DP[x][y] - DP[w-1][y] - DP[x][z-1] + DP[w-1][z-1] ; 
				System.out.println(DP[x][y]);
			}
		
		
	}
}
