package Monster;

import java.io.*;

public class 문제5E숫자채우기1 {

  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
		StringBuilder sb = new StringBuilder();
		while(T --> 0){
			int N = Integer.parseInt(br.readLine());
			int board[][] = new int[N+1][N+1];
			boolean visit[][] = new boolean[N+1][N+1];
			make(board,N,visit);
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=N; j++){
					 sb.append(board[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString() +"\n");
		bw.flush();
		bw.close();
		br.close();
  }
	
	public static void make(int board[][], int N,boolean visit[][]){
		int num = 1;
		int a = 1;
		int b = 0;
		int cycle = 2 * N -1;
		while(cycle -->0){
//			if(num == N*N) break;
		// 1. 열 증가
			for(int i = b+1; i<=N; i++){
				if(visit[a][i]) break;
				visit[a][i] = true;
				board[a][i] = num++;
				b = i;
				if(num == N*N+1) return;
			}
		// 2. 행 증가 
			for(int i = a + 1; i<=N; i++){
				if(visit[i][b]) break;
				visit[i][b] = true;
				board[i][b] = num++;
				a = i;
				if(num == N*N+1) return;
			}
		// 3. 열 감소
		for(int i = b - 1; i >= 1; i--){
			if(visit[a][i]) break;
			visit[a][i] = true;
			board[a][i] = num++;
			b = i;
			if(num == N*N+1) return;
		}
		
		// 4. 행 감소
			for(int i = a-1; i>=1; i--){
				if(visit[i][b]) break;
				visit[i][b] = true;
				board[i][b] = num++;
				a = i;
				if(num == N*N+1) return;
			}
			
			
			
			
		}
		
		
	
		
		
	}
}

