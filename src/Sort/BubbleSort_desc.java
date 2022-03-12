package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort_desc {
//	public static void bubble(int arr[]) {
//		// bubble 정렬
//		// 앞칸 과 뒤칸을 비교해서 자리를 바꾼다
//		// 반복 횟수 :  arr.length -1
//		// 각 라운드 마다 -1 횟수
//		
//		for(int i =0; i<arr.length-1;i++) { // 4 행
//			for(int j =0; j<arr.length-1 -i;j++) { //4 3 2 1 횟수  총 10번 
//				if(arr[j] > arr[j+1]) {
//					int temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//					
//					// 시간을 중ㄹ
//				}
//			}
//		}
//		for(int i =0; i<arr.length;i++) {
//			System.out.println(arr[i]);
//		}
//		
//		
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Integer arr[] = new Integer[n];
		for(int i =0; i<arr.length; i++) {
			arr[i] = Integer.parseInt( br.readLine());
			
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		// 한 행씩 입력을 받는다
		for(int i =0; i<n; i++) {
			sb.append(arr[i]+ "\n" );
		}
		System.out.println(sb);
		
	}

}
