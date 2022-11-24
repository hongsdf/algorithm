package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


class command{
	String comm;
	int val;
	command(String comm,int val){
		this.comm = comm;
		this.val = val;
	}
}
  
public class 체크카드 {
	public static void main(String[] args) throws Exception {
		// 모든 거래가 종료된 후 구름이의 계좌에 들어있는 잔액 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int currentMoney = Integer.parseInt(input[0]);// 처음 잔액
		int M = Integer.parseInt(input[1]);//지난달 구름이의 거래 내역
		 
		// 기본입력을 받는 큐 생성
		LinkedList<command> basic = new LinkedList<>();
		// 대기 목록 생성
		LinkedList<command> wait = new LinkedList<>();
		
		// 기본입력 입력받기
		for(int i = 0; i <M; i++){
			String str[] = br.readLine().split(" ");
			String comm = str[0]; //명령어
			int money = Integer.parseInt(str[1]);// 금액
			basic.add(new command(comm,money));
		}
		
		while(!basic.isEmpty()){
			command curr = basic.poll();
			if(curr.comm.equals("deposit")) {
				currentMoney += curr.val;
				// reservation 목록을 바로 처리할수 있다면 바로 처리해야한다.
				while(!wait.isEmpty() && wait.peek().val <= currentMoney) {
					currentMoney -= wait.poll().val;
				
				}
				
				
			}else if(curr.comm.equals("pay")) {
				if(currentMoney >= curr.val )
				currentMoney -= curr.val;
			}else if(curr.comm.equals("reservation")) {
				if(wait.isEmpty() && currentMoney >= curr.val ) { 
					currentMoney -= curr.val;
				}else {
					//currentMoney -= curr.val;
					wait.add(curr);
				}
				
			}
		}
		// 대기 목록 처리
//		while(!wait.isEmpty()) {
//			command curr = wait.pollFirst();
//			if(currentMoney  >= curr.val) {
//				currentMoney -= curr.val;
//			}
//		}
//		
//		System.out.println(currentMoney);
//		
		
	}
}