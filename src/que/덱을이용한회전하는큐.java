package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * LinkedList<Integer> deque = new LinkedList<>(); 덱구현
 * 덱을 구현하면
 * q와 다르게
 * pollfirst(): 맨앞 추출
 * pollLast():맨뒤 추출
 * addFirst():맨앞추가
 * addLast():맨뒤 추가
 * peekFirst() :맨 앞원소 확인
 * peekLast():맨뒤 원소 확인
 * 
 */
public class 덱을이용한회전하는큐 {
	static List<Integer> list = new ArrayList<>();
	static LinkedList<Integer> deque = new LinkedList<>(); // 덱 구현
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		// 찾고자 하는 값 리스트
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i <M; i++) {
			list.add(Integer.parseInt(str1[i] ));
		}
		// 큐 주입
		for(int i = 1; i <=N;i++) {
			deque.add(i);
		}
		int la = deque.peekLast();
		System.out.println(la);
		
		
		solve();
		System.out.println(cnt);
//		deque.pollFirst(); // 맨앞의 수 추출
//		deque.pollLast(); // 맨 뒤 수 추출
		
		
	}
	private static void solve() {
			
		
		for(int i = 0; i <list.size(); i++) {
			int findNum = list.get(i);
			int findindex = deque.indexOf(findNum); //찾고자하는 인덱스 위치
			
			// 중간지점 측정
			// deque의 길이가 짝수
			int midindex = 0;
			if(deque.size()%2 == 0) {
				midindex = deque.size()/2 - 1;
			}else {
			// 홀수
				midindex = deque.size()/2;
			}
			
			// findindex가 midindex보다 앞에 있다면
			if(findindex <= midindex) {
				while(true) {
					int num = deque.pollFirst();
					if(num == findNum) {
						break; //찾았다면 종료
					}else {
						cnt++;
						deque.addLast(num);// 맨뒤에 추가 한다.
					}
					
				}
				
			}else { // findindex가 midindex보다 뒤에 있다면
				
				while(true) {
					int num = deque.pollLast();
					if(num == findNum) {
						cnt++;
						break;
					}else {
						cnt++;
						deque.addFirst(num); //맨앞에 추가한다.
					}
				}
				
			}
			
			
		}
		
	}
}
