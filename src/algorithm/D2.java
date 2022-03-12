package algorithm;

import java.util.Scanner;

public class D2 {

	static void array(int sr, int sc, int[][] arr){
		if(arr[sr][sc] != 0) return;
		
		
		arr[sr][sc] =1;
		   
		for(int i = sr-1; i >=0;i--) {
		    if(arr[i][sc] != 0) break;
		     arr[i][sc] = 1;
		    
		}
		
		for(int i = sr+1; i < arr.length; i++) {
			if(arr[i][sc] != 0) continue; //관통
			
			 arr[i][sc] = 1;
			
			
		}
		
		for(int j = sc-1; j>=0; j--) {
			if(arr[sr][j] != 0) break;
			
			arr[sr][j] =1;
			
			
		}
		
		for(int i = sc+1; i<arr.length; i++) {
			if(arr[sr][i] != 0) break;
			
			 arr[sr][i] =1;
		}

		
		
	}
	
	
	public static void main(String[] args) {
		// 십자가 출력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[10][10];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();	
			}
		}
		int Sr = sc.nextInt(); int Sc = sc.nextInt();
		
		array(Sr,Sc,arr);
		
		 for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");	
				}
			 
			  System.out.println();
		}
		 
		 
	}

}
