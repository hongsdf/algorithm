package Groom;

import java.io.*;
import java.util.*;

public class UxUI {
	public static void main(String[] args) throws Exception {
		List<Integer> answer = new ArrayList<>();
		int max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 빈도수
		int arr[] = new int[102];
		for(int i = 0; i <M; i++){
			 String str[] = br.readLine().split(" ");
			 int K = str.length;
			 for(int j = 1; j < K; j++){
				  int key = Integer.parseInt(str[j]);
				  arr[key]++;
				  if(max < arr[key]){
						 max = arr[key];
					}
			 }
		}
		for(int i = 1; i <102; i++){
			if(arr[i] == max){
				answer.add(i);
			}
		}
		
		Collections.reverse(answer);
		System.out.println(answer.toString());
		
		
		// 구현
		//[4]: {1=1},{2=1},{3=1},{4=1}
		
		// 최대값인 것을 출력
		
		
		// 목적 : 사용자들이 가장 자주 실행하는 이벤트 찾기
		// 중복 가능
		// M명의 사용자들이 가장 자주 실행했던 이벤트들
		
	}
}
