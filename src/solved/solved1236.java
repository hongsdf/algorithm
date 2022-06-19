package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solved1236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char board[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		// 로직
		// 한행 씩 살피면서 x가 존재하면 continue;
		// 한행이 끝날때 까지 없으면 cnt+=1
		
		// 정답은 ROW, COL에 대해 2가지 조건을 수행하고 그중 최대값으로 출력한다.
		// 이유: 각 ,행과 열의 최소값이 다르면 하나는 성립하지 않는것이므로 2개중 최대값이 최소값을 만드는 조건이 된다.
		// ex)
		

		// 행에 대한 최소 값
		int row = 0;
		for (int i = 0; i < n; i += 1) {
			boolean flag = true;
			for (int j = 0; j < m; j += 1) {
				if (board[i][j] == 'X') {
					flag = false;
				}
			}
			if (flag == false) {
				continue;
			} else {
				row++;
			}
		}

		// 열에 대한 최소 값
		int col = 0;
		for (int i = 0; i < m; i += 1) {
			boolean flag = true;
			for (int j = 0; j < n; j += 1) {
				if (board[j][i] == 'X') {
					flag = false;
				}
			}
			if (flag == false) {
				continue;
			} else {
				col++;
			}
		}
		// 2개 중 최대 값으로 출력 : col == 1, row == 3
		// col기준으로는 1명이지만 -> 성립x
		// row기준으로 3명이다  -> 성립 o
		System.out.println(Math.max(row, col));
	}
}
