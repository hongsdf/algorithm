package backjun;

import java.util.Scanner;
public class Back2775 {
public static void main(String[] args) {
		// 1Ãþ 3È£ => 0Ãþ 1È£ 2È£ 3È£ 1+2+3
		// 2Ãþ 3È£ => 1Ãþ 1È£(1) 2È£(3) 3È£(6) = 10 
		Scanner sc = new Scanner(System.in);

		int a[][] = new int[15][15];
		for(int i = 0; i < 15;i++) {
			a[i][1] = 1;
			a[0][i] = i;
		}
		
		for(int i = 1; i<15; i++) { // 1Ãþ 2È£ ºÎÅÍ 14Ãþ 14È£±îÁö Ã¤¿ö³Ö±â
			for(int j = 2; j <15; j++) {
				a[i][j] = a[i-1][j] + a[i][j-1];
			 // a[1][2] = a[0][2] + a[1][1]
			 // a[2][3] = a[1][3] + a[2][2];
			 // a[4][5] = a[3][5] + a[4][4]; // (126 = 70 + 56)
			}
		}
		int c = sc.nextInt();
		
		for(int i = 0; i<c; i++) {
			int n = sc.nextInt(); // Ãþ¼ö
			int m = sc.nextInt(); // È£
			System.out.println(a[n][m]);	
		}
			
			
		
		
	
	
		
		//  2Ãþ 1È£ 2Ãþ 2È£ 2Ãþ 3È£
		//  1Ãþ 1È£ 1Ãþ 2È£ 1Ãþ 3È£
		//  0Ãþ 1È£ 0Ãþ 2È£ 0Ãþ 3È£
		
		
		
		
	}

}
