package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pointer{
	int x;
	int y;
	int count; // 해당지점의 값
	public Pointer(int x, int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class 단풍나무  {
	static int arr[][]; // 단풍배열
	static int N; //전체 좌표갯수
	static int cnt = 0; //전체 반복할 횟수
	static int dx[]= {-1,1,0,0}; // x좌표 이동
	static int dy[] = {0,0,-1,1}; // y좌표 이동
	static int day = 0;
	static List<Pointer> list = new ArrayList<>(); //좌표를 담는 리스트 하루의 결과 배열을 담는다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		if(N == 1){ //1 이면 하루물들고 끝
			System.out.println(day);
			return;
		} 
		arr = new int[N+1][N+1];  //단풍 배열
		for(int i =1; i <=N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++){
				int num = Integer.parseInt(st.nextToken()); 
				if(num == 0) {
					cnt++;
				}
				arr[i][j] = num;
			}
		}
		
			while(true) {
				for(int i = 1; i<=N; i++){
					for(int j = 1; j<=N; j++){
						if(arr[i][j] != 0){
							dfs(i,j); // 0이 아닌 지점탐색
						}
					}

				}
				// 하루 밤이 끝났다.
				for(int i = 0; i <list.size(); i++) {
					Pointer curr = list.get(i);
					if(arr[curr.x][curr.y] < curr.count) {
						arr[curr.x][curr.y] = 0; // 0으로 표기
					}else {	
						arr[curr.x][curr.y] -= curr.count; // 0으로 갱신
					}
				}
				list.clear();
				day++; //하루밤 증가
				boolean flag = check(); // 모든 배열이 물들어있는지 확인하는 매서드
				if(flag) {
					System.out.println(day);
					break;
				}
			}
		
		
	}
	private static boolean check() {
		for(int i = 1; i<=N; i++) {
			for(int j = 1;j<=N; j++) {
				if(arr[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
		
	}
	private static void dfs(int x, int y) {
		// 목적 : 해당지점
		// 물이 든 지점 갯수 선택
		int count = 0;
		// 상하 좌우 탐색하여 0이 아닌 지점 탐색
		for(int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 1 && nx <=N && ny >=1 && ny <=N) { //범위내에 존재하고
				if(arr[nx][ny] == 0) {
					count++;
				}
				
				
			}
		}
		list.add(new Pointer(x,y,count));
		// 한꺼번에 변하도록 list에 좌표저장
		
		// 물이 든 지점 갯수 선택
		
		// 갯수보다 작으면 물이 들어진다. cnt < arr[i][j]
		
		
		
		
	}
}