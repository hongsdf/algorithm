package backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
public class Test2{
    static boolean primeNumList(int n){
        boolean flag = true;
        for(int i =2; i<Math.sqrt(n); i++){
            if(n%i == 0) {
            	flag = false;
            	break;
            }
        }
        
        return flag;
    }
    public static void main(String[] args) throws IOException{
    	boolean flag = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i =n; i<m;i++){
            if(primeNumList(i)){
            	
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
        	
       
        
    }
}