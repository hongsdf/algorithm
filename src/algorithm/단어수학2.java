package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 단어수학2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String [] str = new String[N];
		int alpha[] = new int[26]; // 0 ~25 인덱스가 := A~Z까지 대응
		// 입력층 구현
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		// 로직 구현
		for(int i = 0; i <N; i++) { 
			int temp = (int) Math.pow(10, str[i].length()-1); // str[i]의 자릿수 표현 ex) ABC => 1000자리
			for(int j = 0; j<str[i].length(); j++) {
				alpha[(int)str[i].charAt(j)-65] += temp; // 대문자 - 65을 빼서 수로 치환
				temp /= 10; //1000 -> 100 -> 10 -> 1
			}
		}
		Arrays.sort(alpha); // 결과를 오름차순으로 정렬
		// 원소를 다 대입했다면
		// 결과 찾기
		int num = 9;
		int sum = 0;
		for(int i = 25; i >= 0; i--) {
			if(alpha[i] == 0) {
				break;
			}
			sum += alpha[i] * num;
			num--;
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
