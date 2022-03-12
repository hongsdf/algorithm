package algorithm;

import java.util.Scanner;

public class RGB2 {
	static int arr[][] = new int[10][5];
	static int ans[][] = new int[10][5];
	
	static final int A = 1;
	static final int B = 2;
	static final int C = 3;
	static final int D = 4;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				arr[i][j] = sc.nextInt(); // 4 * 4 matrix
			}
		}
		// 초기화 중요
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				ans[i][j] = 0;
			}
		}
		/*
		ans
		4 (최고값을 구하는 문제) DP
		1  1  1  1
		1  1  1  1
		1  1  1  1
		1  1  1  1
		
		 
		 
		 */
		ans[1][A] = arr[1][A]; //ans[1][A] = arr([B] + [C] + [D]) 
		ans[1][B] = arr[1][B];
		ans[1][C] = arr[1][C];
		ans[1][D] = arr[1][D];
		
		
		// ----------------
		
		for(int i = 2; i<=n; i++) {
			for(int j = A; j<=D; j++) {
				for(int k = A; k<=D; k++) { //같은 행 방지
					if( j !=k) {
						ans[i][j] = max(ans[i][j],arr[i][j] + ans[i-1][k]);
					}
				}
			}
		}
		System.out.println(MAX(ans[n][A],ans[n][B],ans[n][C],ans[n][D]));
		
		
		/*
		(최고값을 구하는 문제) DP
		4
		0 0 10 0
		0 0 0 20
		0 30 0 0
		0 0 0 50
		100 + 40 + 70 + 20 = 230
		*/
	}


	 static int MAX(int i, int j, int k, int l) {
		if(i >= j && i>= k && i>=l) return i;
		else if (j >= i && j>= k && j>=l) return j;
		else if (k >= i && k >= j && k >=l) return k;
		else return l;
		
	}


	 static int max(int i, int j) {
		if( i > j) return i;
		else return j;
	}
}
