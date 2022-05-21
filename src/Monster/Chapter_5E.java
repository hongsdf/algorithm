package Monster;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Chapter_5E {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		int caseSize = sc.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}

	}

	private static void testCase(int caseIndex) {
		
		int n = sc.nextInt(); // 폭탄수
		int m = sc.nextInt(); // 연관 관계 설정 수
		
		// n개 폭탄 생성
		Bomb[] bomb = new Bomb[n];
		for(int i = 0; i<n; i++) {
			bomb[i] = new Bomb(i);
		}
		// 연관 관계 설정
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt()-1; // 1 :=은 실제로 0이다.
			int b = sc.nextInt()-1;
			Bomb parent = bomb[a];
			Bomb child = bomb[b];
			
			child.addParnet(parent); // 부모 설정

		}
		
		// 구현
		boolean flag = istrue(n,bomb);
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("No");
		}
	}

	private static boolean istrue(int n, Bomb[] bomb) {
		Queue<Bomb> q = new LinkedList<>();
		ArrayList<Bomb> list = new ArrayList<>(); // 제거된 폭탄 담기
		// 폭탄을 살피다가 해당 폭탄의 count가 0이면 큐에 넣는다. ==> 제거가능 폭탄이라는 뜻
		for(Bomb b : bomb) {
			if(b.getCount() == 0) {
				q.add(b);
			}
		}
		while(!q.isEmpty()) {
			Bomb b1 = q.poll();
			list.add(b1); // 제거한 폭탄을 다른 공간에 저장
			b1.remove(); 
			 // 해당 폭탄 b를 제거하면 b의 부모 배열을 수정해주어야한다.
			for(Bomb p : b1.getParentBomblist()) {
				 int cnt = p.getCount();
				 // 이때 count == 0 이면 다시 큐에 넣어 준다(제거가능한 폭탄이 됨)
				 if(cnt == 0) {
					 q.add(p);
				 }
			}
			
		}
		
		
		
		// 결과는 만약 큐에 넣은것이 n이 되었다는 것은 모두 제거 할수 있다는 뜻이다.
		if(n == list.size()) {
			return true;
		}
		
		// 반대로 n이 아니면 모든 폭탄이 왔다가지 않으므로 제거 할수 없음을 의미
		
		
		
		
		return false;
	}

}

class Bomb{
	// 인덱스
	int index;
	// count : 내가 폭발시키는 갯수
	private int count;
	// 나와 관련된 부모 배열
	private ArrayList<Bomb> ParentBomblist;
	
	public Bomb(int index) {
		this.index = index;
		this.count = 0;
		this.ParentBomblist = new ArrayList<>();
	}
	// private 변수인 count를 가져올 public 메서드
	public int getCount() {
		return count;
	}
	// private 변수인 부모배열 가져 오기
	public ArrayList<Bomb> getParentBomblist(){
		// 나의 부모 배열은 
		return this.ParentBomblist; 
	}
	
	// 연결 작업(단방향)
	public void addParnet(Bomb b) {
		this.ParentBomblist.add(b); // 해당 폭탄객체의 부모배열을 채워넣기
		b.count++; // 부모가 추가되니 b입장에서는 폭발시킬 갯수가 1개 증가했다.
		
	}
	
	public void remove() {
		for(int i = 0; i<ParentBomblist.size(); i++) {
			ParentBomblist.get(i).count--;
		}
	}
}