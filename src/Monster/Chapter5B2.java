package Monster;

import java.util.Scanner;
import java.util.Stack;

// 객체 지향 원리로 설계
public class Chapter5B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//타워 정보 입력
		Tower[] towers = new Tower[N];
		for(int i = 0; i<N; i+=1) {
			int height = sc.nextInt();
			// 배열안에 하나의 타워 정보를 입력
			towers[i] = new Tower(i+1,height); 
		}
		
		// 각 타워마다 수신하는 타워찾기
		findtarget(towers);
		
		for(Tower t : towers) {
			if(t.getTower() == null) {
				System.out.print(0+" ");
			}else {
				// 가리키는 것이 있으면 타켓타워를 출력
				System.out.print(t.getTower().index+" ");
			}
		}
	}

	private static void findtarget(Tower[] towers) {
		// 각 타워마다 수신하는 것을 찾기
		Stack<Tower> towerStack = new Stack<>();
		for(Tower t : towers) {
			Tower target = null; // private 변수도 class에서 접근 하면 가능
			// 자신보다 작은 높이의 타워값은 제거한다.
			while(!towerStack.isEmpty() && towerStack.peek().height < t.height) {
				towerStack.pop();
			}
			// 여기까지 온것은 나보다 큰 타워의 높이만 남아있다
			if(!towerStack.isEmpty()) {
				// 각 타워의 타겟타워를 설정하는 작업
				target = towerStack.peek(); // 자신보다 큰 높이 타워중 가장 앞의 타워를 설정합니다.
			}
			// 타워 마다 타겟타워 설정하기
			t.setTower(target);
			// stack에 해당 타워를 넣는다. => 그리고 다음 타워를 진행
			towerStack.push(t);
			
		}
		
	}
	
	
}
class Tower {
	// 높이
	int height;
	// 인덱스
	int index;
	// 수신할 타워 정보
	private Tower target;
	
	public Tower(int index,int height) {
		this.index = index;
		this.height = height;
		this.target = null;
	}
	//private여서 외부에서 접근 불가 , public 메소드로 생성 
	public void setTower(Tower target) {
		this.target = target;
	}
	// target타워 가져오기
	public Tower getTower() {
//		return Tower.target;
		return target; // 타워 각자의 송신하는 타워를 가지고옴 
	}
	
}
