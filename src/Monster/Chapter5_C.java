package Monster;

import java.util.Scanner;

//2 1 4 5 1 3 3
public class Chapter5_C {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int arr[] = new int[n];
//		int board[][] = new int[10][10];
//		for(int i = 0; i<n; i++) {
//			arr[i] = sc.nextInt();
//			
//		}
//		int max = Integer.MIN_VALUE;
//		// board 채우기
//		for(int i = 0; i<n; i++) {
//			for(int j = n-1; j >= n - arr[i]; j--) {
//				board[j][i] = 1;
//			}
//		}
//		int maxArea = 0;
//		// 최대 넓이 찾기
//		for(int i = n-1; i>=0; i-=1) {
//			int height = 0;
//			int count = 0;
//			for(int j = 0; j<n; j++) {
//				if(board[i][j] == 1) {
//					count++;
//				}else {
//					count = 0;
//				}
//			 height = Math.max(count, height);
//			}
//			// 높이별 최대 크기
//			int size = height * (n - i);
//			System.out.println(n-i+"높이 최대면적 :="+size);
//			maxArea = Math.max(maxArea, size);
//		}
//		System.out.println(maxArea );
//		
//	
		
		// Native
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// board 채우기
//		int size = 8;
		int arr[] = new int[N];
		int board[][] = new int[1000][1000];
		for(int k = 0; k<N; k+=1) {
			arr[k] = sc.nextInt();
		}
		for(int i = 0; i<N; i+=1) {
			for(int j = arr[i]; j > 0; j-=1) {
				board[1000-j][i] = 1;
			}
		}
		
		
		// 최대 면적 찾기
		int max = Integer.MIN_VALUE;
		for(int i = 1000-1; i>= 0; i--) {
			int count = 0;
			int area = 0; // 범위증가
			for(int j = 0; j < N; j+=1) {
				if(board[i][j] == 1) {
					area += 1;
				}else {
					area = 0;
				}
				count = Math.max(count, area);

			}
			int AreaSize = count * (1000 - i );
			max = Math.max(AreaSize, max);
		}
		System.out.println(max);
		
		
		
		
	}
}
