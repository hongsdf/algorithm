package algorithm;

public class No21 {

	public static void main(String[] args) {
		int n = 337855555;
		int b[] = new int[10]; // 저장소
		int mode[] = new int[10];
		
		
		while(n > 0) {
			int i = n%10; // 3 2  1
			n /=10; // 123 , 12 ,1 
			mode[i]++; // 3 : 1 + 1 2 :1 1 1
		}
		
		// 3 : 2
		// 2 : 1
		// 1 : 1
		
		
		// review 필요
		for(int j =0; j<=9; j++) {
			if(mode[j] > 0) {
				b[j] = j;
				System.out.print(b[j] + " ");

//				System.out.println(j + "의 등장횟수"+mode[j]);
			}
		}

		
		

	}


}
