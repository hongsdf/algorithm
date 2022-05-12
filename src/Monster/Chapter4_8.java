package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Chapter4_8 {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_VALUE = 1000000;


	/**
	 * 게임의 규칙을 만족하면서 만들 수 있는 가장 큰 최대공약수를 반환하는 함수
	 *
	 * @param n         주어진 카드의 수
	 * @param cards     각 카드에 적힌 숫자 배열
	 * @return
	 */
	public static int getMaximumGCD(int n, int[] cards)
	{
			int answer = 1;
			// 빈도수 배열
			int freq[] = new int[MAX_VALUE+1] ;
			// n개를 각 소인수 분해
		for(int c : cards){
			ArrayList<Long> list = MathUtil2.factorize(c);
			for(long num : list){
				freq[(int)num]+=1;
			}
		}
		// 빈도수 배열을 탐색하며 균등 분배
		for(int i = 2; i<=MAX_VALUE ; i+=1){
			if(freq[i] == 0){
				continue;
			}
			int cnt = freq[i]/n;
			answer *= MathUtil2.powInt(i,cnt);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] cards = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			cards[i] = scanner.nextInt();
		}

		int answer = getMaximumGCD(n, cards);

		System.out.println(answer);
	}

}

class MathUtil2{
	/**
	 *
	 * @param N
	 * @return
	 */
	public static ArrayList<Long> factorize(long N) // 최몇
	{
		
		ArrayList<Long> factorlist = new ArrayList<>();
		// N을 소인수 분해
		for(long i = 2; i * i <= N; i+=1){
			while(N % i == 0){
				factorlist.add(i);
				N/=i;
			}
		}
		if(N > 1){
			factorlist.add(N);
		}
		return factorlist;
	
	}


	/**
	 * 두 정수 a, n에 대해 a ^ n을 계산해주는 함수
	 *
	 * @param a
	 * @param n
	 * @return
	 */
	public static int powInt(int a, int n)
	{
//		double answer = Math.pow(a,n);
//		return (int)answer ;
		
		// Native
		
		int answer = 1;
		for(int i = 1; i<=n; i++) {
			answer *= a;	
		}
		return answer;
	}
}



