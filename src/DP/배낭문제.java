package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class BackPack{
	int w; // 무게
	int v; // 가치
	int index; //번호
	public BackPack(int index,int w, int v){
		this.index = index;
		this.w = w;
		this.v = v;
	}
	
	// 인덱스를 반환하는 메서드
	public int getIndex(int i) {
		return this.index;
	}
}

public class 배낭문제 {
	public static void main(String[] args) throws IOException{
		// n개의 물건 : 무게 W, 가치 V
		//목적 : V를 최대 구하기
		// 단 무게는 K만큼이 최대
		
//		 물건수 : N(1 ≤ N ≤ 100)
//		 무게 : K(1 ≤ K ≤ 100,000)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int weight[] = new int[N+1]; // 무게 배열
		int value[] = new int[N+1]; // 가치 배열
		for(int i = 1; i <=N; i++) {
			String backpack[] = br.readLine().split(" ");
			int W = Integer.parseInt(backpack[0]);
			int V = Integer.parseInt(backpack[1]);
			weight[i] = W;
			value[i] = V;
			
			
		}
		
		int dp[][] = new int[N+1][K+1];
		
			
			
		// 구현
		for(int i = 1; i <=N; i++) { // 배낭번호
			for(int j = 1; j <=K; j++) { // 무게
			
				// i번째 배낭을 담을 수 없는 경우
				if(weight[i] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					// i 번째 배낭을 담을 수 있는 경우
					dp[i][j] = Math.max(dp[i-1][j-weight[i]] + value[i], dp[i-1][j]);
				}
			
			}
		}
		
		bw.write(dp[N][K] + "\n"); // N개의 가방을 활용하여 k무게를 채울때 최대 가치값
		bw.flush();
		bw.close();
		br.close();
		
	}
}
