package Groom;

import java.io.*;

public class 게임 {
	public static void main(String[] args) throws Exception {
		// 입력층
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 5;
		while(T --> 0){
		String input = br.readLine();
		// 구현 층
		// K의 홀수 번째 숫자들을 모두 합한 값을 라고 한다 => a
		// a * k의집합에서  0이아닌 짝수 번째 숫자를 모두 곱한다. 
		// [1,2,3,4,5]
		// 1 2 1 2 1 2 1
		
		 char c[] = input.toCharArray();
		 long a = 0; long b = 1;
		for(int i = 0; i<c.length; i++){
			 if(i == 0 || i%2 == 0){
				 a+= c[i] -'0';
			 }
			 
		 }
		for(int i = 0; i<c.length; i++){
			 if(i%2==1 && (c[i]-'0') != 0 && (c[i]-'0')%2==0){
				 b*= c[i] -'0';
			 }
			 
		 }
			
		if(b == 1) b = 1;	
		long answer = (a * b)%10;
		
		System.out.println(answer);
		
		
		}
	}
}