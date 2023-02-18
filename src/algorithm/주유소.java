package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 7
 * 3 4 2 2 4 5
 * 8 9 5 4 2 7 1
 * 
 * 내림 차순으로 탐색한다. => (8) 9 (5) (4) (2) 7 (1) : 괄호만 선택된 것
 */

public class 주유소 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		long dist[] = new long[N-1];
		// 거리 담기
		for(int i = 0; i < N-1; i++) {
			dist[i] = Long.parseLong(str[i]);
			
		}
		String str1[] = br.readLine().split(" ");
		long point[] = new long[N];
		for(int i = 0; i <N; i++) {
			point[i] = Long.parseLong(str1[i]);
		}
		
		// 구현
		// 지점 순회
		// 1번 지점과 2번 지점을 비교
		
		long answer = 0;
		
//
		answer += point[0] * dist[0];
		
		int start = 0;
		for(int i = 1; i < N-1; i++ ) {
			if(point[start] < point[i]) {
				answer += dist[i] * point[start];
			}else {
				answer += point[i] * dist[i];
				start = i;
				
			}
		}
		
		bw.write(answer + " \n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
