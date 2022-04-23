package Math;
import java.util.ArrayList;
import java.util.List;
/* 8진수 -> 2진수 */
import java.util.Scanner;

public class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <s.length() ; i++ ) {
        	int num = s.charAt(i)-'0';
        	while(num != 0) {
        		if(num < 2) num = 0;
        		else num /= 2;
//        		list.add(num%2);
        		System.out.print(num);
        	}
        	System.out.print(num);
        	
        }
    }
}