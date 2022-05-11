package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시물레이션 구현 := 문제에 요구된대로 구현
//
public class Chapter4_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int intialarr[] = new int[N];
		int temp[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		//초기값 세팅
		for(int i = 0; i <N ; i++) {
			intialarr[i] = arr[i];
		}
		for(int i = 0; i<N; i++) {
			temp[i] = arr[i];
		} 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <M; i++) { 
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
//			int k = Integer.parseInt(st.nextToken());
			
			// 0 k(index)
			if(num == 0) {
				int k = Integer.parseInt(st.nextToken());
				sb.append(arr[k]).append("\n");
//				System.out.println(arr[k]);
			}
			// 입력으로 1 K 가 주어지면 현재 배열을 왼쪽으로 한 칸씩 옮기는 동작을 총 K번 수행한다.
			else if(num == 1) {
				int k = Integer.parseInt(st.nextToken());
				while(k --> 0) {
					
					for(int j=1; j<N; j++) {
						
						temp[j-1] = arr[j];
					} 
					temp[N-1] = arr[0];
					for(int j = 0; j <N; j++) {
						arr[j] = temp[j];
					}
				}
			}
			
			else if(num == 2) {
				int k = Integer.parseInt(st.nextToken());
				while(k --> 0) {
					for(int j = 0; j<N-1; j++) {
						temp[j+1] = arr[j];
					}
					temp[0] = arr[N-1];
					for(int j = 0; j <N; j++) {
						arr[j] = temp[j];
					}
				}
			}
			
			// 처음 상태로 돌아오기
			else if(num == 3) {
				for(int j = 0; j <N; j++) {
					arr[j] = intialarr[j];
				}
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}
