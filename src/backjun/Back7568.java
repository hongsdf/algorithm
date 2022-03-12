package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class Back7568 {

	public static void main(String[] args) throws Exception, NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		
//		int  n = sc.nextInt();
		int [][] arr = new int [n][2];
		int rankList[] = new int[n];
		

//			for(int j =0; j<n; j++) {
//				arr[j][0] = sc.nextInt();
//				arr[j][1] = sc.nextInt() ;
//			}
			
			for(int i =0; i<arr.length; i++) {
				for(int j =0; j<arr[i].length;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			

		
		for(int i =0; i <arr.length; i++) {
			int rank =1;
			for(int j =0; j<arr.length; j++) { 
				if(i == j ) continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
				rankList[i] = rank; // 3 1 1
			}
			
		}
		
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.print(rankList[i] +" ");
			System.out.println();
		}
		
	}
}
