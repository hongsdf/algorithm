package Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Stringcomparemethod1 {
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			int ans[] = new int[4];
			for(char c : s.toCharArray()) {
				if(c >= 'A' && c <= 'Z') {
					ans[1]++;
				}else if(c >= 'a' && c <= 'z' ) {
					ans[0]++;
				}else if(c == ' ') {
					ans[3]++;
				}else if( c -'0' >= 0 && c -'0' <= 9) {
					ans[2]++;
				}
			}
			for(int i = 0; i <4; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}
	}
}
