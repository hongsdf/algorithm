package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1152_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* The Curious Case of Benjamin Button  : 6*/
//		String str1 = br.readLine();
		int pre =32;
		int cnt =0;
		int str;
		
		while(true) {
			str = System.in.read();
            
			// 입력받은 문자가 공백일 때,
			if(str == 32) {
				// 이전의 문자가 공백이 아니면
				if(pre != 32) cnt++;
			}
 
			// 줄 바꿈을 했을때 (마지막 입력후 엔터시 cnt++)
			else if(str == 10) {
				// 이전의 문자가 공백이 아니면
				if(pre != 32) cnt++;
				break;
			}
			
			pre = str;
			
		}
		System.out.println(cnt);
		
		
		
		
		
		
		
		
		
		
//		
//		for(int i = 0; i < str.length(); i++) {
//			
//			if(str.charAt(i) == 32) {
//				if(pre != 32) {
//					cnt++;
//				}
//			}
//			else if(str.charAt(i) == 10) {
//				if(pre != 32) 
//					cnt++;
//				
//				break;
//			}
//			pre = str.charAt(i); // pre : T,h,e
//		}
//		System.out.println(cnt);
		
		
	}
}
