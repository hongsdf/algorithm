package algorithm;

import java.io.*;
import java.lang.*;
import java.util.*;


// 10만 * 10억 => long
// 인덱스 1번째부터
public class Monster1 {
	public static final Scanner scanner = new Scanner(System.in);
	/**
     * 생일이 m월인 가장 큰 키의 도토리를 찾는 함수
     * @param height  각 도토리의 키
     * @param month   각 도토리의 출생 월
     * @param n   도토리의 수
     * @param m   찾고자 하는 달
     * @return    month[k] == m인 가장 큰 height[k]
     */
	public static int getMaximumHeight(int[] height, int[] month, int n, int m)
	{
		int answer = -1;
		int cnt = 0;
		for(int i = n-1; i >= 0; i--){
			cnt++;
			 if(month[i] == m ){
				 answer = height[i];
				 break;
			 }
			 
		}
		System.out.println(cnt);
		//시간 차이
//		int answer = -1;
//		int cnt = 0;
//		for(int i = 0; i < n; i++){
//			cnt++;
//			 if(month[i] == m ){
//				 answer = height[i];
//			 }
//		}
//		System.out.println(cnt);
		
		
		
		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt(); // 도토리 수
		int[] height = new int[n]; //  키배열
		int[] month = new int[n]; // 월 배열

		for(int i = 0 ; i < n ; i ++)
		{
			height[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			month[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();

		int answer = getMaximumHeight(height, month, n, m);

		System.out.println(answer);
	}

}
