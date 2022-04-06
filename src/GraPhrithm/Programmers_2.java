package GraPhrithm;

import java.util.*;

public class Programmers_2 {
//	static StringBuilder sb2;
	public static void main(String[] args) {
		Solution1 m = new Solution1();
		String num = "17";
		m.solution(num);
//		sb2 = new StringBuilder();
//		sb2.append("123");
//		int num1 = Integer.parseInt(sb2.toString());
//		int n = Integer.valueOf(num);
	}
}
class Solution1 {
    int answer = 0;
//    List<String> list = new ArrayList<>();
    
    public int solution(String numbers) {
        
    char [] c = numbers.toCharArray();
   
    int n = c.length;
    // 순서가 있는 것이 필요하다
    boolean visit[] = new boolean[n];
//    combine2(c,visit,0,n);
    combine(c,0,new StringBuilder());
   
    
        
    return answer;
    }
    
    
    
    // 순서가 있는 것
    private void combine2(char[] c, boolean[] visit, int pos, int n,StringBuilder sb) {
    
    	
	
}



   // 조합
	public void combine(char [] c, int pos, StringBuilder sb ){
    	if(pos >= c.length){
//    		list.add(sb.toString());
            boolean flag = check(sb); // 소수 판별 메서드
            if(flag) answer++;
            return;
        }
        
    	
    		combine(c,pos+1,sb.append(c[pos])); // 포함 O
    		sb.setLength(sb.length()-1); //복원 작업
    		combine(c,pos+1,sb); // 포함 x
    		
    	
    	
        
        
    }
   
    
    public boolean check(StringBuilder sb){
       if(sb.length() == 0) return false;
       int num = Integer.parseInt(sb.toString()); // stringBuilder int형으로변환
       if(num == 1 || num ==0) return false;
       for(int i=2; i<num; i++) {
    	   if(num % i == 0) return false;
       }
    	
    	
    	return true;
    }
}