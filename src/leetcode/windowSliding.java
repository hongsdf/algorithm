package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class windowSliding {
	public static int arr[];
		public static void main(String [] args) throws IOException{
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String str[] = br.readLine().split(" ");
			 int N = Integer.parseInt(str[0]);
			 int K = Integer.parseInt(str[1]);
			 arr = new int[N+1];
			 String in[] = br.readLine().split(" ");
			 for(int i = 1; i <=N; i++){
				  arr[i] = Integer.parseInt(in[i-1]);
			 }
			 // 로직 
			// 해당 숫자들의 합이 짝수이면 재윤이가 청소를 하고, 홀수이면 현무가 청소를 한다.
			// 경우가 잇는지 여부 확인
			boolean flag = solve(arr,K,N);
			
			System.out.println(flag == true ? "YES":"NO" );
		}
		public static boolean solve(int arr[], int K,int N){
			// 처음 윈도우 사이즈
			int sum = 0;
			for(int i = 1; i <=K; i++){
				sum += arr[i];
			}
			if(sum %2 == 0){
				return true;
			}
			// int sum = 
			
			// k인접 갯수
			for(int i = 2; i<= N - K + 1; i++){
				  sum = sum - arr[i-1] + arr[i+1];
					if(sum %2 == 0){
						return true;
				}
			}
			return false;
		}
	
}
