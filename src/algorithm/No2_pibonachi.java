package algorithm;

public class No2_pibonachi {
//   1 1 2 3 5 8 ..
	public static void main(String[] args) {
		int arr[] = new int[10]; // 0 0 0 0 0 0 0 0 0 0 0 0 0 
		
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
//		arr[3] = 2;
//		arr[4] = 3;
//		arr[5] = 5;
		
//		arr[1] + arr[2] = arr[3] == 2;
//		arr[i-2] + arr[i-1] = arr[i];
//		An = An1+ An2 
//  	An1 = 1 , An2 = 1 초기화 상태
//		첫번째 방법
		System.out.print(arr[1] + " ");
		for(int i = 2 ; i< arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-1]; 

			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
//		 2번째
		int prevNum = 1; // 1번째 
		int prevNum2 = 1; // 2번째
		
		
		System.out.print(prevNum+" "); // 1번째 고정
		System.out.print(prevNum2+ " "); // 2번째 고정
		for(int i =3; i <= 10; i++) { // 반복횟수만 반복
			int Num = prevNum + prevNum2; // Num :현재 숫자 

			System.out.print(Num+" ");
			prevNum2 = prevNum; // 이전숫자가 => 이이전으로
			prevNum = Num; // 현재 숫자가 =>이전
		
			
			
			
			
		}
		
		
	}
}
