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
		int max = -1;
		for(int i = 0; i <N; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		boolean flag = false;
		// 로직 구현
		while(array[0] <= max) {
		for(int i = 1; i<N; i++) {
			if(array[0] <= array[i]) {
				array[0]++;
				array[i]--;
				cnt++;
			}
		}
		for(int i = 1; i<N; i++) {
			if(array[0] <= array[i]) {
				flag = true;
				break;
			}else {
				flag = false;
				break;
			}
		}
		if(flag) {
			continue;
		}else {
			break;
		}
	}
		
		System.out.println(cnt);
		
		
		
	}
}
