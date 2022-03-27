package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Gredy
public class Back1026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N];
		int arr2[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		solution(arr1, arr2, N);

	}

	private static void solution(int[] arr1, int[] arr2, int N) {
		Arrays.sort(arr1); // 오름 차순으로 정렬
//		for (int a : arr1) System.out.print(a + " ");
//		System.out.println();
		
//		int max = -1; 여기다 선언하면 안됨 x
		int idx = 0;
		int sum = 0;
		//O(n^2)
		// 한배열을 기준으로 다른 배열에서 최대,최소값을 찾아낼때 max위치를 선정에 주의!!!
		for(int z = 0; z < arr1.length; z++) { //arr1[] N개 매칭
			int max = -1; // 여기다 선언하지 않으면 계속 {2 7 8 3 1} 에서 8로 유지됨
			// arr2[]에서 가장 큰 값을 저장
			for(int i = 0; i < arr2.length; i++) { // arr2[] 개 매칭
				if (max < arr2[i]) {
					max = arr2[i];
					idx = i; // 가장 큰 값 위치를 뽑아 낸다
				}
				
			}
			
			sum += arr1[z] * arr2[idx]; // arr1[0] * 가장 큰 원소
			
//			System.out.println(arr1[z]);
//			System.out.println(arr2[idx]);
			arr2[idx] = 0; // 가장 큰 값을 활용하고 사용했다 종료
			
		
//			for (int a : arr2) System.out.print(a + " ");
//			System.out.println();
		}
			System.out.println(sum);
		
	}
}
