package solved;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 원형 문제 개념
// 테스트 케이스 입력
// 2중 배열로 선언하고 한행의 N의 값으로 신고자,당한자를 찾는 문제
// 한행의 N을 찾으면 N의 위치를 찾는다.
// N의 위치만큼 이동해서 찾는다.
// 각 행의 0번째 위치는 사람이고
// N의 위치는 음수값이 될수있다 ==> 원형으로 + 사람수를 더해 원형을 유지하도록 만든다.
// 정답 찾기
// 출력 값 주의



public class solvedac1384 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스를 입력받는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		//wihile()
		while(true) {
			int T = Integer.parseInt(br.readLine());
			// 0 이면 테스트 케이스 종료
			if(T == 0 ) break;
			
			String array[][] = new String[T][T];
			
			for(int i = 0; i <T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<T; j++) {
					array[i][j] = st.nextToken();
				}
				
			}
			boolean flag = true ;
			System.out.println("Group "+num);
			
			for(int i = 0; i<T; i++) {
				String A ="";
				String B ="";
				for(int j =1; j<T; j++) {
					if(array[i][j].equals("N")) {
						flag = false;
						if(i-j >= 0) {
							 A = array[i-j][0]; // 공격
							 B = array[i][0]; // 수비
							
							
						}else {
							 A = array[i-j+T][0]; // 공격
							 B = array[i][0]; // 수비
							
						}
						System.out.println(A+" was nasty about "+B);					
					}
					
				}
						
			}
			if(flag) {
				System.out.println("Nobody was nasty");
			}
			num++; // 한 라운드
			System.out.println();
		}

		
		
		// 출력 형식
		/*
		 * Group 1 
		 * A was nasty about B 
		 * A was nasty about B
		 * 
		 * Group 2 
		 * Nobody was nasty
		 */
		
		// 원형 문제
		// 왼쪽에서 오른쪽으로 쪽지 전달
		// 사람 수 만큼 쪽지 갯수가 선정
		
		
		// 쪽지 위치 의 N을 찾아서 뒤로 N의 위치 만큼 뒤에 사람 
		
		
		
	}
}
