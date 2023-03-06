package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author tyuz3
 * 
 * Greedy알고리즘
 * 풀이법 
 * 음수 배열, 0배열, 양수배열을 생성
 * 음수 배열 - 오름차순
 * 양수 배열 - 내림 차순
 * 각 배열을 짝수 인지 , 홀수 인지 체크
 * 짝수라면 서로 곱한다. => 절대값이 큰것끼리 곱해짐 (정렬)
 * 홀수라면 나머지 한개가 남을 것이다.
 * 양수라면 나머지 한개는 더한다.
 * 음수가 나머지 한개가 남았다면 0의 갯수를 확인하여 0의 배열원소가 존재하면 0을 곱해 음수를 0으로 만든다
 * 
 * 양수 과정에서 1 * 1 보다는 1 + 1 이 더 큰 값을만들수 있다.
 * 그러므로 A,B 둘중 한가지가 1이라면 두수를 더한다.
 * 
 * 이러한 방식으로 최대값을 만든다.
 *
 */
public class 수묶기_Greedy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();
		for(int i = 0; i <N; i++) {
			String input = br.readLine();
			int num = Integer.parseInt(input);
			if(num < 0 ) minus.add(num);
			else if(num > 0) plus.add(num);
			else zero.add(num);
		}
		
		
		Collections.sort(minus);
		Collections.sort(plus,Collections.reverseOrder());;
		
		long sum = 0;
		if(minus.size() %2 == 1) {
			for(int i = 0; i < minus.size()-1; i+=2) {
				sum += minus.get(i) * minus.get(i+1);
			}
			if(zero.size() == 0) {
				sum += minus.get(minus.size()-1);
			}else {
				sum += 0 * minus.get(minus.size()-1);
				zero = zero.subList(0, zero.size()-1);
			}
			
		}else {
			for(int i = 0; i < minus.size(); i+=2) {
				sum += minus.get(i) * minus.get(i+1);
			}
			
		}
		
		// 양수
		if(plus.size() %2 == 1) {
			for(int i = 0; i < plus.size()-1; i+=2) {
				if(plus.get(i) == 1 || plus.get(i+1) == 1) {
					sum += plus.get(i) + plus.get(i+1);
				}else {
					sum += plus.get(i) * plus.get(i+1);
				}
			}
			sum += plus.get(plus.size()-1);
		}else {
			for(int i = 0; i < plus.size(); i+=2) {
				if(plus.get(i) == 1 || plus.get(i+1) == 1 ) {
					sum += plus.get(i) + plus.get(i+1) ;
				}
				else {
					sum += plus.get(i) * plus.get(i+1);
					
				}
			}
			
		}
		
		bw.write(sum +"");
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
	}
}
