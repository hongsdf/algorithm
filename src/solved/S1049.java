package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int group = 1001;
		int ge = 1001;
		// 최소값 group값, 낱개 최소값 ge 찾는 것이 핵심이다. 
		for(int i = 0; i <M; i++) {
			token = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			if(a  < group) group = a;
			if(b < ge) ge = b;
		}
		int sum = 0;
		while(true) {
			if(N <= 0 ) break;
			if(N < 6) {
				if(group < (ge * N)) {
					sum += group;
					N = 0;
					
				}else {
					sum += (ge * N);
					N = 0;
				}
			}else {
				if( group  < (ge * 6)) {
					N -=6;
					sum += group; //묶음 가격
				}else {
					N -=6;
					sum += (ge*6); //낱개 가격 추가
				}
			}
	
		}
		System.out.println(sum);	
		
	}
}
