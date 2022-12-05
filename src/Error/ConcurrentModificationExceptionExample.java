package Error;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExceptionExample {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("kiwi");
        
        List<String> fruits2 = new ArrayList<>();
       
        fruits2.add("banana");
        fruits2.add("kiwi");
        
        
        List<String> list = new ArrayList<>();
        
        //  ConcurrentModificationException 발생
        //  List의 값을 변경 및 삭제가 일어나면 
//        for (String item : fruits) {
//            if (item.equals("apple")) {
//                fruits.remove(item);
//            }
//        }
        
        
        // [해결방법1]인덱스 번호로 순회
//        for(int i = 0; i <fruits.size(); i++) {
//        	if(fruits.get(i).equals("apple")) {
//        		fruits.remove(i);
//        	}
//        }
        
        
        // [해결방법2] 임시배열에 넣고 한번에 삭제한다.
        for(String item : fruits) {
        	for(String item2: fruits2) {
        		if(item.equals(item2)) {
        			list.add(item);
        		}
        		
        	}
        }
        
        fruits.removeAll(list) ;
        
        System.out.println(fruits);
    }
}
