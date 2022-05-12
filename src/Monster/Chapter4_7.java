package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Chapter4_7 {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_VALUE = 1000000;
	public static final Sieve1 sieve = new Sieve1(MAX_VALUE);

	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void testCase(int caseIndex) {
		int x = scanner.nextInt();

		int a = -1;
		int b = -1;
		
		for(int i = 3; i<= x/2; i+=2){ // 홀수만 찾아야한다.
			int p = x - i;
			if(sieve.isPrime[p] == true && sieve.isPrime[i] == true){
				a = i;
				b = p;
				break;
			}
		}
		
		
		// 정답을 출력한다
		System.out.printf("Case #%d:\n", caseIndex);
		if(a > 0 && b > 0)
		{
			System.out.printf("%d = %d + %d\n", x, a, b);
		}else{
			System.out.println(-1);
		}
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}
}
class Sieve1{
	// 소수 배열
	boolean isPrime[];
	int size;
	
	public Sieve1(int size){
		this.size = size;
		this.isPrime = new boolean[size+1];
		// 에라토스네체 채우는 함수
		this.fillprime();
	}
	
	public void fillprime(){
		// 전체 배열을 true로 초기화
		Arrays.fill(isPrime,true);
		// 1은 소수가 아니므로 예외처리
		isPrime[1]=false;
		// 2~ n-1까지 순차적으로 순회하며 소수 판단
		for(int i = 2; i <= size; i+=1){
			if(isPrime[i] == false){
				continue;
			}
			for(int j = i+i; j<=size; j+=i ){
				isPrime[j] = false;
			}
		}
		// 해당 수의 멱수로 진행하며 제거
		
	}
	
	
}