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

class Result1 {
    static String answer ="";
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    
    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        Collections.sort(A);
        Collections.sort(B,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2 - o1;
			}
        	
		});
        
        boolean visit[] = new boolean[B.size()];
        int n = B.size();
        int start = 0;
        int end = 0;
    	while(start <= n-1) {
    		if(A.get(start) + B.get(end) >= k) {
    			cnt++;
    			start++;
    			end++;
    		}else {
    			start++;
    		}
    	}
        
    	
        if(cnt >= A.size()){
        	sb.append("YES");
        }else{
        	sb.append("NO");
        }
        answer = String.valueOf(sb);
        sb.setLength(0); // sb초기화
        cnt = 0;
        return answer;
    }

  
}

public class HackerRank1 {
	
    public static void main(String[] args) throws IOException {
    	List<Integer> A = new ArrayList<>();
    	List<Integer> B = new ArrayList<>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N =Integer.parseInt(br.readLine());
    	while(N-->0) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		int n = Integer.parseInt(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine()," ");
    		for(int i = 0; i <n; i++) {
    			A.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		st = new StringTokenizer(br.readLine()," ");
    		for(int i = 0; i <n; i++) {
    			B.add(Integer.parseInt(st.nextToken()));
    		}
    		String answer = Result1.twoArrays(k, A, B);
    		System.out.println(answer);
    		A.clear();
    		B.clear();
    		
    	}
    	
//    	YES
//    	NO
//    	NO
//    	YES
//    	YES
//    	10 9
//    	1 5 1 4 4 2 7 1 2 2
//    	8 7 1 7 7 4 4 3 6 7
    }
}

