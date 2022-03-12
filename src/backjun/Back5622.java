package backjun;

import java.util.Scanner;

public class Back5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
//		ABC = 1
//		DEF = 2
//		GHI = 3
//		JKL = 4
//		MNO = 5
//		PQRS = 6
//		TUV = 7
//		WXYZ = 8
		int time = 0;
		for(int i=0; i<str.length();i++) {
			char s = str.charAt(i);
			if(s == 'A' || s == 'B'|| s =='C') {
				time +=3;
			}
			else if(s == 'D' || s == 'E'|| s=='F') {
				time +=4;
			}
			else if(s == 'G' || s == 'H'|| s=='I') {
				time +=5;
			}
			if(s == 'J' || s == 'K'|| s=='L') {
				time +=6;
			}
			if(s == 'M' || s == 'N'|| s=='O') {
				time +=7;
			}
			if(s == 'P' ||s == 'Q' || s == 'R'|| s=='S') {
				time +=8;
			}
			if(s == 'T' || s == 'U'|| s=='V') {
				time +=9;
			}
			if(s == 'W' ||s == 'X' || s == 'Y'|| s=='Z') {
				time +=10;
			}
		}
		
		System.out.println(time);	
	
	}
	
}
