package algorithm;

public class No4 {
// 2진수 ->2진수로
	public static void main(String[] args) {
		int in = 25;
//		25/2 == 12 ...1
//		12/2 == 6 ...0
//		6/2 == 3...0
//		3/2 == 1 ...1
//		1/2 == 0 ...1 == 11001 == 16+8+1
		
		int arr[] = new int[5];
		int i =0;
		
		int mok = in;
		
		while(mok !=0 ) {
			arr[i] = mok%2;
			mok = mok/2;
//			System.out.println(i +"출력"+arr[i]);
			i++; 
		}
		
		i--; // 하는이유 :  mok == 0 이 되고 증가씩이 한번더 실행이 된다 그래서 다시 1감소시켜 진행한다
//		6 == 110
//		6/2 == 3 ...0
//		3/2 == 1...1
//		1/2 == 0...1		
		
		// 반대로 출력
		for(; i>=0; i--) {
			System.out.print(arr[i]);
		}
		
		
		
	}
}
