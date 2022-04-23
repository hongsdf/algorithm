package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 20
	7
	23
	19
	10
	15
	25
	8
	13
 * 
 * 
 * 
 * */
 
public class Back2309 {
	public static int ans[];
	public static int temp[];
	static int n = 7;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[9];
		ans = new int[n];
		temp = new int [n]; // ans에 복사본 추가 : 필요한 이유 ans는 수행하고나면 포함시키지 말아하는 원소는 다시 돌려놯야하는데 이미 저장되어있다.
		// 밑에 예시
		// arr = 1,2,3,4,5
		// ans = [1,2,3]을 선택하고 k = 3이므로 3개를 확인하고 다시 돌려놯야한다. => [1,2,0] 이렇게
		// 하지만 따로 돌려놓는작업을 하지 않는경우 [1,2,3]으로 되어있고, 갱신에 에러가 발생한다.
		// 그래서 ans조건이 맞으면 ==> temp[]라는 배열에 다시 담아서 출력하면 ans[] 배열과 무관하게 출력
		
		// Arrays.copyOf( int [] a  , a)
		// Arrays.copyOf(원본배열, 복사할 길이);
		// Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준

		
		
		
		for(int i = 0; i <9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		combine(0,0,arr); // 첫번재 매개변수 : 명(체크) , 두번째 매개변수 : 시작노드
		
		for(int a : temp ) System.out.println(a);
		
		
		
		
		
		
	}

	private static void combine(int cnt, int start,int arr[]) {
		// base-case : 7명을 다 찾았을때 체크
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i <7; i++) {
				sum += ans[i];
			}
			if(sum == 100) {
//				for(int a:ans) System.out.println(a);
				temp = Arrays.copyOf(ans, n);
			}
			return;
		}
		// 재귀가 필요한 경우:
		// 7 20 23 19 10 15 .. 에서 이웃한 원소와 비교하는 것이 아니라
		// 7 23 19 15 등 떨어져 있는 경우의 조합도 살펴봐야한다.
		// 이럴때 재귀를 생각해 보자
		// 순서는 
		// 7 20 23
		// 7 20 19
		// 7 20 15 등  모든 조합 탐색 가능 
		for(int i = start; i<arr.length; i++) {
//			ans[i] = arr[i]; // outBound 에러 왜냐면? : ans[]는 7까지인데 arr[] : 9까지이므로
			// ans[9] = arr[9]는 존재 하지 않는다.
			// 해결 방법
			ans[cnt] = arr[i];
			
			combine(cnt+1,i+1,arr);
		}
		
		
		
	}
}
