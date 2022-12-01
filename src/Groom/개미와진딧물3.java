package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 좌표를 이용하기

public class 개미와진딧물3 {
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int arr[][] = new int[n+1][n+1];
		List<Point> ant = new ArrayList<>();
		List<Point> home = new ArrayList<>();
		
		 
		// 배열 입력 
		for(int i = 1; i <= n; i++){
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= n ; j++){
				  arr[i][j] = Integer.parseInt(token.nextToken());
				  if(arr[i][j] == 1) ant.add(new Point(i,j)); // 개미 좌표
				  if(arr[i][j] == 2) home.add(new Point(i,j)); // 진딧물 좌표
			}
		} 
		// 개미 좌표를 따로 저장
		// 진딧물 좌표를 따로 저장
		// 개미좌표와 진딧물 좌표만 비교해 보고 m거리 내에 존재 하면 살려둔다.
		// [맨하튼 거리]기법을 사용한다
		
		// 로직구현
		for(Point a : ant ) {
			for(Point b : home ) {
				if(manhaton(a,b,m)) {
					cnt++; // 살았다.
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static boolean manhaton(Point a, Point b,int m) {
		if(Math.abs(a.x - b.x) +  Math.abs(a.y - b.y) <= m) return true; // 맨하튼 거리값이 m거리 이내이면
		return false;
	}
}
