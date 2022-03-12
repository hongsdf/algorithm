package backjun;

import java.util.Scanner;

public class Back4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //ÄÉÀÌ½º
		for(int i = 0; i<n; i++) {
			int v = sc.nextInt();
			int array[] = new int[v];
			int total = 0;
			for(int j = 0; j<v;j++) {
				array[j] = sc.nextInt();
				total += array[j];

			}
			int avg =  total/v;
//			System.out.println(avg);
			int cnt = 0;
			for(int z = 0; z <array.length; z++) {
				
				if(array[z] > avg) {
					
					cnt++;
						
				}
			} // 2 / 5
			double sum = (double)cnt/array.length *100;
//			System.out.println(array.length);
//			System.out.println(cnt);
 			System.out.printf("%.3f",sum);
			System.out.println("%");  
			
			
		}

	}
}
