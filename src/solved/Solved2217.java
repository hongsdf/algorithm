package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solved2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 구현
		// 병렬 처리 2개 이상 로프필요
		Arrays.sort(arr);
		// 10
		// 20
		// 25
		int max = -1;
		int answer = 0;
		for(int i = 0; i <N; i++) { // 2개 전까지
			int num = arr[i];
			max = Math.max(max ,num * (N-i));
		}
		System.out.println(max);
		
		// 내가 이해한 내용이 잘못된 것일까?
		// k개 로프를 선택해서 w무게을 들어올릴때 각 로프는 w/k 무게를 들어올린다.
		// w 를 구하는 것이다.
		
		// 정렬을 하고 
		// 로프 수는 지정되지 않았기 때문에 여러개를 선택할수있다.
		// 1 1 1 1 1 : 5개 1을 사용해서 5kg든다.
		
		
		
		if(answer == 150) {
			System.out.println("true");
		}
			
			// 1 2 3 75 76
	}
}
