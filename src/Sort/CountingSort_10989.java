package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingSort_10989 {
	public static int temp[] = new int[10000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Case = Integer.parseInt(br.readLine());
		int arr[] = new int[Case];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0;i<arr.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		for(int i = 0;i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		for(int i = 0;i<temp.length; i++) {
			temp[i] = 0;
		}
		
		for(int i=0; i <arr.length; i++) {
			temp[arr[i] - 1]++;
		}
		
		for(int i=0; i<temp.length; i++) {
			if(temp[i] != 0) {
				for(int j =0; j < temp[i]; j++) {
//					System.out.println(i+1);
					sb.append(i+1).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
