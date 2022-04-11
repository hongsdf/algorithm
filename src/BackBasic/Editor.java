package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

// 에디터 문제 : 커서를 기준으로 문자를 삽입, 삭제, 커서 이동 
// 이러한 문제는 2개의 스택을 이용하여 풀자
// left 스택, right 스택
// 결과는 왼쪽 스택을 오른쪽 스택으로 전부 옮겨서 출력하자.
// 문자열로 해결하면 o(N) 문자열의 길이 만큼
// stack  O(N)으로 해결 가능


//줄로 된 간단한 에디터를 구현하려고 한다.
// 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로,
// 최대 600,000글자 ==> 시간 복잡도 최대 M(600,000)
// N이고, 영어 소문자로만 이루어져 있으며, 길이는 100,000 N(100,000)
// 시간 복잡도 O(N + M) == O(600000+100000)


public class Editor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		// 왼쪽에 옮겨 놓고 시작
		for(char c : s.toCharArray()) {
			left.push(c);
		}
		
		
		while(N --> 0) {
			String Line[] = br.readLine().split(" ");
		
			// Line[0] = pab
			// Line[1] = x
			char command = Line[0].charAt(0); // pab --> p
			if(command == 'P') {
				char c = Line[1].charAt(0); // x
				left.push(c); // 왼쪽 추가
			}else if(command == 'B') {
				// (커서가 문장의 맨 앞이면 무시됨) : left에 값이 없으면
				if(!left.isEmpty()) {
					left.pop();
				}
			}else if(command == 'L') {
				// 이동 개념을 right에서 pop해서 left에 추가한다고생각
				// abcd | xyz
				// abc|dxyz
				// 왼쪽에잇는 것을 오른쪽으로 이동
				if(!left.isEmpty()) {
					char c = left.pop();
					right.push(c) ;
				}
				
			}else if(command == 'D') {
				// abcd | xyz
				// abcd|xyz
				// abcdxyz|
				// 오른쪽에 잇는 것을 왼쪽으로 넘긴다 어차피 나중에 합칠것이기때문에 원본이 손상된것은 아니다.
				if(!right.isEmpty()) { // 오른쪽에 넘길게 있어야 넘긴다.( = 커서가 문장이 맨뒤이면 수행 x)
					char c = right.pop();
					left.push(c);
				}
			}
			
			// left --> right로 이동
			
		}
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			char w = left.pop();
			right.push(w);
		}
		// right에 있는 것을 출력
		while(!right.isEmpty()) {
			char rightw = right.pop();
			sb.append(rightw);
		}
		System.out.println(sb.toString());
	}
}
