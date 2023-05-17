package New;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * 
 * @author 슬라이딩 윈도우 기법
 * 조건 : 일렬정렬, 순서가 변경되지 않아야함, 윈도우 사이즈 K
 * 
 */


//목표 : 현무가 이길 확률이 존재하는가?
// 짝수 : 재윤
// 홀수 : 현무

public class New01 {
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); // 종이 컵의 수
		int K = Integer.parseInt(str[1]); // 인접한 K
		String Onumber[] = br.readLine().split(" ");
		int number[] = new int[N];
		for(int i = 0; i <N; i++) {
			number[i] = Integer.parseInt(Onumber[i]);
		}
		boolean flag = solve(N,K,number);
		if(flag){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
		// 결과 출력
		// 100000000000 ->long타입 기술
		
		
	}
	public static boolean solve(int N, int K ,int number[]){
		long sum = 0;
		for(int i = 0; i < K; i++){
			sum += number[i];
		}
		if(sum %2 == 0) return true;
		
		
		for(int i = 1; i+K-1 < N; i++){
			 sum = sum - number[i-1] + number[i+K-1];
				
			if(sum % 2 == 0){
				return true;
			}
		}
			return false;
	}
}

