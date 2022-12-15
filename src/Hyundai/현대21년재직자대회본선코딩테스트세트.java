package Hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현대21년재직자대회본선코딩테스트세트 {
	public static int N;
	public static int T;
	public static long arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		for(int j = 0 ; j < T; j++) {
			// 배열입력
			arr = new long[2*N-1];
			//배열 채워넣기
			st = new StringTokenizer(br.readLine());
			long answer = 0; // 정답 값
			long left = 0; 	 // 왼쪽에서 할당받는 값
			long right = 0;  // 오른쪽에 할당받을수 있는 최대값
			for(int i = 0; i < 2*N-1; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				if(i%2 == 1) { // 할당해 줄수 있는 값 
					right = Math.max(right,Math.max(arr[i] + arr[i-1],arr[i] + arr[i+1]));	// 2k-1번째에 할당해주는 것이 좋을까? or 2k+1에 할당해주는 것이 좋을까?
				}
			}
			while(left <= right) {
				long star = (left+right)/2; // 목표치
				long indo = 0; // 2n에서 2n-1에 할당하고 남은 값
				boolean flag = true; //목표치에 도달한 여부
				// 홀수 번째잇는 값은 2k-1, 2k+1값을 확인하여 무조건 2k-1값에 할당하는 방식
				for(int i = 1; i <2 * N - 1; i+=2) {
					long num = indo + arr[i-1]; // 2k-1의 값을 2n에 할당했을때 값 (***즉 앞에서 할당 받은 경우)
					 if(num < star){
	                        if(star-num > arr[i]){ //왼쪽에 할당해도 목표치보다 낮은 경우
	                            flag = false;
	                            break;
	                        }else{
	                            indo = arr[i] - (star-num);//왼쪽에 할당 후 갱신
	                        }
	                    }else{
	                        indo = arr[i]; //할당해줄 필요가 없는 경우 
	                    }
				}
				if(arr[2*N-2] + indo < star) { // 마지막 원소가 할당 받아도 목표치가 안되는 경우
					flag = false; // 목표치 보다 안되는 경우
				}
				
				if(flag) {
					left = star+1; // 한줄씩 다 채웠다.
					answer = star;
				}else {
					right = star-1;
				}	
			}
			// 정답
			System.out.println(answer);
			
		
			
			
		}
		
	}
}
