package backjun;

import java.util.Scanner;
public class Back1712 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt(); // 70
		int C = sc.nextInt(); //170
		if(C > B) {
			int cnt = A/(C-B);
			System.out.println(++cnt);
		}else {
			System.out.println(-1);
		}
		
	}
}
