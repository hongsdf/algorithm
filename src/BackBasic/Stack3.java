package BackBasic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// stack 메서드를 구현하는 방법을 직접 작성해 보기
/*	push X: 정수 X를 스택에 넣는 연산이다.
	pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 스택에 들어있는 정수의 개수를 출력한다.
	empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	top:스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * */
public class Stack3 {
	static int[] stack = new int[1001]; // N이 1000이라면
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 출력 BufferedWriter()
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = sc.nextInt();
		stack = new int[T];
		int size = 0;
		
		while(T --> 0) {
			String command = sc.next(); // push(1) x(2) 라고 공백을 포함하여 2개 문단 입력 ==> push + num 한줄에 2개 단어 입력가능
			if(command.equals("push")) {
				int num = Integer.parseInt(sc.next());
				// push x 이렇게 이어서 나온다 sc.next()를 이용해 남은 문자를 받는다.
				stack[size++] = num;
			}else if(command.equals("pop")) {
				if(size == 0) { // size가 0이아니라는 것은 비어있지 않음
//					System.out.println(-1);
					bw.write("-1\n");
				}else { // 현재 사이즈의 가장 윗단 찾고
//					System.out.println(stack[size-1]);
					bw.write(stack[size-1]+"\n");
					size--; // size를 줄인다는 것은 제거
				}
			}else if(command.equals("size")) {
//				System.out.println(size);
				bw.write(size+"\n");
			}else if(command.equals("empty")) {
				if(size == 0) { // 길이가 0이라는 것은 비어 잇다.
//					System.out.println(1);
					bw.write("1\n");
				}else {
//					System.out.println(0);
					bw.write("0\n");
				}
			}else if(command.equals("top")) {
				if(size == 0) {
//					System.out.println(-1);
					bw.write("-1\n");
				}
				
				else {
//					System.out.println(stack[size-1]);
					bw.write(stack[size-1]+"\n");
				}
			}
			
		}
		bw.flush(); // 입력 종료 마크
	}

}