package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리2 {
	public static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N은 2의 제곱수로 주어진다. 4  16  64..  1 ≤ N ≤ 64의 범위를 가진다
		arr = new int[N][N];
		for(int i = 0; i <N; i++) {
			String str = br.readLine();
			for(int j = 0; j< N; j++) {
				arr[i][j] = str.charAt(j)-'0';
				
			}
		}
		// 구현
		// 분할 정복은 재귀함수로 구현
		solve(0,0,N);
	}
	private static void solve(int row, int col, int N) {
		// 현재 위치부터 끝까지 압축이 가능한가
		if(isPossible(row,col,N)) {
			System.out.print(arr[row][col]);
			return; // 가능하면 끝
		}
		
		N = N/2;
		// 압축이 실패하면 압축을 위한 ( 괄호 시작
		System.out.print("(");
		// 4개의 영역으로 분리
		//왼쪽 위
		solve(row,col,N);
		//오른쪽 위
		solve(row,col+N,N);
		// 왼쪽 아래
		solve(row + N,col,N);
		// 오른쪽 아래
		solve(row+N,col+N,N);
		
		// 압축 끝  (
		System.out.print(")");
		
	}
	private static boolean isPossible(int row, int col,int N) {
		// 각각의 좌표로 부터 N거리까지만큼 떨어진것을 측정하기 위해 각자 위치 row,col을 매개변수로 받고  N 까지 거리를 각 측정한다.
		
		int current = arr[row][col];
		
		for(int i = row; i < row +N; i++) { 
			for(int j = col; j < col +N; j++) {
				if(current != arr[i][j]) {
					return false; // 압축 실패
				}
			}
		}
		return true; // 압축 성공
	}
}
