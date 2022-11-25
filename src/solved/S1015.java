package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 4
// 2 1 3 1

public class S1015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N]; // 입력받는 배열
		int B[] = new int[N]; // 비내림차순 배열
		int P[] = new int[N]; // 결과 배열
		String str[] = br.readLine().split(" ");
		for(int i = 0; i <N; i++) {
			A[i] = Integer.parseInt(str[i]); // 2 1 3 1
			B[i] = Integer.parseInt(str[i]); // 1 1 2 3
		}
		// 비내림 차순 배열
		Arrays.sort(B);
		
		// 목적 : 수열 P 를 찾기
		// B[p[i]] = A[i];
		
		
		
		int k = 0;
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<N; j++) {
				if(B[j] == A[i]) {
					P[i] = j; 
					B[j] = 0; // 확인한 목록 표시 0으로
					A[i] = -1; // 확인 표시
					break;
					
				}
			}
		}
		// 결과 배열
		for(int num :P) {
			System.out.printf("%d ",num);
		}
		
		
		
		
		
	}
}
