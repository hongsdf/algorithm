package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Germany2 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 2 3 4 5 6 7 8 에서 6개 숫자 조합 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
	
		combine(list,0,new StringBuilder());
		
	}

	private static void combine(List<Integer> list, int pos, StringBuilder sb) {
		if(pos >= list.size()) { // 각 자리수를 전부 다 확인 했을때를 의미
			if(sb.length()== 3) System.out.println(sb);
			return;
		}
		// 1 2 3 4 5 = >2^5 == 32가지 경우의수
		// o o o o o
		// x x x x x
		
		// 1 2 3을 추출한 경우에도  1 2 3 x x : 4,5번까지 확인한 경우다
		// 3가지 패턴 활용(포함시키고-> 복원-> 포함시키지 않은 경우)
		combine(list,pos+1,sb.append(list.get(pos))); // 각 인덱스를 포함시킨다
		sb.setLength(sb.length()-1); // 다시 복원
		combine(list,pos+1,sb); // 각 인덱스 포함 x
		
	}
}
