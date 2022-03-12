package algorithm;

public class No16 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <i+1; j++) { 
				System.out.print("*"); // 青 + 1 
				// 0青 : 1
				// 1青 : 2
				// 2青 : 3
				// 3青 : 4
				// 4青 : 5
			}
			System.out.println("");
		}
	}
}
