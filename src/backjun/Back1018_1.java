package backjun;

import java.util.Scanner;

public class Back1018_1 {
	
	static char arr[][];
	static int min = 64;
	
	public static int find(int x, int y) {
		int cnt =0;
		int row = x+8;
		int col = y+8;
		// 여기 구현 필요
		
		
		
		
		
		
		cnt = Math.min(cnt, 64-cnt ) ;
		
		min = Math.min(min, cnt);
		
		return min;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		
		arr = new char[n][m];
		
		
		for(int i =0; i <n; i++) {
			String s = sc.next();
			for(int j =0; j<m; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
//		
//		for(int i =0; i <n; i++) {
//			
//			for(int j =0; j<m; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		
		
		int row_size = n - 7; //10 - 3
		int col_size = m - 7; //13
		
		for(int i =0; i <row_size; i++) {
			for(int j =0; j <col_size; j++) {
				find(i,j);
			}
		}
		System.out.println(min);
		
	
		
		
		
	}
	

}
