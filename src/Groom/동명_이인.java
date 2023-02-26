package Groom;

import java.io.*;
import java.util.*;

public class 동명_이인 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 자신의 이름을 포함하는 이름을 가진 학생이 몇 명이나 있는지 확인
		// 구름이의 이름이 포함된 이름을 가진 학생의 수
		int answer = 0;
		
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		String name = str[1];
		List<String> list = new ArrayList<>();
	
		for(int i = 0; i <N; i++){
			 list.add(br.readLine());
		}
		//구현층
		for(String names : list){
			if(names.contains(name)){ // 문자열이 포함되면
				answer+=1;
			}
		}
		
		bw.write(answer+"\n");
		bw.flush();
		bw.close();
		br.close();
	
	}
}