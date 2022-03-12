package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge2 {
	
	// MERGE 기준
    public static int[] temp = new int[10000001];
    
    
    public static void Merge(int [] arr, int start, int end){
        if(start < end){ //이때만 진행
            int middle = (start+end) /2;
              Merge(arr, start, middle);
              Merge(arr, middle+1, end);
              MergeSort(arr,start,middle,end);
        }
    }
    public static void MergeSort(int arr[], int start, int mid, int end) {
    	int i = start; // [1,2]  mid: 1~2
    	int j = mid+1; // [3,4]  // j 3~4
    	int k =start;
    		while(i<=mid && j<=end) {
    			if(arr[i] > arr[j]) {
    				temp[k] = arr[j];
    				k++;
    				j++;
    			}else {
    				temp[k] = arr[i];
    				k++;
    				i++;
    			}
    		}
    		
    		if( i > mid) {
    			for(int t = j; t<=end; t++) {
    				temp[k] = arr[t];
    				k++;
    			}
    		}else {
    			for(int t = i; t <= mid; t++) {
    				temp[k] = arr[t];
    				k++;
    			}
    		}
    		// 임시공간 --> 원본 공간
    		for(int v = start; v<=end; v++) {
    			arr[v] = temp[v];
    		}
    	
    
    }
    
    
    
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i =0; i <n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
		Merge(arr,0,n-1);
        for(int a: arr){
            System.out.print(a+" ");
        }
	}
}
