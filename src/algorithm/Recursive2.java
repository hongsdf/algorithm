package algorithm;

import java.util.Scanner;

public class Recursive2 {
	
	static int N;
	static int arr[][] = new int[100][100];
	static int row,col,Sr,Sc;
	
	
	static void flood(int Sr,int Sc) {
		//  Àç±ÍÇÔ¼ö
		if(Sr < 0 || Sr > N-1 || Sc < 0 || Sc > N-1 ) return;
		
		if(arr[Sr][Sc] != 0) return;
		
		arr[Sr][Sc] = 1;
		
	
		flood(Sr-1,Sc);
		flood(Sr+1,Sc);
		flood(Sr,Sc-1);
		flood(Sr,Sc+1);
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j <N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int Sr = sc.nextInt();
		int Sc = sc.nextInt();
		flood(Sr,Sc);
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j <N; j++) {
				System.out.print(arr[i][j]+" ");
		}
			System.out.println();
	}
		// 5
		// 0 0 0 0 0
		// 2 2 0 0 0
		// 0 0 0 2 2
		// 0 0 2 0 0
		// 2 2 2 0 0
		
		
		
		
		
	}
}
