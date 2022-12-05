package Groom;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 모래섬 {
	public static int arr[][];
	public static int dx[] ={-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static boolean visit[][]; // 방문 여부 체크
	public static int N; // 가로
	public static int M; // 세로
	
	// public static int day = 1; // 최소 섬의 갯수
	public static void main(String[] args) throws Exception {
		// 1 입력층
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		// 모래섬 정보 삽입
		for(int i = 1; i<=N; i++){
			String str1[] = br.readLine().split(" ");
			for(int j= 1; j<=M; j++){
				arr[i][j] = Integer.parseInt(str1[j-1]);
			}
		}
		
		
		//  목적 : 모래섬을 여러 개의 섬으로 나누고자 한다.
		
		//  (섬의 갯수가 2이상이 되면) day를 리턴하는 것
		// 섬의 갯수가 2이상이 되지 않으면 -1를 리턴
		
		// 2. 로직 구현
		// arr[i][j] = 1 모래섬 , arr[i][j] = 0  물
		// 물이 존재한는 지점에서 상하좌우 번짐
		// day마다 전체 check() - 섬이 연결여부
		int bound = 0;
		int day = 1; // 최소 1분부터 시작
		// 섬갯수 체크
		while(true) {
			List<Point> list = new ArrayList<>();
			list.clear();
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=M; j++){
					if(arr[i][j] == 0){ // 물의 위치를 찾는다.
						// 0인 지점들만 따로 배열에 담기
						list.add(new Point(i,j));
					}
				}
			}
			// 물이 없다면 
			if(list.isEmpty()) {
				System.out.println(-1);
				break;
			}
			// 모든칸이 물인 경우
			
			for(Point curr : list) { // 물 잠김 
				dfs(curr.x,curr.y);
			}
			// day 하루가 지남
			
			bound = check(); // 섬 탐색 구역갯수를 세기 위한
			if(bound >=2){
				System.out.println(day);
				break;
			}
			else if(bound == 0) {
				System.out.println(-1);
				break;
			}
			day++;
			
		}
		
		
		
		// 3.정답 리턴
//		System.out.println(-1);
			
	}
	public static void dfs(int a, int b){
		if(visit[a][b]) return;
		visit[a][b] = true;
		// 한칸 씩만 번저야함
		for(int i = 0; i < 4; i++){
			int nx = a + dx[i];
			int ny = b + dy[i];
			if(nx >= 1 && nx <= N && ny >=1 && ny <= M ){
				if(!visit[nx][ny] && arr[nx][ny] == 1){
					 arr[nx][ny] = 0;
				}
			}
		}
		

	}
	// 같은 영역끼리 이여서 체크
	public static int check(){
		boolean visit2[][] = new boolean[N+1][M+1]; // 테크하기위한 boolean 배열
		int cnt = 0; //같은 영역갯수
		for(int i = 1; i<= N; i++){
			for(int j = 1; j<=M; j++){
				if(!visit2[i][j] && arr[i][j] == 1){
					cnt++; // 같은 지점끼리 연결
					// 현재 지도에서 연결
					dfs2(i,j,visit2);// x좌표,y좌표,방문여부2,섬갯수 (같은 지점끼리 연결체크한것)
				}
			}
		}
//		 System.out.println("섬의 갯수:"+cnt);
		
		return cnt;
	}
	
	// 같은 영역끼리 연결
	public static  void dfs2(int a, int b,boolean visit2[][]){ // x좌표, y좌표, 방문여부2
		
		if(visit2[a][b]) return; // 방문한 지점이라면 리턴
		visit2[a][b] = true;
		// arr[a][b] = day; // 색칠하기
		// 한칸 씩만 번저야함
		
		// 의문점  
		// (a+1 >= 1 && a+1 <= N) 을 앞에 적어야 성립한다.
		if(!visit2[a-1][b] && arr[a-1][b] == 1 && a-1 >= 1 && a-1 <= N ){
			dfs2(a-1,b,visit2); // 상
		}
		if((a+1 >= 1 && a+1 <= N) && !visit2[a+1][b] && arr[a+1][b] == 1){
			dfs2(a+1,b,visit2); // 하
		}
		if((b-1 >= 1 && b-1 <= M ) && !visit2[a][b-1] && arr[a][b-1] == 1 ){
			dfs2(a,b-1,visit2); // 좌
		}
		if( (b+1 >= 1 && b+1 <= M ) && !visit2[a][b+1] && arr[a][b+1] == 1 ){
			dfs2(a,b+1,visit2); // 우
		}
		
		
		
		
		
	}
	
}