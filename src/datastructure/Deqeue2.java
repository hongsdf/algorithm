package datastructure;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Deqeue2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//       Deque deque = new ArrayDeque<>();
       Deque<Integer> deaue = new LinkedList<>();
       HashMap<Integer,Integer> map = new HashMap<>();
       
       
       int n = in.nextInt();
       int m = in.nextInt();
       int cnt = 0;
       int ans = 0;
       
       for (int i = 0; i < n; i++) {
           int num = in.nextInt();
           deaue.addLast(num); // 뒤부터 추가
           
//           if(map.get(num) == null) map.put(num, 0); // 6,0   6,1
           // 1 2 3 4 5 6
           // 1 1 1 1 1 1
           // 0 0 0 
           // cnt = 0 1 2 3 4 3 4 3 4 3
           // ans = 3
           map.put(num, map.getOrDefault(num,0) + 1); //getOrDefault(num,0) : 값이 있으면 num , 없으면 null
           
           if(map.get(num) == 1) cnt++;
           
           if(deaue.size() == m+1) { // 4개가 추가 되면
        	   int number = deaue.removeFirst(); // 1
        	   map.put(number, map.get(number)-1);
        	   if(map.get(number) == 0) cnt--;
//        	   map.put(number, )
        	   
           }
           if(deaue.size() == m) { // 3개공간
        	   if(cnt > ans) ans = cnt; // cnt = 3
           }
           
       }
       System.out.println(ans);
       
       
       
       
       
       
       
       
    	   //  i-1 i i+1
      
       
	}
}
