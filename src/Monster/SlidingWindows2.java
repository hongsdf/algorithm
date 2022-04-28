package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class SlidingWindows2 {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	* 게임의 규칙에 따라 현무가 승리할 수 있는 경우의 수가 존재하는지 검사하는 함수  
	*
	* @param data 
	* @param n 
	* @param k 
	* @return true   현무가 승리할 수 있는 경우의 수가 하나 이상 존재한다면
	* @return false  else
	*/
	public static boolean isWinnable(int[] data, int n, int k) {

		int winCount = 0;
	
		// 예외처리
		long sum = 0;
		for(int i = 0; i<k;i++) {
			sum += data[i];
		}
		if(sum %2 == 0) {
			return true;
		}
		
		for(int i = 0; i+k-1<n; i++) {
			 sum = 0;
			// sum := 데이터 구간합 
			// sum := data[i-1] +data[i+1]
			
			// 왼쪽 값을빼고 오른쪽 값을 추가
			// [2,3,4,5]
			// l1 = 2+3+4 --> S = 9
			// l2 = 9 - 2 + 5 = 12
			sum = sum - data[i-1] + data[i+k-1]; // 기존 sum에서 sum- data[i-1] + data[i+k-1]
			if(sum %2 == 0) {
				return true;
			}
		}
		
		

		if(winCount > 0)
		{
			return true; // 현무가 이김
		}else{
			return false; // 재윤이가 이김
		}
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] data = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			data[i] = scanner.nextInt();
		}

		boolean result = isWinnable(data, n, k);

		if(result)
		{
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

}
