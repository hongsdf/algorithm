package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 동물원 문제 이해하기(세로 와 가로를 고려한 방법)
 * 
 *  문제에서 2 * n 배열이 주어진다.
 *  
 *  겹치기 않게 동물을 배치한다
 *  
 *  기준은 세로 줄 n이다(변수이므로 설정)
 *  
 *  0번 줄에는 [  ] [   ] 경우의수가 3가지있다.
 *  1가지 [][]
 *  2가지 [o][]
 *  3가지 [][o]
 * 
 * 	그러면 1번 줄을 생객해보자
 *  0 번줄이 [][]라면
 *  1 번줄은 [ ][ ]
 *  	   [o][ ]
 *          [ ][o]
 *          
 *  0 번줄이 [][o]라면
 *  1 번줄은 [ ][ ]
 *          [ o][] 
 *          
 *  0 번줄이 [o][]라면
 *  1 번줄은 [ ][ ]
 *          [ ][o] 이다
 *          
 *                         
 *  그래서 i번째 줄위치는
 *  d[i][0]  = i번째 위치를 0으로 끝내는 경우 - > i-1은 3가지 존재
 *  d[i][1] = i번재 위치를 1로 끝내는 경우 -> i-1 2가지
 *  d[i][2]  = i번째 위치를 2으로 끝내는 경우 -> i-1 2가지
 *  
 *                          
 * 
 *  
 * 
 * 
 * 
 * */
public class ZOO {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int d[][] = new int[N+1][3]; // 3 : 경우의 수를 의미
		d[0][0] = 1; // 초기값 세팅 아무것도 선택하지 않았다.
	
		for(int i = 1; i <=N; i++) {
			d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) % 9901; // i번재 위치까지 0으로 끝났다면 i-1번째 위치는 모로 끝났을까?
			d[i][1] = (d[i-1][0] + d[i-1][2]) % 9901;
			d[i][2] = (d[i-1][0] + d[i-1][1]) % 9901;
		}
		System.out.println((d[N][0] + d[N][1] + d[N][2])%9901 );
		
		
		
	}
}
