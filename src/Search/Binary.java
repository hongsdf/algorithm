package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//재귀함수를 실행시 범위를 반으로 줄여가며 진행한다 
//시간 복잡도 O(log2^N)
public class Binary {
	public static int count = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
		Arrays.sort(arr);
		for(int a:arr) {
			System.out.print(a+" ");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int goal = (int) (Math.random()*10);
		System.out.println("정답값 :" + goal);
		int target = Integer.parseInt(br.readLine());

		int n = arr.length;
//		int res = solution(arr,0,n-1,target);
//		if(res != -1)
//		System.out.println(res+"번째 에서 찾았습니다");

		while (goal != target) {
			System.out.println("숫자를 말하시오");
			target = Integer.parseInt(br.readLine());
			count++;
			if(goal < target) {
				System.out.println("down");
			}else if(goal > target) {
				System.out.println("up");
			}
			
		}
		System.out.println("정답입니다.  맞힌횟수 >>"+ count);
		
		
	}
}
