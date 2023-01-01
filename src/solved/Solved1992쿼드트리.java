package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 분할 정복 
 * 작은 문제들로 분해해 해결한뒤 큰 문제로 다시 합치는 것
 * 
 *
 */
public class Solved1992쿼드트리 {
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
		
		//현재 범위를 전체 압축이 가능하냐
		if(isPossible(row,col,N)) {
			System.out.print(arr[row][col]);
			return;
		}
		
		// 가능하지 않으면
		System.out.printf("%s","(");
		// 4영역 쪼개야 됩니다.
		
		int newsize = N/2;
		// 왼쪽 위
		solve(row,col,newsize);
		// 오른쪽 위
		solve(row,col+newsize,newsize);
		// 왼쪽아래
		solve(row+newsize,col,newsize);
		// 오른쪽아래
		solve(row+newsize,col+newsize,newsize);
		
		System.out.printf("%s",")");
		
		
	}
	private static boolean isPossible(int row, int col, int n) {
		int current = arr[row][col];
		for(int i = row; i <row + n; i++) {
			for(int j = col; j < col+ n; j++) {
				if(current != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
		
		
	
}
