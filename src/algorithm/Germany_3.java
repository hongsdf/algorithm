package algorithm;

import java.io.*;


public class Germany_3 {
	public static void main(String[] args) throws Exception {
		// ABCDE 에서 2글자 조합 목록
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char c[] = s.toCharArray();
		combine(c,0,new StringBuilder());
	
	}

	private static void combine(char[] c, int pos,StringBuilder sb) {
		if(pos >= c.length) { // 모든 글자를 다 확인한다
			if(sb.length() == 2) System.out.println(sb);
			return;
		}
		// 먼저 끝까지 다 포함시켜놓고 돌아오는 방법 ABCDE --> ABCD --> ABCE -->...... 
		combine(c,pos+1,sb.append(c[pos])); // return 되면 pos = 4로 돌아온다, pos 와 // sb안의 값은 (독립적)
		sb.setLength(sb.length()-1);
		combine(c,pos+1,sb);
		
	}
}
