package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class FourCard {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * 중복을 포함해 네 카드의 합으로 만들 수 있는 당첨번호들의 리스트를 반환하는 함수
	 * @param n     카드의 수
	 * @param m     검사하려는 당첨번호의 수
	 * @param cards   각 카드에 적힌 숫자들
	 * @param target  검사하려는 각 당첨번호 리스트
	 * @return      네 카드의 합으로 표현될 수 있는 당첨번호들의 오름차순 리스트
	 */
	
	/*
	 * 문제 원리
	 * 두카드와 세카드 문제 풀이 :=   target값 k에서 - (a +b ) 값을 빼고 난 값을 x라고 하자
	 * 그러면 cards배열에서 탐색하여 x가 있으면 k를 만들수 있고, 없으면 만들지 못한다.
	 * 
	 * 탐색할때
	 * binarySearch(정렬된 배열 , 찾고하는 값) >= 0 := 갑이 존재
	 * < 0 : =찾고자 하는 값이 없음
	 * 1.입력값으로 정렬된 배열, 찾고자하는 값
	 * 2.출력값 := 인덱스위치 반환
	 * 3.시간 복잡도 ( o(log2n))
	 * 
	 * 하지만 네카드 문제는 시간복잡도가 o(n^3)이므로 시간초과가 발생한다.
	 * 그래서
	 * 2카드씩 묶어서 개산하면
	 * S = (a+b)  + (c+d) : 2쌍을 2개의 카드로 치환하여 계산 함
	 * 
	 * 구현
	 * 1.2카드를 한쌍을 묶는 방법
	 * 
	 * 
	 * 2.target배열에서 쌍들에대한 반대 값이 존재 하면
	 * 찾은 것
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
		
		
		 
	
	
	
	
	public static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target)
	{
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		ArrayList<Pair> list = new ArrayList<>(); //  두카드를 묶는 가변배열 생성(=한쌍)
		for(int a : cards ) {
			for(int b : cards) {
				list.add(new Pair(a,b));
			}
		}
		Collections.sort(list);
		
		for(int t : target) {
			boolean flag = false;
			for(Pair p : list) {
				int x = t - p.sum; // 반대쪽 한쌍을 찾음(안의 원소값 중요 X ,합이 중요)
				Pair pairs = new Pair(x); // 매개변수 한개  한쌍에 대한 정보(=합만 중요)
				if(Collections.binarySearch(list, pairs) >= 0) {
					flag = true; // 타겟값을 발견했다.
					break;
				}
			}
			if(flag) {
				answer.add(t);
			}
		}
		Collections.sort(answer);
		
		return answer;
		
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();  // 카드의 수
		int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

		int[] cards = new int[n];
		int[] targets = new int[m];

		// 각 카드 정보를 입력받는다
		for(int i = 0 ; i < n ; i ++)
		{
			cards[i] = scanner.nextInt();
		}

		// 각 당첨번호를 입력받는다
		for(int i = 0 ; i < m ; i ++)
		{
			targets[i] = scanner.nextInt();
		}

		ArrayList<Integer> answers = getPossibleTargets(n, m, cards, targets);


		if(answers.size() == 0)
		{ // 가능한 당첨번호가 없다면 NO를 출력한다
			System.out.print("NO");
		}else
		{ //가능한 당첨번호가 존재한다면 그 목록을 출력한다.
			for(int i = 0 ; i < answers.size() ; i++)
			{
				if( i > 0 )
				{
					System.out.print(" ");
				}
				System.out.print(answers.get(i));
			}
		}
	}
}
//1. 카드를 묶는 클래스 생성
	class Pair implements Comparable<Pair>{
		int card1; // 카드 1
		int card2; // 카드 2
		int sum; // 카드1 + 카드2 합
		
		public Pair(int card1,int card2){
		 this.card1 = card1;
		 this.card2 = card2;
		 this.sum = this.card1 + this.card2; // 보류
		}
		// 매개변수 하나
		public Pair(int sum) {
			this.sum = sum;
		}

		@Override
		public int compareTo(Pair o) {
			
			return this.sum - o.sum;
		}
		
	}







