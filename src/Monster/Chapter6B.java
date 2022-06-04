package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter6B {
	public static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hinoi(N, 1, 2, 3);
		System.out.println(cnt);
	}
						// 결국 출발지점위치에서 --> 목적지점으로 이동하는 것
						// 핵심 := 매개변수값이 변하더라도 위치에 중점을 두자
						// ( o, , x,) 결국 := o --> x로 이동 하는 것
	static void hinoi(int N, int from, int mid, int to) {
			// 기둥 하나씩 옮긴다.
			if(N == 1) {
				System.out.println(from+"->"+to);
				cnt++;
				return;
			}
		//	n-1개는 출발지점 ->  중간 기둥
			hinoi(N-1,from,to,mid) ;
		// 1개 출발지점 --> 목적지 기둥
			System.out.println(from+"->"+to);
			cnt++;
		// 중간지점 -> 목적 기둥
			hinoi(N-1,mid,from,to);
	}
}