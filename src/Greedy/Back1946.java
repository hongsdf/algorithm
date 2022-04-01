package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 100,000 * 100,000 = 10000000000
public class Back1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][2];
			for(int i = 0; i <N; i++ ) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[i][0] = u;
				arr[i][1] = v;
				
			}
			int cnt = solution2(arr,N);
			System.out.println(cnt);
			
			
		}
	} 
	// 시간 초과 에러 이유:
	// N : 100,000이라고 제시
	// 그러면 2중 for문이여서 100,000 * 100,000 시간초과
	
	
	
	private static int  solution1(int[][] arr, int n) {
		int cnt = 0;
		for(int i =0; i <n; i++ ) {
			boolean flag = true; // 기준은 선택되어 있다.
			for(int j = 0; j <n; j++) {
				if(i == j) continue;
				if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) { // 나머지와 비교하다가 기준보다 숫자가크다(낮다라는 의미 여기선!)
					flag = false; // 즉 기준이 제일 낮으면 false 하고 
					break; // 바로 종료 해도 된다(비교 바로 찾음) 나머지 비교 할필요 없음
				}
			}
			if(flag) cnt++; // 살아 남아있다면 cnt++
		}
		
		return cnt;
	}
	
	// 1중 for문으로 해결해야한다 그래서 시간초과해결
	
	private static int  solution2(int[][] arr, int n) {
		Arrays.sort(arr,new Comparator<int[]>() { // int[][] --> int[], int[] -> Integer

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] - o2[0];
			}
			
		});
		// 하나의 기준[0]으로 정렬하고 나머지 한배열[1]로만 정렬하기
		
		int cnt = 1;
		// 기준을 설정할것이다
		// [0]라인은 오름차순으로 정렬이 이미 되어 있다.
		// 1 4
		// 2 5
		// 3 7
		// 첫번째 행이 기준
		int standard = arr[0][1]; // arr[0][1]배열의 첫번째는 무조건 살아남는다
		for(int i=1;i<n; i++) { // 나머지 배열을 순회하다
			if(arr[i][1] < standard) { // 기준보다 우선순위 값(값이 적은값)이 있다면 기준 갱신
				// 기준 변경
				standard = arr[i][1];
				
				cnt++;
			}
		}
		
		
		
		return cnt;
	}
	
	
	
}
