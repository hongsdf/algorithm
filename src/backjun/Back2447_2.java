package backjun;

import java.util.Scanner;

//  * * * * *
//  * * 0 * *
//  * 0 2 0 *
//  * * 0 * *
//  * * * * *
public class Back2447_2 {
	static char arr[][];
	static void star(int r,int c, int n ,int cas) {
		
		if(cas == 1) {
			for(int i =r; i<r+n;i++) {
				for(int j =c;j<c+n; j++) {
					arr[i][j] = '0';
				}
			}
			return;
		}
		if(cas == 2) {
			for(int i=r; i<r+n; i++) {
				for(int j =c; j<c+n; j++) {
					arr[i][j] = '2';
				}
			}
			return;
		}
		
		
		
		if(n ==1) {
			arr[r][c] = '*';
			return;
		}
		
		int BlockSize = n/5;
		int Cnt = 0;
		for(int i=r; i<r+n; i+=BlockSize) {
			for(int j =c; j<c+n; j+=BlockSize) {
				Cnt++;
				if(Cnt == 8 || Cnt ==12 || Cnt == 14 || Cnt == 18) {
					star(i,j,BlockSize,1);
				}else if(Cnt ==13) {
					star(i,j,BlockSize,2);
				}
				else {
					star(i,j,BlockSize,0);
				}
				
			}
		}
		
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		arr = new char[n][n];
		star(0,0,n,0);// 0 : *  1 : '0' 2:'2'
		
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	
	
}
