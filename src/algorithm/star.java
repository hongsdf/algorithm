package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class star {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		boolean flag = false; // 홀  
		for(int i = 0; i <= N/2; i++) {
			
			int mid = N/2;
			int start = mid-i; int end = mid+i;
			for(int j = 0; j <N; j++) {
				
				if(j >=start && j <= end) {	
					System.out.printf("%s","*");	
				}else {
					System.out.printf("%s"," ");
				}
			}
			System.out.println();
			flag = (!flag);
		}
		//짝,홀
		// 밑의 부분
		for(int i = N/2-1; i >= 0; i--) {
			int mid = N/2;
			int start = mid - i; int end = mid + i; 
			for(int j = 0; j<N; j++) {
				if(j >= start && j <= end) {
					System.out.printf("%s","*");
				}else { // 홀수
					System.out.printf("%s"," ");
				}
			}
			System.out.println();
			
		}
		
		
	}
}
