package Groom;
import java.io.*;
import java.util.*;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class 개미와진딧물 {
	static int arr[][];
	static int dx[] = {0,-1,1,0,0}; // 상,하,좌,우
	static int dy[] = {0,0,0,-1,1}; // 상,하,좌,우
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
		
		// 로직 구현
		// 개미집 1
		// 진디물 2
		// 개미집을 찾고 m칸이내에 진디물이 잇는지 찾는다 상하 좌우 있으면 0으로 초기화 , 없으면 그대로 
		// 그래서 최종 개미집 갯수를 구한다
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n ; j++){
				  if(arr[i][j] == 1){
					  flag = false;	
						dfs(i,j,m);
						if(!flag) { 
							arr[i][j] = 0;
						}else {
							arr[i][j] = 1;
						}
					}
			}
		}
		// 개미집이 존재하는지 체크함수실행
		check();
		System.out.println(cnt);
		
	 
	}
	public static void dfs(int a,int b,int m){
		//재귀함수로 구현 (문제 : 시간초과 에러발생 한지점마다 상하좌우를 탐색하므로 )
		// 목적 한칸에서 m칸 만큼 상,하,좌,우 체크
		// 한칸씩 움직일때마다 m-1을 하고 지점에서 상하좌우
		// 탈출조건 m == 0이되면 m까지 이동한것이므로 종료
		
		// 진딧물을 발견하면 로직구현(살아남았다)
		
		// 대각선 영역을 구현하는 것이 핵심
		// 재귀함수구현
		// 한칸에 대하여 상,하,좌,우 움직인다.
		if(arr[a][b] == 2) {
			flag = true; 
		}
		
		
		if(m == 0) return; //한지점 끝까지 다 회전하였다.
		if(a-1 >= 1 && a-1<=n) {
			dfs(a-1,b,m-1); // m번째까지만 갈수있다.
		}
		if(a+1 >= 1 && a+1<=n) {
			dfs(a+1,b,m-1);
		}
		if(b-1 >= 1 && b-1<=n) {
			dfs(a,b-1,m-1);
		}
		if(b+1 >= 1 && b+1<=n) {
			dfs(a,b+1,m-1);
		}
			
		}
		
		
		
	
	public static void check(){
			for(int i = 1; i<=n; i++){
				for(int j = 1; j<=n; j++){
					if(arr[i][j] == 1){
						cnt++;
					}
				}
			}
		}
}