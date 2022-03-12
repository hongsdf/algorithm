package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Back1018 {
	/*
	 10 13
	BBBBBBBWBWBW      BBBBBBBW
	BBBBBBBBBWBWB     BBBBBBBB
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	WWWWWWWWWWBWB
	WWWWWWWWWWBWB
	 */
	static int board(char[][] c) {
		int cnt = 0;
//		int row = c.length-8; // 2
		
				
		for(int row = 0; row<c.length; row++) {
			
			for(int r = row; r<8+row; r++) { // r :3  r<10
				for(int c1 = row; c1<8+row; c1++) {
					if(r >6 || c1 >6) continue;
					
					if(c[r][c1] == c[r+1][c1]) {
						cnt++;
						if(c[r][c1] == 'B') {
							c[r+1][c1] ='W';
						}else {
							c[r+1][c1] = 'B';
						}
					}
					if(c[r][c1] == c[r][c1+1]) {
						cnt++;
						if(c[r][c1] == 'B') {
							c[r][c1+1] ='W';
						}else {
							c[r][c1+1] = 'B';
						}
					}
					
					
				}
			}
		}
		
				
		
		
		return cnt;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
		
		
		char c[][] = new char[n][m];
		for(int i=0; i<n;i++) {
			char row[] = br.readLine().toCharArray(); 
			for(int j =0; j<m; j++) {
				c[i][j] =  row[j];
			}
		}
		
		
//		for(int i=0; i<n;i++) {
//			for(int j =0; j<m; j++) {
//				System.out.print(c[i][j]);
//			}
//			System.out.println();
//		}
		
		 int ans = board(c);
		 System.out.println(ans);
		
		
		
	}
	

}
