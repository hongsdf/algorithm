package leetcode;

public class zigzag {
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "PAYPALISHIRING";
		int numRows = 4;
		String ans = s.convert(str, numRows);
		System.out.println(ans);
		
	}
}
class Solution {
    public String convert(String s, int numRows) {
//    	if(s.length() <= 1) return s;
		// StringBuilder sb 사용
    	StringBuilder[] sb = new StringBuilder[numRows];
    	// sb초기화
    	for(int i =0; i <numRows; i++) {
    		sb[i] = new StringBuilder(); // 각 행마다 초기화한다
    	}
    	// sb[0] 
    	char c[] = s.toCharArray();
    	int len = c.length; //11
    	int idx = 0; // 문자열 배열안에서 움직이는 포인터
    	while(idx < len) {
    		int i = 0;
    		// 아래로 내려가는 단계
    		while(i<numRows && idx < len && i < len ) { // idx < len 이 없으면?
    			sb[i++].append(c[idx++]); // p
    		   // sb[0].append(a);
    		   // sb[1].append(b);
    		   // sb[2].append(c);
    		   // sb[3].append(d);
    		}
    		
    		int j = numRows-2; // 3 : 중간 공간 1 // 4 : 중간공간  : 2 // 5 : 중간공간 3 
    		// 대각선 위
    		while(j >= 1 && j < len && idx < len) {
    			sb[j--].append(c[idx++]);    		
    		}
		
    	}
    	for(int i =1; i <numRows; i++) {
    		sb[0].append(sb[i]);
    	}
    	
    	
    	
    	
    	return new String(sb[0]);
       
    }
}