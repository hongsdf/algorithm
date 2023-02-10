package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// 인접리스트 구현
class Adj1{
	
//	public List<Integer> indexList;
	public List<ArrayList<HashMap<Integer, Integer>>> list;
	// [1] = {1=1},{2=1},{3=1}
	// [2] = {1=1},{2=2},{3=1}
	//              :
	
	int n;
	public Adj1(int n) {
		this.list = new ArrayList<ArrayList<HashMap<Integer,Integer>>>();
		
		for(int i = 0; i < n; i++) { // 1 base 시작
			list.add(new ArrayList<HashMap<Integer,Integer>>());
			
//			ArrayList<>안의 HashMap
			for(int j = 0; j < 101; j++) {
				this.list.get(i).add(new HashMap<Integer,Integer>());
			}
		}
		
	}
	
	// 인덱스 i 안에서 해당 key지점 세팅
	public void addList(int index, int key) { // number : 찾고자 하는 인덱스 번호
		 ArrayList<HashMap<Integer,Integer>> list2 = this.list.get(index);
		 for(int i = 0; i< list2.size(); i++) {
			 HashMap<Integer,Integer> map = list2.get(i);
			 Iterator<Integer> it = map.keySet().iterator();
			 while(!it.hasNext()) {
				 if(key == it.next()) {
					 map.put(key,map.getOrDefault(key, 0) + 1 );
				 }
			 }
		 }
	}
	
	
	
	
	
	// 특정 인덱스 list return
	public ArrayList<HashMap<Integer, Integer>> getList(int index){
		return this.list.get(index);
	}
	
	
	
}

public class UXUI디자이너 {
	public static int max = 0;
	public static List<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		Adj1 adj = new Adj1(M+1);
		// [] : {}
		// [] : {}
		// [] : {}
		
		
		for(int i = 0; i <M; i++){
			 String str[] = br.readLine().split(" ");
			 int index = Integer.parseInt(str[0]);
			 int K = str.length-1; // 명령어 수
			 ArrayList<HashMap<Integer,Integer>> list = adj.getList(index);
			 for(int j = 1; j < K+1; j++) {
				 int key = Integer.parseInt(str[j]);
				 HashMap<Integer,Integer> map = list.get(key);
				 map.put(key, map.getOrDefault(key,0) + 1);
		 
			}
			 // map중에서 max값들 출력 
		}
//		for(int i = 1; i <= M; i++) { // 사용자들중에서
			ArrayList<HashMap<Integer,Integer>> list = adj.getList(4);
			// 최대값 찾기
			for(int i = 0; i <list.size(); i++) {
				HashMap<Integer,Integer> map = list.get(i);
				Iterator<Integer> it = map.keySet().iterator();
				while(!it.hasNext()) {
					if(it.next() >= 0) {
					int key = it.next();
					if(max < map.get(key)) {
						max = map.get(key);
					}
				}
					
				}
			}
			
				
			for(int i = 0; i <list.size(); i++) {
				HashMap<Integer,Integer> map = list.get(i);
				Iterator<Integer> it = map.keySet().iterator();
				while(!it.hasNext()) {
					int key = it.next();
					if(max == map.get(key)) {
						answer.add(map.get(key));
					}
				}
				
			
		}
		
		Collections.reverse(answer);
		System.out.println(answer.toString());
		
		// 구현
		//[4]: {1=1},{2=1},{3=1},{4=1}
		
		// 최대값인 것을 출력
		
		
		// 목적 : 사용자들이 가장 자주 실행하는 이벤트 찾기
		// 중복 가능
		// M명의 사용자들이 가장 자주 실행했던 이벤트들
	}
	
}