package sk;
import java.util.*;

public class Number1 {
	public static void main(String[] args) {
		Solution m = new Solution();
		String[] bakery_schedule = {"09:05 10","12:20 5","13:25 6","14:24 5"};
		String current_time = "12:05";
		int k = 10;
		int answer = m.solution(bakery_schedule, current_time, k);
		System.out.println(answer);
	}
}

class Solution {
    public int solution(String[] bakery_schedule, String current_time, int k) {
        int answer = -1;
        List<int[]> list = new ArrayList<>();
        String str1[] = current_time.split(":");
        int current = Integer.parseInt(str1[0]) * 60 +  Integer.parseInt(str1[1]);

        // 빵 k개를 판매하려면 회소 몇분이 걸리는가?
        // [시각, 갯수]
        for(String bake :bakery_schedule){
            String [] str = bake.split(" ");
            String time[] = str[0].split(":"); // "xx:yy"
            // time[0]; // "xx"
            // time[1]; // "yy"
            int clock = Integer.parseInt(time[0]) * 60 +  Integer.parseInt(time[1]);
            int n = Integer.parseInt(str[1]); // 이 시각 출고한 빵의 갯수
            list.add(new int[]{clock,n});
        }
        int sum = 0;
        int endtime = 0; // 마지막 시간
        for(int [] a :list){
            if(k >= sum && a[0] >= current){
                k -= a[1]; // 5 , 6
                endtime = a[0];
            }
        }
        answer = endtime-current;

        return answer;
    }
}
