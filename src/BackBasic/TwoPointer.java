package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TwoPointer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		 st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 연속된 수 : 길이가 정해지지않았다. 윈도우 슬라이딩 기법 x
		// 윈도우 슬라이딩 기법은 k가 상수여야된다
		
		// 2개의 포인터를 만들어 그사이값을 S 값이랑 비교한다.
		int FirstPointer = 0;
		int SecondPointer = 0;
		int sum = 0; // 1억이하
		int min = Integer.MAX_VALUE;
		while(true) {
			if(sum >= S) { // 첫번째 포인터가 움직이는 경우
				sum -= arr[FirstPointer++];// 사이값이 S보다 작아질때까지 FirstPointer 이동
				// 그때의 두 포인터간 길이 측정
				min = Math.min(min, SecondPointer - FirstPointer +1);
			}
			// 탈출조건
			else if(SecondPointer == N) break; // 두번째 포인터가 끝까지 도달하면 
			else {
				sum += arr[SecondPointer++];
			}
		}
		bw.write(min+"\n");
		
		bw.flush();
		
		 
//		10 15
//		5 1 3 5 10 7 4 9 2 8
	}
}
