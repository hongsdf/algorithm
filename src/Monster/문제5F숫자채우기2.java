package Monster;

import java.io.*;

/*
 * 패턴 찾기 문제
 * 용꼬리 문제 한 사이클에 6가지 패턴이 존재한다.
 * 오른쪽 -> 아래 -> 왼쪽 -> 아래 -> 오른쪽 -> 위
 * 해당 이동경로에 +z 만큼씩을 고려해야한다.
 */
public class 문제5F숫자채우기2 {
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
	public static void make(int board[][],int N,boolean visit[][]){
		// 3,6,9,12,15,18,21
		// 1 - 1, 2 - 3, 3 - 6,4 - 12, 5 - 15,6 - 18
		// 6번
		int num = 1;
		int a = 1; int b =1;
		board[a][b] = num++;
		int z = 1;
		while(true){
//			for(int i = 0; i <6; i++){
			// board[a][b] = num++;
			// 오른쪽 1
			if(num == N*N+1) break;
			board[a][++b] = num++;
			// 아래 1
			for(int i = 1; i<=z; i++) {
				if(a+i <=N) {
					board[a+i][b] = num++;	
				}
				
			}
			a = a+z;
			// 왼쪽 1
			for(int i = 1; i<=z; i++) {
				if(b-i >=1) {
					board[a][b-i] = num++;
				}
			}
			b -= z;
			z++;
			// 아래 1
			a+=1;
			if(num == N*N+1) break;
			board[a][b] = num++;
			// 오른쪽 2
			for(int i = 1; i <= z; i++) {
				if(b+i <= N) {
					board[a][b+i] = num++;	
				}
			}
			b += z;
			for(int i = 1; i<=z; i++) {
				// 위 2
				if(a-i >=1) {
					board[a-i][b] = num++;	
				}
				
			}
			a -= z;
			if(num == N*N+1) break;
			z++;	
		}
		
	
//		board[a][b] = num++;
//		// 오른쪽 1
//		board[a][++b] = num++;
//		// 아래 1
//		board[++a][b] = num++;
//		// 왼쪽 1
//		board[a][--b] = num++;
//		// 아래 1
//		board[++a][b] = num++;
//		// 오른쪽 2
//		board[a][b+=z] = num++;
//		// 위 2
//		board[a-=z][b] = num++;
		// ------------------------
		// 오른쪽 1
		
		// 아래 3
		
		// 왼쪽 3
		
		// 아래 1
		
		// 오른쪽 4
		
		// 위 4
		// --------------------------
		// 오른쪽 1
		
		// 아래 5
		
		// 왼쪽 5
		
		// 아래 1

		// 오른쪽 6
		
		// 위 6
	}
		
		
		
}
