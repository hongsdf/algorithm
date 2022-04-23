package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*1, 100, 2, 50, 60, 3, 5, 6, 7, 8*/ 
public class LIS_3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 결과배열
		int d[] = new int[N];
		for(int i = 0; i<N; i++) {
			d[i] = arr[i];
		}
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j < i; j++) { //  0 ~ 자신 전까지만 비교 
//				if(i == j )continue;
				if(arr[i] >= arr[j] && d[i] <= arr[i] + d[j]) {
					d[i] = d[j] + arr[i] ;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i <N; i++) {
			ans = Math.max( ans , d[i]);
		}
		System.out.println(ans);
		
		
		
	}
}
