package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?

(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?

세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.*/
// 첫째 줄에 (A+B)%C,
// 둘째 줄에 ((A%C) + (B%C))%C,
// 셋째 줄에 (A×B)%C,
// 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

// 5 8 4
public class Divide {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		System.out.println((A+B)%C); // 1
		System.out.println(((A%C) + (B%C))%C);
		
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);

		
	}
}
