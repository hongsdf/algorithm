package Search;

import java.util.*;

// 복습 필요 (ctrl + 방향키 개념)
public class CardImportant {
	public static void main(String[] args) {
		Solution m = new Solution();
		int r = 1;
		int c = 0;
		int board[][] = new int[][] { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
		int ans = m.solution(board, r, c);
		System.out.println(ans);
	}
}

class Solution {
	int Board[][]; // 필드
	static final int INF = 987654321;

	class Point {

		Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.cnt = t;
		}

		int x, y, cnt; // 행, 열, 조작 횟수(그 지점까지의 조작 횟수 : 여태 그 지점으로 오기 까지 조작 횟수저장)
	}

	static final int dx[] = { -1, 1, 0, 0 };
	static final int dy[] = { 0, 0, -1, 1 };

	public int bfs(Point src, Point to) { // Point src : 시작점, Point to : 목적지
		boolean[][] visited = new boolean[4][4];
		Queue<Point> q = new LinkedList<Point>();
		q.add(src); // src : Point 객체
		while (!q.isEmpty()) {
			Point curr = q.poll();
			// 현재 지점에서 4방향 움직임
			if (curr.x == to.x && curr.y == to.y)
				return curr.cnt; // 목적지 도달했으면 현재 조작 횟수를 리턴

			for (int i = 0; i < 4; i++) { // 방향키 4방향 한칸이동
				int nr = curr.x + dx[i];
				int nc = curr.y + dy[i];
				if (nr < 0 || nr > 3 || nc < 0 || nc > 3)
					continue;
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, curr.cnt + 1));// 현재 조작 횟수 + 1
				}
				// 먼저 한칸이동을 구현하고 +  4방향 안에 ctrl키 조작 
				// ctrl + 조작키
				// 최대 한번에 2번만 갈수 있다.(*최대 횟수 찾기*)
				for (int m = 0; m < 2; m++) {
					// 4방향중 한칸 간위치(현재 위치)
					if (Board[nr][nc] != 0)
						break; // 카드가 없는 위치만 갈수 o
					// 범위를 초과하면 갈수 없는 위치 : nr , nc는 위의 *한칸씩만 이동한 좌표*에서
					// ctrl를 정용할 수 있는 지 판단

					if (nr + dx[i] < 0 || nr + dx[i] > 3 || nc + dy[i] < 0 || nc + dy[i] > 3)
						break;

					// 위에 걸리는 것이 없다면 갈수 있다. 
					nr += dx[i];
					nc += dy[i];
				}

				// ctrl이 적용 되면 확인
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, curr.cnt + 1));
				}

			}

		}
		return INF;

	}

	// 순서를 고르는 메서드
	int Permute(Point src) {
		// 1번을 고르고 2번을 고르는 횟수 와 2번을 고르고 1번을 고르는 횟수는 다르다
		// 그리고 2개의 1번에 대해서도 1[0] 을 선택하고 1[1]고르는 것랑 1[1]을 고르고 1[0]을 고르는 횟수는 다르다
		// 그래서 완전 탐색을 진행해 보고 최소 값을 갱신하는 원리
		int ret = INF;
		for (int num = 1; num <= 6; num++) {
			List<Point> card = new ArrayList<Point>();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (Board[i][j] == num) {
						// 해당 num의 카드를 찾으면 card 리스트에 저장한다(한 번호당 2개)
						card.add(new Point(i, j, 0)); // 처음 카드를 찾는것 1,2,3 중 어떤 것부터 시작할지
					}
				}
			}

			// 못찾았으면 찾을 때 까지 진행
			if (card.isEmpty()) {
				continue;

			}

			// 찾았다면 시작점 -> 첫번째 + 두번째 시작점 -> 두번째 + 첫번째 비교
			// +2 : 두개의 카드를 뒤집는 행동 cnt += 2
			int one = bfs(src, card.get(0)) + bfs(card.get(0), card.get(1)) + 2; // 순차적

			int two = bfs(src, card.get(1)) + bfs(card.get(1), card.get(0)) + 2; // 역순

			// 2개의 카드를 확인 했으면 뒤집다 표시 card.get(0)의 좌표 와 card.get(1)의 좌표 을 뒤집어야한다.
//			for (int i = 0; i < 2; i++) {
//				Board[card.get(i).x][card.get(i).y] = 0;
//			}

			Board[card.get(0).x][card.get(0).y] = 0;
			Board[card.get(1).x][card.get(1).y] = 0;

			// 재귀 함수를 구현 1번~3번 선택하고 + 다음 나머지 카드중 어떤것을 뒤집는 게 유리한지 (순열)
			// 순차적일때 다음 num 진행
//			ret = Math.min(ret, one + Permute(card.get(1)));
//			System.out.println(ret);
			// 역순일때 다음 num 진행
//			ret = Math.min(ret, two + Permute(card.get(0)));

			ret = Math.min(ret, one + Permute(card.get(1)));
			ret = Math.min(ret, two + Permute(card.get(0)));

			// 카드 다시 복원 왜냐면? 1번카드를 선택하고 2번카드를 진행하는 것보다 2번카드를 먼저 선택하고 1번카드를 진행하는 것이 유리할수 도
			// 있으므로 모든 경우에 대해 순차적,역순까지도 생각해야한다.

//			for (int i = 0; i < 2; i++) {
//				Board[card.get(i).x][card.get(i).y] = num;
//			}
			// 다음 수 를 위해 복원 해 준다.
			Board[card.get(0).x][card.get(0).y] = num;
			Board[card.get(1).x][card.get(1).y] = num;

			if (ret == INF)
				return 0;
		}
		return ret;

	}

	public int solution(int[][] board, int r, int c) {
		Board = board;

		return Permute(new Point(r, c, 0)); // 최소 비용이 나온다
	}

}