package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// O(N^2)
// 후보들을 순회하며 나보다 큰 후보를 만나면 1 투표를 가져온다 
// 나 +1 , 상대 -1
// 나의 상태 계속 유지상태
// cnt++

public class solvedac1417 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		// 후보수 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		// 각 후보들 점수 입력 받기
		int array[] = new int[N+1];
		
		for(int i = 0; i <N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		// 최대값 찾기
		while(true) {
			boolean flag = true; // 최대값 flag
			if(N == 1) {
				System.out.println(0);
				break;
			}
			for(int i = 1; i<N; i++) {
				if(array[0] <= array[i]) {
					array[0]++;
					array[i]--;
					cnt++;
				}
				
			}
			for(int j = 1; j<N; j++) {
				if(array[0] <= array[j]) {
					flag = false;
				}
			}
			if(flag) {
				System.out.println(cnt);
				break;
			}else {
				continue;
			}
			
		}
		
	}
}
