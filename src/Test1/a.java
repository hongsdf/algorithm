package Test1;

import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");

        print(list);
        System.out.println(list.get(0)); // test3
        System.out.println(list.get(2)); // test4
        print2(list);
        String str1 = "주소1";
        String str3 = new String("주소1");
        String str2 = "주소1";
        System.out.println(str3==str2);
        
    }

    private static void print(List<String> listparam) {
        listparam.set(0, "test3");
        listparam.add("test4");
        System.out.println(listparam.get(0)); // test3
    }
//    print(List<String> listparam) 과 print2(List<String> listparam)는 모두 list을 바로 보고 있다
    private static void print2(List<String> listparam2) {
        System.out.println(listparam2.get(0)); // test3
    }
    
}