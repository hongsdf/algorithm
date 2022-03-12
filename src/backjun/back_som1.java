package backjun;

import java.util.Scanner;

public class back_som1 {
	public static void main(String[] args) {
		// 1 666
		// 2 1666
		// 3 2666
		// 4 3666
		// 5 4666
		// 6 5666
		// 7 6660
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 666;
		int count = 1;
		while(count != n) {
			num++; // 핵심 count는 if절에 해당하지않으면 무한 루프로 돈다. num = 666 에서 ++ 되면 667이된다 --> 다음 666이 포함된 숫자는 1666이다 666,667,668,669,670,671....1000 ...1660,..1665,1666
			String s = String.valueOf(num);
			
			if(s.contains("666")) {
				count++; // (666) 것이 포함되어있으면 다음 것을 찾아라.
			}
		}
		System.out.println(num);
		sc.close();
	}
}
