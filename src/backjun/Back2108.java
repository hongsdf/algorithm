package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		산술평균 : N개의 수들의 합을 N으로 나눈 값
//		중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//		최빈값 : N개의 수들 중 가장 많이 나타나는 값
//		범위 : N개의 수들 중 최댓값과 최솟값의 차이
//		
//		5
//		1
//		3
//		8
//		-2
//		2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Case = Integer.parseInt(br.readLine());
		int arr[] = new int[Case];
		for(int i =0; i <arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
//		for(int a: arr) {
//			System.out.println(a);
//		}
		// 1번 산술평균 : N개의 수들의 합을 N으로 나눈 값
		double sum = 0;
		for(int i =0; i<arr.length; i++) {
			sum += arr[i];
		}
		// Math함수의 round()  :  첫째 자리에서 반올림 -> return int
		double round = sum / arr.length;
//		System.out.println(round);
		System.out.println(Math.round(round));
//		System.out.println(" 반올림"+Math.round(-1.8));
		
		// 2번 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		Arrays.sort(arr);
		System.out.println(arr[arr.length/2]);
		
		// 3 최빈값 : N개의 수들 중 가장 많이 나타나는 값
//		int temp[] = new int[500001];
//		for(int i=0; i<temp.length;i++) {
//			temp[i] = 0;
//		}
//		int max = -1;
//		for(int i =0; i <arr.length; i++) {
//			temp[arr[i]]++;
//		}
//		int result = 0;
//		for(int i =0; i<temp.length; i++) {
//			if(max <= temp[i]) {
//				max = i;
//			}
//		}
//		System.out.println(max);
		
		// 4 : 범위 : N개의 수들 중 최댓값과 최솟값의 차이
		
		System.out.println(arr[arr.length-1] - arr[0]);
	}
}
