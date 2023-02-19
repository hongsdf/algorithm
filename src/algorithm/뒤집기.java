package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 그룹화 하는 문제
 * O(N)으로 풀이 N이 100만
 * 기준을 가지고 다른 원소에 대해 기준을 변경해 가며 그룹을 체크한다.
 * 
 * 
 */
public class 뒤집기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		char c[] = str.toCharArray();
		int OneGrp = 0; int ZeroGrp = 0;
		int answer[] = check(c,OneGrp,ZeroGrp);
		if(answer[0] >= answer[1]) {
			bw.write(answer[1] +"\n");
		}else{
			bw.write(answer[0]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	public static int[] check(char c[],int OneGrp , int ZeroGrp) {
		int temp[] = new int[2];
		// 처음 원소만 세팅
		int standard = c[0] -'0';
		if(standard == 0) {
			ZeroGrp += 1;
		} else {
			OneGrp+=1;
		}
		// 1의 그룹갯수와 ,0의 그룹갯수를 찾는다
		for( int i = 1 ; i <c.length; i++ ) {
			int num = c[i] - '0';
			if(standard != num) {
				if(num == 0) {
					ZeroGrp += 1;
				} else {
					OneGrp+=1;
				}
				standard = num;
			}
			
			
		}
		temp[0] = ZeroGrp;
		temp[1] = OneGrp;
		return temp ;
	}
	
}
