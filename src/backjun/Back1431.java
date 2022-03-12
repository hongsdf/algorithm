package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 연구 필요 있음(밑에)
class compareObject implements Comparator<String>{
	int sum = 0;
	int sum2 = 0;
	@Override
	public int compare(String o1, String o2) {
		// 다른 경우
		if(o1.length() != o2.length()) {
			return o1.length() - o2.length();
			
	    // 문자열길이가 같은경우(문자열안에서 숫자만 뽑아 더하기)
		}else if(o1.length() == o2.length()) {
			int o1sum = getSum(o1);
			int o2sum = getSum(o2);
			// getSum 함수를 실행하여 비교
			// 같은 경우 정렬
			if(o1sum != o2sum) {
				return o1sum - o2sum;
			}
			// 두 결과가 같은 경우 문자열 비교
			else {
				return o1.compareTo(o2);
			}
			

		} //그외
		else {
			return o1.compareTo(o2);
		}
	}
	// 문자열에서 숫자만 뽑아내기
	public int getSum(String o1) {
		int length = o1.length();
		sum = 0;
		for(int i =0; i <length; i++) {
			// 문자열에서 숫자만 가져오기
			// 이것이 맞는 표현(*연구 필요)
			if((o1.charAt(i) -'0') <= 9 && (o1.charAt(i) -'0') >= 0) {
				sum += o1.charAt(i) - '0';
			}
			
			
//			if(o1.charAt(i) <= '9' && o1.charAt(i)  >= '0') {
//				sum += o1.charAt(i);
//			}
		}
		
		return sum;
	}
	
}



public class Back1431 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		for(int i =0; i<n; i++) {
			str[i] = br.readLine();
		}
//		for(int i =0; i<n; i++) {
//			System.out.println(str[i]);
//		}
		
		List<String> list = new ArrayList<String>(Arrays.asList(str));
//		for(int i =0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		Collections.sort(list,new compareObject());
		
		for(int i =0; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
}
