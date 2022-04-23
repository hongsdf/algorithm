package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 n = 90 이여서 return 값을 int라 생각했지만 이진수 이므로 90이면 00011000.. 이런씩일것이다. 
 그래서 long */
public class chinsu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long d[][] = new long[N+1][2];
		
		/* 한자리 수 처리 */
		
		d[1][1] = 1;
//		d[1][0] =1;
		for (int i = 2; i <= N; i++) {

			if (i - 1 >= 0) {
				d[i][1] = d[i - 1][0];

				d[i][0] = d[i - 1][0] + d[i - 1][1];

			}
			
			
		}
		long ans = 0;
		for(int i = 0; i<2; i++) {
			ans += d[N][i];
		}
		System.out.println(ans);

	}
}
