package algorithm;
import java.util.*;

public class test5 {
	public static void main(String[] args) {
		int arrA[] = {4,3,2,1};
		int arrB[] = {5,4,1,2};
		boolean answer = solution(arrA,arrB);
		System.out.println(answer);
	}
    public static boolean solution(int[] arrA, int[] arrB) {
        boolean answer = true;
        if(arrA.length != arrB.length) return false; // 길이가 다르면
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        for(int i = 0; i <arrA.length; i++) {
        	if(arrA[i] != arrB[i]) return false;
        }
        answer  = isPossible(arrA,arrB);

        return answer;


        // arrA를 회전하여 arrB를 만들수 잇다면 true,false 반환
        // [7,8,10] <-> [10,7,8]
        // [7,8,10] <-> [8,10,7] <-> [10,8,7]

        // [1,2,3,4] <-> [3,4,2,1]
        // [1,2,3,4] -> [2,3,4,1] -> [3,4,1,2] -> [4,1,2,3] -> [1,2,3,4]    

        // [4,3,2,1] <-> [5,4,1,2]

        // 순서 보장

    }
    public static boolean isPossible(int[] arrA, int[] arrB){
        boolean flag = false;

        // 구현
        LinkedList<Integer> q = new LinkedList<>();
         for(int a :arrA ){
                q.add(a);
            }
            for(int i = 0; i <arrA.length; i++){
               if(q.get(i) == arrB[i]) {
                   flag = true;
                   continue;

               }else {
                   q.add(q.poll()); // 맨 앞 원소
                   flag = check(q,arrB); // 일치 하는 여부
                   if(flag){
                       flag = true;
                       break; 
                   }
               }
            }
          return flag;  

    }
    public static boolean check( LinkedList<Integer> q, int[] arrB) {
        List<Integer> listA = new ArrayList<>();


        for(int i = 0; i <q.size(); i++) {
            listA.add(q.get(i));
        }
        for(int i = 0; i <q.size(); i++) {
            if(arrB[i] != listA.get(i)) return false;
        }


        return true;


    }


}
