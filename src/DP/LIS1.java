package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.*/
public class LIS1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N] ;
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 결과 배열
		int d[] = new int[N];
		for(int i = 0; i <N; i++) {
			d[i] = 1;
		}
		
		for(int i = 1; i <N; i++) {
			for(int j = 0; j <= i; j++) {
				if(arr[j] < arr[i] && d[j] >= d[i]) {
					d[i] = d[j] + 1;
				}
			}
		}
		int ans = -1;
		for(int i = 0; i <N; i++) {
			if(ans < d[i]) ans = d[i];
		}
		System.out.println(ans);
		
	}
}
