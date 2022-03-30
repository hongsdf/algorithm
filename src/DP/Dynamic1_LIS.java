package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dynamic1_LIS {
	public static int N;
	public static int arr[];
	public static int d[]; // 각 위치의 최대수열 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		LIS(arr);
	}

	private static void LIS(int[] arr) {
		// 2차원 이다 : 왜? 1.배열에서 2.안의 원소별로 파악하기 때문에 => 2차원
		d = new int[arr.length];
		int max = 1;
		for(int i =0; i<arr.length; i++) {
			d[i] = 1; // d배열 초기화 이유: 각 위치에서 자신을 포함하면 최소길이가 1이기 때문이다
			for(int j = 0; j < i; j++) {
				// 점화식
				// 기준 포인터(i) 비교대상(j)
				// j    		i(기준) == > j부터 i까지 파악
				// 0    		1
				// 0 1     		2
				// 0 1 2    	3
				// 0 1 2 3  	4
				//  두 수를 비교하여 i(기준)보다 작고 &&  작은 숫자가 가지고 있는 수열길이가 더 크면 가져온다
				if(arr[j] < arr[i] && d[j] >= d[i]) {
					d[i] = d[j]+1;
					if(max < d[i]) max = d[i];
				}
			}
		}
		
		
	}
}
		
