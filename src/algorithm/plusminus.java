package algorithm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    int size = arr.size();
    float pos = 0.f;
    float zero= 0.f;
    double negativ = 0.f;
    for(int i =0; i<arr.size(); i++){
        if(arr.get(i) > 0){
            pos++;
        }else if(arr.get(i) == 0){
            zero++;
        }else{
            negativ++;
        }
        
    }
    // 소수점 자리 수 설정 방법 1.printf() 메서드로
    System.out.printf("%.6f",(pos/ size));
    System.out.printf("\n%.6f",(negativ/ size));
    System.out.printf("\n%.6f",(zero/ size));
    
    // 2. DemicalFormat 클래스 이용 방법 : 10진수에 용이
    float Pi = 3.1415f;
	System.out.println(Pi);
	DecimalFormat frmt = new DecimalFormat();
	// 자릿수 2자리 설정해놓고 밑에 실행
	frmt.setMaximumFractionDigits(2);
	// 실행 부분
	System.out.println(frmt.format(Pi));
	
	System.out.println(frmt.format(pos/ size));
    
	
    }

}

public class plusminus {
    public static void main(String[] args) throws IOException {
       List<Integer> arr = new ArrayList<>(Arrays.asList(-4, 3, -9, 0, 4, 1));
    	
    	Result.plusMinus(arr);
    }
}
