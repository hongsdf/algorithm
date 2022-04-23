package algorithmpRO;

import java.util.*;

public class Queue_Truck {
	public static void main(String[] args) {
		Solution m = new Solution();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		m.solution(bridge_length, weight, truck_weights);
	}
}

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int sum = 0; // 무게 총합
		Queue<Integer> q = new LinkedList<>();
		// 트럭을 순회 할것
		for (int i = 0; i < truck_weights.length; i++) {
			int num = truck_weights[i];
			while (true) { // 사용이유 ? 결국 모든 트럭을 옮겨야한다. 이때 while(true) 생각
				if (q.isEmpty()) { // 다리가 비어 있는 경우 올려야한다.
					q.add(num);
					sum += num;
					answer++;
					break; // break을 만났다는 건 트럭한개를 해결했다. 어찌 됫건 옮겼다.
				} else if (q.size() == bridge_length) {// 다리 자리가 다 차면
					sum -= q.poll(); // 이동 과 누적 값 빼기
				} else { // 무게 확인
					if (sum + num > weight) {
						q.add(0); // 핵심 임의의 값 0으로 넣는다. : 이런 이동문제에서 0을 넣어 자리차지만 시킨다.
						answer++;
					} else {
						q.add(num);
						sum += num;
						answer++;
						break; // break을 만났다는 건 트럭한개를 해결했다.
					}
				}

			}

		}

		return answer + bridge_length; // bridge_length더하는 이유 ? 만약 다리가 5개면 _ _ _ _ _ 옮기기위해 5번 이동해야한다.
	}
}