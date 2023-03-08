package algorithm;
import java.util.*;

public class 프로그래머스점찍기 {
	public static void main(String args[]) {
		Solution1A m = new Solution1A();
		int k = 2;
		int d = 4;
		long answer = m.solution(k, d);
		System.out.println(answer);
	}
}

class Solution1A {
    public long solution(int k, int d) {
    	long answer = 0;
    	// 설계 
    	/**
    	 * [수학]  
    	 * d를 넘지 않는다.
    	 * 그러면 d까지만 배열에 넣으면 되지 않을까?
    	 * i+= k : k만큼씩 증가하면 된다.
    	 * 
    	 * 주의점 long타입 안에 int * int형을 넣어서는 안된다. => 올바른 코드 long a = (long) b * c;
    	 * 
    	 * for문 이해 
    	 * 
    	 */
    	for(int i = 0; i <=d; i+= k) {
    		long max = d * d;
    		long curr = i * i;
    		int top = (int)Math.sqrt(max - curr);
    		answer += (top/k) +1;
    	}
    	
		return answer;
    	
    	
    	
    	
    	
//        long answer = 0;
//        List<Integer> list2 = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        
//        for(int i = 0; i <=d; i++){
//            list.add(i);
//        }
//        for(int i : list){
//            list2.add(i*k);
//        }
//        // 로직구현
//        int i = 0;
//        int index = 0;
//         for(int j = list2.size()-1; j>= 0;j--){
//        	 if(i > list2.size()-1) break;
//             int x = list2.get(i);
//             int y = list2.get(j);
//             long num = (long)Math.pow(x,2) +(long)Math.pow(y,2);
//             double dist = Math.sqrt(num);
//             if(dist <= d){
//                 index = j+1;
//                 i++;
//                 j = list2.size()-1;
//                 answer += index;
//               }
//            }
//             
//        	
//         return answer;
//        	
//        }
    
    // cnt = cnt-1 + cnt-2 + ... + 1
    }
   
}