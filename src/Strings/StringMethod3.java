package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/* 접미사 배열 출력
 * baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면,
 *  aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
 * */
public class StringMethod3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		String[] ans = new String[s.length()];
		/* 접미사 만드는 방법 중요 substring을 활용 */
		for(int i = 0; i <s.length(); i++) {
//			ans[i] = s.substring(i,s.length());
			ans[i] = s.substring(i); // i부터 끝까지 위랑 같은 표현
		}
		Arrays.sort(ans, new Comparator<String>() {

			
			public int compare(String o1, String o2) {
				
				return o1.length() - o2.length();
			}
			
			
		});
		for(int i = 0; i <ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
