package algorithm;

import java.util.Scanner;

public class No3 {
//최빈수 구하기
	/* 핵심 주요 요점
	 * 각 자리수를 인정을 하여 활용하려면 배열(자료구조) 에 따로 저장
	 * 1.mode[arr[i]]++ 이중배열
	 *  1 1 0
	 * arr[0] == 1 , arr[1] == 1, arr[2] == 0
	 * mode[arr[0]]++ => mode[1] == 0 -> 1
	 * mode[arr[1]]++ => mode[1] == 1+1 --> 2
	 * mode[arr[2]]++ => mode[0] == 0-> 1
	 * 
	 * mode를 1~9 숫자 for문을 돌려 if문을 활용하여 검증
	 * 
	 * 
	 * */
	public static void main(String args[]) {
//		1 1 2 0 1
//		1 : 3 (최빈수)
//		2 : 1
//		0 : 1
		Scanner sc = new Scanner(System.in);
		
		int arr[]  = new int[10];
		for(int i = 0 ; i<10; ++i) { // index[0] ~ index[9] : 10공간
			arr[i] = sc.nextInt();
			
		}
		
		int mode[] = new int[10];
		
		// mode[i] == 3
		
//		 1 2 1 1 2 3 4 1 1 4
//		mode[1] == 5
//		mode[2] == 2
//		mode[3] == 1
//		mode[4] == 2
		for(int i = 0; i <arr.length; i++) {
			mode[arr[i]]++; // arr[i] : 각 자리의 숫자를 인정해주는것 => mode[arr[i]]++ 숫자가 1씩 증가식

//			System.out.println(arr[i]+"의 숫자의 등장 횟수"+mode[arr[i]]);
		}
		
		int modeCnt = 0 ; //횟수
		int Num = 0 ; //최빈수

		for(int i = 0 ; i < 10; i++){
			if(modeCnt < mode[i]) { // 0 < 0의 등장횟수(0)
				Num = i; 
				modeCnt = mode[i];
				
			}
		}
		System.out.println("최빈수 : "+Num +"등장횟수 :"+modeCnt);
		
		

	}
}
