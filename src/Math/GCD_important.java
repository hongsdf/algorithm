package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  수빈이는 동생 N명과 숨바꼭질을 하고 있다. 수빈이는 현재 점 S에 있고, 동생은 A1, A2, ..., AN에 있다.

  수빈이는 걸어서 이동을 할 수 있다. 수빈이의 위치가 X일때 걷는다면 1초 후에 X+D나 X-D로 이동할 수 있다.
  수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.

  모든 동생을 찾기위해 D의 값을 정하려고 한다. 가능한 D의 최댓값을 구해보자.
  
  
  모든 동생을 찾기 위한 최대값
  S = 2지점이고 동생 n1,n2,n3... 여러명이다
  n1,n2,n3..여러명에게 공통 D의 값으로 접근하기 위한다고 되어잇다.
  n1한명만 예시로 든다
  2 ~ 26지점이면  26-2 = 24    1,2,3,4,6,8,12,24접근이 가능하다(24의 약수)
  하지만 문제에서는 n1만 있는 것이아니라 Nn 여러명이면 동생들간의 공통약수를 찾아야한 다 즉 동생간의 gcd
  
  */
public class GCD_important {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 동생 수
		int S = Integer.parseInt(st.nextToken()); // 시작위치
		st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] =  Math.abs(S - Integer.parseInt(st.nextToken()));
		}
		/* 3개 이상 최대 공약수?
			먼저 ans[0] 삽입
			1~ N까지 원소를 비교하는 재귀로 구현
		*/
		int ans = arr[0];
		for(int i = 1; i<N; i++) {
			ans = gcd(ans,arr[i]);
		}
		/* N개 이상의 최대 공약수 구현 */
		System.out.println(ans);
		
	}

	private static int gcd(int x, int y) {
		if( y == 0) {
			return x;
		}else {
			return gcd( y ,x%y) ;
		}
		
	}
}
