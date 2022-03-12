package datastructure;

import java.util.*;
import java.util.Scanner;
public class DataStructure_1D_Array {
	
	// Queue : 탐색 할때 사용  중복가능 --> 원본과 같은 복사본을 만들어 중복을 방지한다.
	// 보통(while문을 사용) *처음에 q에 값 하나이상은 존재해야함  *while(!q.isEmpty()){ }
	// q안에 원소가 움직인다. 한개씩
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			int a = sc.nextInt(); //배열크기
			int leap = sc.nextInt(); //점프 크기
			int game[] = new int[a]; //원본
			boolean visited[] = new boolean[a]; //복사본 생성
			for(int i =0; i< game.length;i++) {
				game[i] = sc.nextInt();
				visited[i] = false;
			}
			// 진행
			visited[0] = true;
			boolean flag = false;
			Queue<Integer> q = new LinkedList<>(); // queue는 LinkedList로 선언해야함
//			q.offer(null) //queue에 자료 추가 방법 1.add(), 2.offer() --> 성공시 true반환, 실패시 IllegalStateException을 발생 : 메모리 공간 부족
			q.add(0); //     0  1  0       
					  //    
//			6 3             2 2
//			0 0 1 1 1 0     0 0
//          T T F F F F
			while(!q.isEmpty()){
				int v = q.poll(); // poll() : 첫번째 값을 반환하고 제거
				//queue.peek() : 첫번째 값 참조(기준은 무조건 첫번째)
				if(v+1 >= a || v+leap>= a){ //만약 앞으로한칸 || 점프칸햇을때 목표위치(a)배열에 도착하면 해석 ==> 현재 위치에서 앞으로 한칸 || 점프 해도 범위 인정내  있는 값
					flag = true;
					break; // 여기서 while문이 종료
				}
				if(v-1 >= 0 && !visited[v-1] &&	game[v-1] == 0 ){ // 뒤로 가는 경우(단,뒷칸은 == 0 , 방문 하지 않은칸 && visited[] 범위를 벗어나면 안됨
					visited[v-1] = true;
					q.add(v-1);
				}
				if(v+1 < a && !visited[v+1] && game[v+1] == 0){ // 앞으로 가는 경우(단,visited[] 범위내 , 방문하지 않고 앞칸
					visited[v+1] = true;
					q.add(v+1);
				}
				if(v+leap < a && !visited[v+leap] && game[v+leap] == 0){ // 점프하는 경우
					visited[v+leap] = true;
					q.add(v+leap);
				}
			}
			System.out.println(flag ? "YES" : "NO");
			
		}
		
		
	}
}

