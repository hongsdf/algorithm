package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Chapter5_C2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 생존자의 수
			int M = Integer.parseInt(st.nextToken()); // 점프 횟수
			Queue<Player> q = new LinkedList<>();
			// Player들 생성
			List<Player> list = new ArrayList<>();
			for (int i = 0; i < N; i += 1) {
				list.add(new Player(i + 1));
			}

			// 큐에 삽입
			for (Player p : list) {
				q.add(p);
			}

			// 정답공간
			List<Player> result = new ArrayList<>();

			// 구현
			// 생존자의 수만큼 라운드 반복
			for (int i = 0; i < N; i += 1) {
				// 남은 생존자 수에만 집중
				// 1을 더해야한다 0번은 없으므로 
				int jump = 1 + (M-1) % q.size(); 
				// 남은 생존자 중 2가지 선택
				for (int j = 0; j < jump - 1; j++) {
					// 1 다시 큐에 삽입(탈락 되지 않는 순번)
					Player p = q.poll();
					q.add(p);
				}

				// 2 탈락 될 순번 찾기
				result.add(q.poll());

			}
			
			for(int i = 0; i<result.size(); i++) {
				Player p = result.get(i);
				System.out.print(p.index+" ");
			}
			System.out.println();
		}

	}
}

class Player {
	int index;

	Player(int index) {
		this.index = index;
	}
	
	
}