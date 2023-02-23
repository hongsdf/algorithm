package Groom;

import java.io.*;
import java.util.*;

public class 직사각형만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long answer = 0;
		int N = Integer.parseInt(br.readLine());
		if(N < 4){
			System.out.println(0);
			return;
		}
		HashMap<Integer,Integer> map = new HashMap<>();
		int arr[] = new int[N];
		String str[] = br.readLine().split(" ");
		for(int i = 0; i <N; i++){
			arr[i] = Integer.parseInt(str[i]);
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}
		// 로직
		// 10^6
		long sum = 1;
		int count = 0;
		Arrays.sort(arr);
		for(int i = arr.length-1; i>=0; i--){
			 int num = arr[i];
			if(map.get(num) != 0 && map.get(num) >= 2 ){
				count+=1;
				sum *= num;
				
				int val = map.get(num)-2;
				map.put(num,val);
				if(count == 2){  // 직사각형 완성
					answer += sum;
					sum = 1;
					count = 0;
				}
				
			}
		}
		
		
		
		bw.write(answer+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
