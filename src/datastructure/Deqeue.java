package datastructure;

import java.util.*;
public class Deqeue {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
//            Deque deque = new ArrayDeque<>();
            Deque<Integer> deaue = new LinkedList<>();
   
            int n = in.nextInt();
            int m = in.nextInt();

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deaue.add(num);
            }
//            System.out.println(deaue.offerFirst()); // 첫번째 원소 boolean
            System.out.println(deaue.getFirst());
            System.out.println(deaue.getLast()); //마지막 원소
            System.out.println(deaue.getClass()); // class 확인 : java.util.LinkedList
            System.out.println(deaue.peek()); //peek() : 검색 기능-- 대표원소 검색(일반적으로 첫번째 요소) 앞에서 부터
            // 만약 비어 있다면 null 
            System.out.println("poll:"+deaue.poll()); // 검색 + 제거 --> 검색을 하고 제거한다 (queue 개념)
            System.out.println("pollFirst :"+deaue.pollFirst()); //첫번째 요소를 검색+제거
            System.out.println("pollLast :"+deaue.pollLast()); // 마지막 요소를 검색 +제거
            System.out.println("pop :"+deaue.pop()); // E : 요소를 제거 하고 반환한다 (stack 개념)
            deaue.push(2); //stack 구조 void (첫번째 자료에 추가)
            deaue.push(50);
            System.out.println(deaue);
            
            // 1
            // 2
            // 0
            // 3
            List<Integer> list = new ArrayList<>(m);
            for(int i=0; i<list.size(); i++) {
//            	list.add(dea)
            }
            
            // stack 구조로 쌓기 [6,5,4,3,2,1]
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deaue.push(num);
            }
            System.out.println(deaue);
            // List 추가 [1,2,3,4,5,6]
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deaue.add(num);
            }
            System.out.println(deaue);
        }
    }

	
	

