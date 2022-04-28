package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		//입력층
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구현
		// 배열을 순회하다가 누적합이 더 했을때 M이 되면 경우의수 ++
		// 누적합이 M미만의 수이면 계속 진행
		// 하지만 더하다가 M을 초과 하면 break;
		int sum = 0;
		int cnt = 0;
		// 10 5
		// 1 2 3 4 2 5 3 1 1 2
		for(int i = 0; i<N; i++) { // 10,000 * 10,000 := 1초가 넘어간다
			sum = 0;
			for(int j = i; j<N; j++) {
				sum += arr[j];
				if(sum == M) {
					cnt++; //경우의수 증가
					break;
				}else if(sum > M) {
					break; // M을 초과한경우 break
				}
				
			}
		}
		System.out.println(cnt);
	}
}
