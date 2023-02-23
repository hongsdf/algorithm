package Groom;

import java.io.*;
import java.util.*;

public class 구름숫자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String,Integer> map = new HashMap<>();
		map.put("qw",1);
		map.put("as",2);
		map.put("zx",3);
		map.put("we",4);
		map.put("sd",5);
		map.put("xc",6);
		map.put("er",7);
		map.put("df",8);
		map.put("cv",9);
		map.put("ze",0);
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String answer = "";
		for(int i = 0; i+1 < N ; i++ ){
			String temp = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1));
			if(map.containsKey(temp)){
				answer += map.get(temp);
			}

		} 
		// 결과
		bw.write(answer +"\n");
		bw.flush();
		bw.close();
		br.close() ;
		
		
	}
	
}
