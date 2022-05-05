package Monster;

import java.util.Scanner;

public class sotogu {
	public static void main(String[] args) {
		// Native
		int board[][] = new int[10][10];
		int num = 1;
		for(int i = 1; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				board[i][j] = num++;
			}
		}
		
		for(int i = 1; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 5
		solution(board,n);
	}

	private static void solution(int[][] board, int n) {
		int row = 0; int col = 0; int group = 0;
		
		for(int i = 1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(board[i][j] == n) {
					row = i; //За 
					col = j; //ї­
					
				}
			}
		}
		
	}
}
