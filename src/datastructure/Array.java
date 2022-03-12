package datastructure;

import java.util.*;

public class Array { // 2D 작업 : String,Integer,boolean, monkey,food.. 다른 객체타입 등 포함하려면 Object
	public static void main(String[] args) {
		ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
		// 분리작업 한 행
		ArrayList<Object> data1 = new ArrayList<>();
		data1.add(1);
		data1.add(2);
		data1.add(3);
		
		ArrayList<Object> data2 = new ArrayList<>();
		data2.add("abc");
		data2.add("efg");
		data2.add("hij");
		
		ArrayList<Object> data3 = new ArrayList<>();
		data3.add(111);
		data3.add(222);
		data3.add(333);
		
		// 1차원 data1,data2,data3를 한 줄씩 합쳐 2D
		list.add(data1);
		list.add(data2);
		list.add(data3);
		
		for(ArrayList<Object> a:list) { // 한 행씩 찾기
			System.out.println(a);
		}
		
		// 다른 방법 출력
		for(int i =0; i <list.size(); i++) {
			for(int j =0; j<list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) +" ");
			}
			System.out.println();
		}
	}
}
