
package Hyundai;

import java.io.*;
import java.util.*;

public class 문제 {
    public static int N,T;
    public static long arr[];

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for(int i=0;i<T;i++){
            arr = new long[2*N-1];
            st = new StringTokenizer(br.readLine());
            long ans = 0;
            long left = 0;
            long right = 0;
            for(int j=0;j<2*N-1;j++){
                arr[j] = Long.parseLong(st.nextToken());
                if(j%2==1){
                    right = Math.max(right,Math.max(arr[j]+arr[j+1],arr[j]+arr[j-1]));
                }
            }
            while(left<=right){
                long mid = (left+right)/2;
                boolean suc = true;
                long indo = 0; //2n에서 2n-1로 할당하고 남은 값 (초기 0)
                for(int j=1;j<2*N-1;j+=2){
                    long num = indo + arr[j-1]; // 2n번째 값
                    if(num<mid){
                        if(mid-num > arr[j]){ //왼쪽에 할당해도 목표치보다 낮은 경우
                            suc = false;
                            break;
                        }else{
                            indo = arr[j] - (mid-num);//왼쪽에 할당 후 갱신
                        }
                    }else{
                        indo = arr[j]; //할당해줄 필요가 없는 경우 
                    }
                }
                if(arr[2*N-2]+indo<mid){ //마지막 원소 체크
                    suc = false;
                }
                if(suc){
                    left = mid+1;
                    ans = mid;
                }else{
                    right = mid-1;
                }
            }
            System.out.println(ans);
        }
    }
}
