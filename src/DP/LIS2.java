package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* LIS + 역추적 문제
 * 
 * 역추적문제에서는 재귀로 구현하는 것이 편하며 기록을 남겨 구하는 것이다.
  
 * */
public class LIS2 {
	public static int v[];
	public static int d[];
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N] ;
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 결과 배열
		d = new int[N];
		// 역추적하기위한 배열
		v = new int[N];
		
		
		for(int i = 0; i <N; i++) {
			d[i] = 1;
			v[i] = -1; // 역추적은 -1로 초기화 하고 시작(추가 코드)
		}
		
		for(int i = 1; i <N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && d[j] >= d[i]) {
					d[i] = d[j] + 1;
					v[i] = j; // 핵심 역추적을 하기 위해 (추가 코드)
					// i번째 까지 오기까지 직전의 j번호 (바로 이전 번호)
					// 그니깐 i을 만들기 위한 전 위치
				}
			}
		}
		
		
		// int ans = -1;// 길이를 반환하는 것이아닌 값을 리턴
		int ans = 0;
		int p = 0;// 수열의 취이 저장 변수
		
		
		for(int i = 0; i <N; i++) {
			if(ans < d[i]) { // 최장 수열을 찾고 
				ans = d[i];
				p = i; // 그때의 수열의 위치를 저장한다.
			}
		} 
		/* 재귀 함수를 통해 최장 수열의 위치부터 역추적을 시행한다*/
		sb.append(ans).append("\n");
		back(p);
		System.out.println();
		System.out.println(sb);                                              
		
	}
	
	private static void back(int p) {
		if(p ==  -1) return;// -1이라는 것은 시작지점까지 되돌아 왔다는 것
		back(v[p]) ;
		sb.append(arr[p]).append(" "); // arr[p]이다
		/*v[p]가 아니다 -> 이건 위치 저장 정보일뿐
			실제 정보를 넣어야한다
		*/
		
	}
}
