package datastructure;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Array2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i < n; i++) {
			int d = sc.nextInt();
			ArrayList<Integer> arry = new ArrayList<>(d); 
				for(int j =0;j<d; j++) {
					int value = sc.nextInt();
					arry.add(value);
			}
			list.add(arry);
			}
		
			int q = sc.nextInt(); // 3
			for(int i=0; i<q; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
		
			try{
				System.out.println(list.get(x-1).get(y-1));
			}catch(IndexOutOfBoundsException e) {
			
				System.out.println("Error!");
			}
		}
			
	}
}
