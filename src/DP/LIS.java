package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// 기준보다 작은 수를 찾고 &&
// 작은수의 위치배열의 길이가 기준의 길이보다 클 경우에만 갱신

// *작은 수여도 작은 수의 위치배열의 크기가 작으면 가져올 필요가 없다
public class LIS {
	public static int N; 
	public static Integer arr[];
	public static Integer D[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			
		}
		 LIS(arr);
		 Arrays.sort(D,Collections.reverseOrder());
		 System.out.println(D[0]);
		 
	}

	private static void LIS(Integer[] arr) {
//		int cnt = 0;  
		D = new Integer[arr.length];
		for(int i=0;i<arr.length; i++) {
			D[i] = 1; // 자기 자신의 위치까지는 1로 초기화
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) { // 기준보다 작은 것이 있다면 위치길이 갱신
					D[i] = Math.max(D[i], D[j]+1); // 기준보다 작은 값이 있고, 그 위치값이 나보다 크면 갱신하는 원리
					
				}
			}
		}
		
		
	}
}
