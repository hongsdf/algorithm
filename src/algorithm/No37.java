package algorithm;

import java.util.Scanner;

public class No37 {
	
	static int[] arr = new int[10000];
	
	// arr[2] = 1
	// arr[3] = 1
	// arr[4] = /2 + /2 = 2
	//		  = -1 + /3 = 2
	// arr[5] = -1 + /2 + /2 = 3
	//      =  -1  + /3 + -1 = 3
	// arr[6] = /3 + /3 = 2
	
	
	
	
	
	
	public static void main(String[] args) {
		arr[2] = 1; //arr[2] 를 1로 바꾸는 최소의 경의수는 1
		arr[3] = 1; //arr[3] 를 1로 바꾸는 최소의 경의수는 1
		/*주요 요점정리*/
		// DP개념 동기화: 동기화란? 여러가지 경우의수를 동시에 할수 있다
		// 예를 들어 6은 2로 나눌수도 있고 3으로도 나눌수있다
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 10
		for(int i = 4; i < 10000; i++) {
			int a =999; int b =999; int c =999; // a,b,c를 큰수 설정이유 : w == (1,2,3)작업중 변환이 되면
			// a,b,c 중 한개이상은 갱신이 된다
			// 그래서 
			// arr[i] = ?
			for(int w = 1; w <= 3; w++) { // 방법 3가지
			if(w == 1) { // 1빼는 작업
				 a = arr[i-1]; // arr[3] = 1 -> a = 1 arr[4] = 2 -> a = 2
			}else if( w == 2) { // arr[2] = 1 -> b = 1 b= 999;
				if(i%2 == 0) {
					b = arr[i/2];
				}
			}else if(w==3) { // c =999;
				if(i%3 == 0) {
					c = arr[i/3];
				}
			}

		}
			int answer = min(a,b,c);
			arr[i] = 1 + answer; // 여기까지 작업은 arr[1], arr[2] , arr[3] ...arr[543] 경우의수 를 담는다
		}
		System.out.println(arr[n]); // 출력하고 싶은 arr[n]을 출력한다
		
		// 1 3의 배수이면 3으로 나눈다
		// 2 2의 배수이면 2로 나눈다
		// 3 1을 뺀다
		
		// 2 : 10/2  = 5
        // 3  5-1 = 4
		// 2  4/2 =2
		
		// 3 9 1 3 1 1
		
	}

	private static int min(int a, int b, int c) {
		int answer = 0;
		if(a > b) {
			if( b > c) 
				 answer = c;
			else 
				 answer = b;
			
		}else { // b > a 
			if(a > c) answer = c;
			else answer = a;
		}
		return answer;
	}
}
		
	

