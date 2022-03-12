package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;


// 문제 1~n까지 숫자를 쌓을 경우 너가 입력한 숫자(배열)와 stack 과 비교하여 수열을 완성하라
public class Linear {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<Integer>();
		
		int arr[] = new int[n];
//		List<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for(int i =0; i <n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 7
		// 5
		// 3
		// :
		
		for(int i =1; i <=n; i++) {
			st.push(i);
			sb.append("+").append("\n");
			while(!st.isEmpty()) {
				if(st.peek() == arr[index]) {
					st.pop();
					sb.append('-').append("\n");
					index++; // 다음수도 맞는 지 않맞는지 여부 확인
					//   5  -->   o    5
					//   3  -->   x    4
					//그러면 while 종료
					
				}else { // 못찾으면 while종료 후 for문으로 돌아가기
					break;
				}
			}
		}
		if(st.isEmpty()) {
			System.out.println(sb);
		}else {
			System.out.println("no");
		}
	}
}
