package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 핵심내용
 * 1. 나이트 이동 경로 : 문제에서는 경로 방법이 주어지진 않았지만 8방법으로 움직인다.
 * 2. 시작점과 끝점을 같은 것으로 세팅 str[36] = str[0] 마지막지점으로 돌아와야 종료
 * 3. 방문했던 곳을 또 방문하면 false || 마지막 지점으로 돌아오지 않고 || 나이트 이동경로를 벗어난 경우
 * 
 * */
public class solvedac1331 {
	// 나이트 이동
	static int dmoxve[] = {1,2,2,1,-1,-2,-2,-1}; 
	static int dmoyve[] = {2,1,-1,-2,-2,-1,1,2};
	static String str[];
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫 좌표
		str = new String[37];
		
		
		for(int i = 0; i <36; i++) {
			str[i] = br.readLine();
		}
		boolean check = true; // 결과확인
		board = new boolean[6][6];
		// 시작점과 끝점을 연결
		str[36] = str[0];
		int idx = 0;
		while(idx < 36) { // 36번째까지 올때까지 실행
			String current = str[idx];
			String next = str[idx+1];
			
			char nowX = current.charAt(0);
			char nowY = current.charAt(1);
			board[nowY -'0'-1][nowX - 'A'] = true;
			
			char NEXTX = next.charAt(0);
			char NEXTY = next.charAt(1);
			
			int distX = Math.abs(NEXTX - nowX );
			int distY = Math.abs(NEXTY - nowY );
			boolean flag = false;
			for(int i = 0; i <8; i++) {
				if(dmoxve[i] == distX && dmoyve[i] == distY) {
					flag = true;
					break;
				}
			}
			// 나이트 이동범위대로 수행되지 않을 경우
			if(!flag) {
				check = false;
				System.out.println("Invalid");
				return;
			}
			
			// 나이트 이동대로 탐
			if(board[NEXTY -'0'-1][NEXTX - 'A']) { // 전에 방문했던 이력이 있는 경우
				if(idx != 35) { // 마지막 번호가 아닐경우 = 마지막 원소로 되돌아 와야 종료 
					check = false;
					System.out.println("Invalid");
					return;
				}
			}

			idx+=1;
		}
		
		if(check) {
			System.out.println("Valid");
		}
		
		
	}
}	
