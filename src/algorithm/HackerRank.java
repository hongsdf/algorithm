package algorithm;

import java.util.Scanner;
 
public class HackerRank {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int arr[][] = new int[6][6];
	        for(int i = 0; i<arr.length; i++){
	            for(int j = 0; j<arr.length; j++){
	                arr[i][j] = sc.nextInt();
	            }
	            System.out.println();
	        }
	    //  if ((arr_j + 2) < 6 && (arr_i + 2) < 6) {
//	    for(int i = 0; i<arr.length; i++){
//            for(int j = 0; j<arr.length; j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
	    int max = -1;
	    for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                if((i+2)< 6 && (j+2) <6 ) {
                	if(max <
                	arr[i][j]+arr[i][j+1]+arr[i][j+2]+
                	arr[i+1][j+1]
                	+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]) 
                	{
                	max = arr[i][j]+arr[i][j+1]+arr[i][j+2]+
                           arr[i+1][j+1]
                           +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                	}
                }
            }
        }
	    System.out.println(max);
    }

	    
	
}
