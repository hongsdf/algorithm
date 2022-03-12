package datastructure;
import java.util.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


    public class Dequeue3 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<Integer>();
            Map<Integer,Integer> map = new HashMap<>();
            int n = in.nextInt();
            int m = in.nextInt();
            int cnt = 0;
            int max = 0;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.addLast(num); // 1 2 3 4 5 6
                                // 1 1 1 1
                                // 0
                                // cnt : 1 2 3 4 3
                                // max : 3
                map.put(num, map.getOrDefault(num,0) + 1); //getOrDefault(num,0) : 값이 있으면 num , 없으면 null
                
                if(map.get(num) == 1) cnt++;
                
                
                if(deque.size() == m +1){
                  int value = deque.removeFirst();
                  map.put(value, map.get(value) -1);
                 if(map.get(value) == 0) cnt--;
                }
               
                if(deque.size() == m){
                  if(cnt > max) max = cnt;
                }
                
                
            }
            System.out.println(max);
        }
    }

