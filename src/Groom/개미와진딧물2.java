package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 개미와진딧물2 {
	static int arr[][];
 
	static int m; // m칸만큼 거리이동 가능
	static int n; // 정사각형
	static int cnt; //개미집 갯수
	static List<Point> list = new ArrayList<>();
	static boolean flag = false;
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[n+1][n+1];
		 
		// 배열 입력 
		for(int i = 1; i <= n; i++){
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= n ; j++){
				  arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
			if(arr[i][j] == 1) {
				if(search(i,j,m)) {
					cnt+=1;
				}
			}
		}
			
	}
	System.out.println(cnt);		
	// 구현
	// 완전 탐색 (마름보 기법으로 탐색)
	// 좌표 추출 (진딧물정보와 개미 정보로 해결)
	// 입력받을때 개미집정보와 진딧물정보를 받고 시작한다.
	
		
	
	}
	// 마름보 기법으로 탐색하였다.
	private static boolean search(int a, int b, int m) {
		// 윗부분탐색
		for(int i = m; i > -1 ; i--) { // 2 1 0 이해됨
			for(int j = -i; j <= i; j++) { //-3 ~ 3,-2 ~ -2 ,-1~1,0 이해됨
				if( 1 <= a - m + i  && a - m + i  <= n && 1 <= b+j  && b+j  <=n ) {
					if(arr[a - m + i][b+j] == 2) {
						return true;
					}
				}
			}
		}
		

		// 아랫부분
		for(int i = 1; i<= m; i++) {
			for(int j = -m + i; j <= m - i  ; j++) {
				if(1 <= a + i && a + i  <= n && 1 <= b+j && b+j <= n) {
					if(arr[a + i][b+j] == 2) return true;
				}
			}
		}
		
		return false;
	}
	
	
}
