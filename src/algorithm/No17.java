package algorithm;

public class No17 {
	public static void main(String[] args) {
		for(int i = 0; i<5; i++) {
			for(int j = 5; j > i  ; j--) {
				System.out.print("*"); // 0За + 5 ,1За : 4 , 2За :3
			}
			System.out.println();
		}
	}
}
