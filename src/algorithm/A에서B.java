package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 이문제에서 연산은 딱 2가지다.
 * 1을 이어붙이기, 2를 곱하기
 * 나는 B->A방향으로 역순으로 로직을 처리하였다.
 * 만약 끝자리가 1이아닌 홀수 이면 flag = true;
 * 1이라면 1을 빼기
 * 
 * 짝수라면 2를 나누어 진행한다.
 * 짝수로 나누어 진행하다 A보다작아지면 flag = true가 된다.
 * 
 * flag가 true일때는 -1을 반환한다.
 * 
 */
public class A에서B {
	public static int cnt = 1;
	public static boolean flag = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
//		int cnt = 0;
		//로직 구현
		int answer = 0;
		check(A,B);
		if(flag) {
			answer = -1;
		}else {
			answer = cnt;
		}
		bw.write(answer +"\n");
		bw.flush();
		bw.close();
		br.close();

	}
	// 40023 -> 40022 -> 20011 -> 2001 -> 200->100
	public static void check(int A,int B) {
		// base-case
		if(flag) {
			return;
		}
		
		if(B <= A) {
			if(B < A) flag = true;
			return;
		}
		
		cnt++;
		
		if(B%2 == 1) { //홀수 인지
			String tmp = String.valueOf(B);
			int num = tmp.charAt(tmp.length()-1) -'0';
			if(num == 1) {
				tmp = tmp.substring(0, tmp.length()-1);
				check(A,Integer.parseInt(tmp));
			}else {
				flag = true;
				
			}
		}else { //짝수인지
			check(A,B/2);
		}
		
		
		
		
	}
}
