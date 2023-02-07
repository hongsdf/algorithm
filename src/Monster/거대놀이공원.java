package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;
public class 거대놀이공원 {
	
	
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		 // 100 * 300 * 300 = 9,000,000
		while(T -- > 0) {
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int board[][] = new int[N][N];
		int answer = N * N;
		for(int i = 0; i <N; i++){
			String str1[] = br.readLine().split(" ");
			for(int j = 0; j <N; j++){
				board[i][j] = Integer.parseInt(str1[j]);
			}	
		}
		// 로직 구현
		for(int i = 0; i + K -1 < N; i++){
			for(int j = 0; j+ K -1 < N; j++){
				  int cnt  = bfs(i,j,K,board);
				 answer = Math.min(answer,cnt);
			}
		}
		System.out.println(answer);
		
		}
	}
	// 탐색
	public static int bfs(int x, int y,int size,int board[][]){
		int count = 0;	
		for(int i = x; i <x+size; i++){
				for(int j = y; j < y+size; j++){
					if(board[i][j] == 1) count +=1;
				}
			}
		return count;
	}
	
}