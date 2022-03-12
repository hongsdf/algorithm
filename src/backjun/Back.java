package backjun;

import java.util.*;

public class Back {
	static final int height = 100;
	public static void main(String[] args) {
		/*
		 * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉
		 * 명이었던 것이다.
		 * 
		 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는,
		 * 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
		 * 
		 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
		 */
		Scanner sc = new Scanner(System.in);

		
		int sum = 0;
		
		List <Integer> arr = new ArrayList<>();
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
		arr.add(sc.nextInt());
	
		
		for(int i = 0; i<arr.size(); i++) {
			sum	+= arr.get(i); //140
		}
//		int tot = sum - height; //40
//		System.out.println(tot);
		
		int t = 0;
		for(int i = 0; i<arr.size(); i++) {
			for(int j = i+1; j<arr.size(); j++ ) {
				if(sum - arr.get(i) - arr.get(j) == 100) {
//				System.out.println(arr.get(i));
				int a = arr.get(i);
				int b = arr.get(j);	
//				System.out.println(arr.get(j));		
				arr.remove(Integer.valueOf(a));
				arr.remove(Integer.valueOf(b));
				}
				break;
				
			}
			
		}
//		System.out.println(arr);
		sc.close();
//		arr.remove(a1);
//		System.out.println(arr);
		
		
		// ArrayList.remove() : idx값을 삭제 
		// 1.  remove(int idx) : 해당 인덱스 삭제, 2. remove(Object) : 해당 객체를 삭제 => 객체가 여러개일경우
		// 첫번째 객체만 삭제 (monkey,monkey....) 첫째 monkey만 삭제
		
		
		// arrayList.remove(Integer.ValueOf()) : 특정 값을 삭제
		// arrayList.removeAll() : 해당 값들을 전부 삭제
		
		// Iterator.remove()
		
	}
}
