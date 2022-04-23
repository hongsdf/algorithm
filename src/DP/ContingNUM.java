package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* n개의 정수로 이루어진 임의의 수열이 주어진다.
  우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
   단, 수는 한 개 이상 선택해야 한다.
  예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
  
  문제를 보고 점화식을 세워보자
  정수 n개로 이루어져 있고 연속값을 선택해야한다
  D[N] = N번까지 최대 연속값이다.
  그럼 D[N]을 완성하기 직전 단계를 구현해야한다.
  D[N]  = D[N-1] + arr[i] 
  
   10, -4, 3, 1, 5, 6, -35, 12, 21, -1문제에서
  음수와 양수 값이 있다.
  2번째 입장  2가지중 하나를 선택한다. 최대 값으로 
  D[2] = D[2-1] + arr[2]
  D[2] = arr[2] 
  
  그래서 D[N] = D[N-1]까지는 직전까지 최대 값을 차곡 차곡 모은것이다.
  
  
  
  
  */
public class ContingNUM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// d[]
		int d[] = new int[N];
		for(int i = 0; i <N; i++) {
			d[i] = arr[i]; //일단 자기 자신이 연속 최대값으로 초기화
		}
		for(int i = 0; i <N; i++) {
			/* 2D 를 사용하지 않은 이유는 ? 
			  원본배열을 arr[]을 생성해 놓았으므로 순서는 바뀌지 않으므로 상수이다
			*/
			if( i - 1 >= 0) {
				if(d[i] < d[i-1] + arr[i]) {
					d[i] = d[i-1] + arr[i];
				}
				
			}
		}
		int ans = d[0]; // 초기값 세팅
		for(int i = 0; i <N; i++) {
			if(ans < d[i]) ans = d[i];
		}
		System.out.println(ans);
		
		
		
		
		
		
	}
}
