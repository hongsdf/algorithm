package primenumberSearch;

import java.io.BufferedReader;

public class are {
	public static void main(String[] args) {
		int n =97 ;
		boolean flag = prime2(n);
		System.out.println(flag);
		int Num = 10000;
		int arr[] = new int[Num+1];
		for(int i =1; i<arr.length; i++) {
			arr[i] = i;
		}
		for(int i=1; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		method(arr,Num);
		System.out.println();
		for(int i=1; i<arr.length; i++) {
			if(arr[i] !=0)
			System.out.print(arr[i] + " ");
		}
	}	
	// 한번에 여러개의 소수들을 판당 할때 사용
	private static void method(int[] arr, int Num ) {
		for(int i =2; i <=Num; i++) {
			if(arr[i] == 0) continue; //여기다 적는 것이랑 밑에서 적는 것이랑 시간 차이가 난다.  여기서 적으면 2의 배수는,3의배수는 이런씩으로 한번에 continue
			for(int j = i+i; j <=Num; j+= i) { // 2: 4 6 8 12... 3: 6 9 12 ....
//				if(arr[j] == 0) continue; // 만약 지운값이 있으면 continue;
				// 여기다 적으면 일일이 실행할때마다 continue를 해야함
				arr[j] = 0; //아니면 지우기
			}

		}
		
	}
	// 이게 가능한 이유 :
	// ex) 8 = 1 * 8 , 2 *4 약수가 이렇게 존재한다
	// 만약  2 * 4 == 4 * 2 는 같으므로 2를 찾았다면 다음  4 * (2) 에서의 2를 볼 필요 없다(이미 앞에서 걸렀기 때문에)
	// 시간 복잡도 o(n/2) : 기존보다 절반
	private static boolean prime2(int n) {
		for(int i=2; i<=(int)Math.sqrt(n); i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	// 대표적인 소수 판별 시간 복잡도 o(N) : n까지 확인 해야한다
	private static boolean prime(int n) {
		for(int i=2; i<n; i++) {
			if(n %i ==0) return false;	
		}
		return true;
	}
	// 에라토스체
	
	
}
