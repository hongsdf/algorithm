package datastructure;

import java.util.LinkedList;
import java.util.Queue;

class aq{
	int Front;
	int rear;
	int capacity;
	int[] temp;
	
	aq(int capacity){
		this.Front = -1;
		this.rear  = -1;
		this.capacity = capacity;
		temp = new int[capacity];
	}
	
	boolean full() {
		// 가득 있는 경
		return rear == capacity -1; // true :가득차 있음, false :가득차지 않음
	}
	boolean emptyis() {
		if(rear == Front) {
			Front = -1;
			rear  = -1;
			
		}
		return this.rear == this.Front;
	}
	//큐에 데이터를 집어넣는 함수
	public void enqueue(int element) {
		if(full()) { // 꽉차면 채울수 없다
			System.out.println("Queue is Full!");
			return; // 바로 종료
		}
		// 남은 공간이 있다면
		rear = (rear+1) % this.capacity; // (rear + 1)  % 수용량 => 0번 부터 9까지 채우기 
//		+1을 하는 이유 인덱스는 0번부터 시작해서
		temp[rear] = element;
	}
	// 큐에서 데이터를 빼는 작업
	public Object dequeue() {
		if(emptyis()) {
			System.out.println("Queue is empty");
			return null;
		}
		// 첫번재 데이터 추출
		Front = (Front+1) % this.capacity;
		return temp[Front];
	}
	// 큐의 peek()
	public Object peek() {
		if(emptyis()) {
			System.out.println("Queue is empty");
			return null;
		}
		
		return temp[Front+1];
	}
	// 데이터 빼내는 방법2
	public Object Remove() {
		if(emptyis()) {
			System.out.println("Queue is empty");
			return null;
		}
		Front = Front+1 % capacity;
		return temp[Front];
	}
	public int size() {
		
		return Math.abs((rear+1) - (Front+1 ) ); // 데이터를 넣을 수록 rear가 더 크게 된다
	}
	public void clear() {
		if(emptyis()) {
			System.out.println("이미 비워저 있다");
		}else {
			Front = -1; // 출발지점 초기화
			rear  = -1; // 끝점 초기화
			temp = new int[capacity]; //원본크기랑 같은 임시배열 초기화
			System.out.println("clear");
		}
	}
    
}


public class Queue2 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
	}
}
