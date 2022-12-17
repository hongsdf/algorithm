package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공포도1 {
	public static int answer = 0;
	public static void main(String[] args) throws IOException{
		// [1] 입력층
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int arr[] = new int[str.length];
		for(int i = 0; i <arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		// 구현층 
		// 그리디 알고리즘
		// 특정 상황에서 최적의 조건을 선택하는 기법
		// 하지만 실제 정답을 고려 할때 '정당성'을 고려해 봐야한다.
		// 정당성이란 앞의 있는 최적의 조건을 선택하여도 결과랑 같은지 확인하는 것이다.
		// 이런 기법을 사용하기 위해 조건들을 잘 확인해야한다.
		
		Arrays.sort(arr);
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count +=1;
			
			if(count >= arr[i]) {
				answer++;
				count = 0;
			}
		}
		// 1 2 2 2 3
		System.out.println(answer) ;
	}
}
