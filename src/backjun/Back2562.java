package backjun;
import java.util.*;
public class Back2562 {
	public static void main(String[] args) {
		/*
		3
		29
		38
		12
		57
		74
		40
		85
		61
		*/
		Scanner sc = new Scanner(System.in);
		
		int arr[] =new int[9];
		int max = 0;
		int num =0;
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				num = i+1;
			}
			
		}
		System.out.println(max+ " "+ num);
		
		
		
		
	}
}
