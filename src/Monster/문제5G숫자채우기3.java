package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;

/*
 * 패턴찾는 문제 지그재그
 * 1.오른쪽으로 한칸 이동 => 아래로 이동
 * 2.왼쪽 대각선 아래
 * 3.아래로 한칸 이동 => 오른쪽 이동
 * 4.오른쪽 대각선
 * 탈출조건은 배열의 크기만큼 num이 되었을 경우
 */

public class 문제5G숫자채우기3 {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0){
		  int N = Integer.parseInt(br.readLine());
		  int board[][] = new int[N+1][N+1];
			make(board,N*N,N);
			for(int i =1; i<=N; i++){
				for(int j = 1; j <=N; j++){
					bw.write(board[i][j]+" ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}	
	public static void make(int board[][],int sum,int N){
		int num = 1;
		// 현재 좌표 a,b
		int a = 1; int b = 1;
		board[a][b] = num++;
		while(sum != num){
			
		// 오른쪽 한칸
		if(b+1 <=N) {
		board[a][++b] = num++;
		}else { // 아래로 하칸
			board[++a][b] = num++;
		}
		// 왼쪽 대각선 아래
		if(num == sum+1) return;
		while(b-1 >= 1 && a+1 <=N){
			board[++a][--b] = num++;
		}
		// 아래 한칸 => 오른쪽 한칸
		if(a+1 <=N ){
			board[++a][b] = num++;
		}else{
			board[a][++b] = num++;
		}
	
		// 오른쪽 대각선 위	
		if(num == sum+1) return;
		while(b+1 <= N && a-1 >=1){
			board[--a][++b] = num++;
		}	
			
		}
		
		
		// 아래 한칸 => 오른쪽 한칸
		// 오른쪽 대각선 위
		}
		
		

		
	
	
	
}