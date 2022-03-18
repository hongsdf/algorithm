package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class jelwery {
	public static int N; //지점 갯수
	public static int E; // 간선 갯수
	public static int board[][]; // 인접행렬
	public static int d[]; //다익스트라 시작점와 관한 정보
	public static int INF = 999990088;
	public static int diamond[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		
		board = new int[N+1][N+1];
		d = new int[N+1];
		diamond = new int[N+1] ; // 간 지점의 보석 정보
		for(int i =1; i<=N; i++) {
			for(int j =1; j <=N; j++) {
				if(i == j ) board[i][j] = 0;
				else board[i][j] = INF;
			}
		}
		
		// 간선 정보 입력
		for(int i =0; i<E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int cost = sc.nextInt();
			// 양방향 그래프
			board[u][v] = board[v][u] = cost;
		}
		
		// 보석 정보 입력
		for(int i =1; i<=N; i++) {
			diamond[i] = sc.nextInt();
		}
		
		dijk(1);
		
		// 정답
		int answer = -1;
		int max = 0;
//		Integer ans[] = new Integer[N+1];
		for(int i=1; i<=N; i++) {
			System.out.println(diamond[i] - (2 * d[i]));
//			ans[i] = diamond[i] - (2 * d[i]);
//			answer = Math.max(diamond[i] - (2 * d[i]),answer);
			if(answer < diamond[i] - (2 * d[i])) {
				answer = diamond[i] - (2 * d[i]);
				max = i;
			}
			
			
		}
//		Arrays.sort(ans,Collections.reverseOrder());
		System.out.println("위치번호"+max);
		System.out.println("효율적 보석 담기 : "+answer);
		
	}
	private static void dijk(int start) {
		// 거리 초기화
		for(int i=1; i<=N; i++) {
			d[i] = INF;
		}
		d[start] = 0; //시작 지점 초기화
		// 우선 순위 큐 생성 거리가 짧은 순서대로 디큐
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
		q.add(new int[] {start,0});
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			int idx = curr[0];
			for(int i = 1; i<=N; i++) {
				if(d[i] > d[idx] + board[idx][i]) {
					d[i] = d[idx] + board[idx][i];
					q.add(new int[] {i,d[i]});
				}
			}
		}
		
		
	}
}
