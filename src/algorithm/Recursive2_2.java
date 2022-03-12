package algorithm;

import java.util.Scanner;

public class Recursive2_2 {

	static int Row,Col,Sr,Sc;
	static int arr[][] = new int[100][100];
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Row = sc.nextInt();
		Col = sc.nextInt();
		for(int i=0; i<Row ; i++) {
			for(int j = 0; j <Col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		Sr = sc.nextInt(); Sc = sc.nextInt();
		fill(Sr,Sc);
		for(int i=0; i<Row ; i++) {
			for(int j = 0; j <Col; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}



	 static void fill(int sr, int sc) {
		if(sr < 0 || sr > Row-1 || sc < 0 || sc > Col-1) return;
		
		if(arr[sr][sc] != 0) return;
		
		arr[sr][sc] = 1;
		
		fill(sr-1,sc); //╩С
		fill(sr+1,sc); //го
		fill(sr,sc-1); //аб
		fill(sr,sc+1); //©Л
		
		
		
	}

}
