package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미로 찾기 문제 : bfs로 구현 , dfs로 도 가능 하지 않을까?
public class RE_floodfill {
	public static int n;
	public static int m;
	public static int color;
	public static int board [][];
	public static int size;
	public static int answer = 0;
	public static int min = 9999;
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
//		color = Integer.parseInt(st.nextToken());
		
//		size = n+1; // size 선정은 : 문제에서 제시된 만큼 + 1
		board = new int[n+1][m+1];
		for(int i =1; i <n+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =1; j <m+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		1 1 0 1 1 0
//		1 1 0 1 1 0
//		1 1 1 1 1 1
//		1 1 1 1 0 1
		dfs(1,1);
		System.out.println(answer);
		for(int i =1; i <n+1; i++) {
			for(int j =1; j <m+1;  j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println("1,2 :" + board[0][5]);
	}
	




	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		// base - case
		if(r < 0 || r > n || c < 0 || c > m) return;
		if(board[r][c] != 1 || board[r][c] == 0) return; // 중요 포인트 :0 만 칠할수 있다. //0이 아니라는 얘기는 칠해져 있거나 , 벽을 만났다.
		answer++;
		if(r == n+1 && c == m+1 ) return ; // 목적지에 도달 했을때 주의 : n이 4라고 했을때 n+1 == 5
		// 이유: 0,0부터 시작이 아닌 1,1부터 시작하였다 고민
		
//		System.out.println("n :"+n+"m:"+m);
		
		board[r][c] =2;
		if(min > answer) {
			min = answer;
		}
		
//		System.out.println(max);
		dfs(r-1,c);
		dfs(r+1,c); //
		dfs(r,c-1);
		dfs(r,c+1); //
		
		}
		// 인클로징 인스턴스로 할당을 한정해야 합니다.
		// static 붙여야함
	
}
		