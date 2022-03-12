package leetcode;

public class zigzag2 {
	public static void main(String[] args) {
		Sol s = new Sol();
		String str = "abcdefghijklmop";
		int numRows = 4;
		String ans = s.convert(str, numRows);
		System.out.println(ans);
	}
}
class Sol{
	public String convert(String s, int num) {
		StringBuilder[] sb = new StringBuilder[num];
		//초기화 필수
		for(int i =0; i <sb.length; i++) {
			sb[i] = new StringBuilder();
		}
		char c[] = s.toCharArray();
		int size = c.length; // 배열 크기
		int idx = 0; // 배열안 인덱스

		// while문 구성은 구현4개를 합한것이다.
		while(idx < size) { // 모든 원소를 매핑
			// 옆으로 이동 단계
			int i = 0 ;
			int j = 0 ; // n칸 움직임
			
			// 1. 오른쪽 이동 
			while(j < num - 1 && idx < size && i < size) { 
				sb[i].append(c[idx++]);
				j++;
			}
			// 2. 아래이동
			while(i < num-1 && idx < size && i < size) {
				sb[i++].append(c[idx++]);
			}
			// 3. 오른쪽 이동
			j = 0;
			while(j < num - 1 && idx < size) {
				sb[i].append(c[idx++]);
				j++;
			}
			
			// 4. 올라가는 이동
			while(i >= 1 && idx < size) {
				sb[i--].append(c[idx++]);
			}
			
		}
		for(int i = 1; i <sb.length; i++) {
			sb[0].append(sb[i]);
		}
		
		
		return new String(sb[0]);
	}
}
