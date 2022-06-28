package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solvedac1312 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int ans = A%B;
		// 방법1
////		System.out.printf("%."+10+"f",(double)(A/B));
//		String str1 = String.valueOf((A/B));
//		String str = Double.toString(A/B);
//		// 위치는 0 부터 시작 수수점은 제외하고 순서를 세야하기 때문에
//		//0과.은 문자는 제외하기 위해 n+1의 위치에 숫자를 출력 
//
//		int ans = str1.charAt(N+1) - '0';
//		System.out.println(ans);
		
		// 방법2
		// N의 전까지 반복
		for(int i = 0; i <N-1; i++) {
			ans *= 10;
			ans %= B; // 한자리수씩 제거
		}
		ans *= 10;
		System.out.println(ans/B);
	}
}
