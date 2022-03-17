package leetcode;

import java.util.*;

public class travel {
	public static void main(String[] args) {
		Solution40 m = new Solution40();
		int[][] key = new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		boolean flag  = m.solution(key, lock);
		System.out.println(flag);

	}
}

class Solution40 {
    
    public void match(int[][] arr,int[][]key,int cycle, int i,int j){
        // i, j는 key의 좌표
        int n = key.length;
        for(int r = 0; r < n;r++){
            for(int c= 0; c < n; c++){
                // 아주 중요 (회전)
                if(cycle == 0){ // 회전 0 
                    // arr[n+r][n+c] 부터 arr는 채워짐
                    arr[i+r][j+c] += key[r][c];
                }else if(cycle == 1){ //90도 회전
                    //r : 1 ,c : 0
                    arr[i+r][j+c] += key[c][n-1-r];
                    // 0,0 --> 0,2
                    // 1,0 --> 0,1 
                    // 2,0 --> 0,0

                }else if(cycle == 2){ // 180도 회전
                    //r : 2 , c: 2
                    arr[i+r][j+c] += key[n-1-r][n-1-c];
                    
                    // (2,2) -> 0,0
                    // (2,1) -> 1,0
                    // (2,0) -> 0,2
                }else if(cycle ==3){ // 270도
                    // 반시계방향을 생각
                    // r : 0, c :2 
                    
                    // 0,2 -> 0,0 
                
                    arr[i+r][j+c] += key[n-1-c][r];
                }
            }
        }
    }
    public boolean correct(int arr[][],int offset,int len){
        for(int i =0; i<len; i++){
            for(int j =0; j<len; j++){
                if(arr[i+offset][j+offset] != 1) return false;
            }
        } 
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
      // lock를 큰 공간 중간에 배치한다
        
      // 처음 시작할때 key값중 하나의 배열이 lock이랑 겹쳐야한다.
      int offset = key.length - 1; // 시작지점
        
     
     // 큰 공간에 lock 좌표 올리기
     // 큰공간에 lock올리면  key20 + lock 20까지만 수행 하면 된다 
     // 이유? 하나의 key만 걸치고 있으면 되기 때문에
        
      for(int i =0; i< offset + lock.length; i++){
          for(int j = 0;j< offset +lock.length; j++){
             // 회전 방향
              for(int cycle =0; cycle < 4; cycle++) {
                  // key 20+ lock20 + key20
                  int arr[][] = new int[58][58];
                  // lock 좌표 올리기
                  for(int r = 0; r<lock.length; r++){
                      for(int c = 0; c<lock.length; c++){
                          arr[offset + r][offset + c ]= lock[r][c];
                      }
                  }
                  // i,j는 키가 갈 수 있는 범위 좌표
                 match(arr,key,cycle,i,j);
                 // 큰공간arr, offset(큰공간이 있는 시작 위치), lock을 검증할것이기 때문에
                  if(correct(arr,offset,lock.length)){
                      return true;
                  }
                  
              }
                  
             }
              
           
      }

        return false;
    }
}