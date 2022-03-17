package leetcode;

public class travel2 {
	public static void main(String[] args) {
		Sol2 m = new Sol2();
		int[][] key = new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		boolean flag  = m.solution(key, lock);
		System.out.println(flag);

	}
}
class Sol2 {
	public boolean solution(int key[][], int lock[][]) {
		// 열쇠를 자물쇠와 일치시키기
		
		
		
		int offset = key.length -1 ; // 시작위치
		for(int i =0; i <offset +lock.length ; i++) {
			for(int j =0; j <offset + lock.length ; j++ ) {
				
				// 회전주기
				for(int spin = 0; spin < 4; spin ++) {
				
					// 큰공간을 생성
					// key 최대공간 20 + lock 최대 공간 20 + key 최대 공간 20
					int arr[][] = new int[60][60];
					
					// 회전할때마다 arr갱신 그때마다 정답 확인
					// arr만들기 : lock을 올리는 거니깐
					for(int r = 0; r < lock.length; r++) {
						for(int c = 0; c<lock.length; c++) {
							arr[offset + r][offset + c] = lock[r][c]; 
						}  
					}
					// arr와 key를 비교할것이기 때문에
					// spin 각 위치에서 4번을 돈다
					// key의 위치인 i,j
					correct(arr,key,spin,i,j);
					if(sol(arr,offset,lock.length)) {
						return true;
					}
				}

			}
		}
		return false;
	}
	// arr가 정답인지 확인하는 매서드
	private boolean sol(int[][] arr, int offset, int len) {
		// len : lock.length
		for(int i = 0; i <len; i++) {
			for(int j = 0; j <len; j++) {
				// 자물쇠 위치는 offset + 
				if(arr[offset+i][offset+j] != 1) return false;
			}
		}
		return true;
	}

	private void correct(int[][] arr, int[][] key, int spin, int i, int j) {
		// arr를 수정하는 매서드
		int n = key.length;
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(spin == 0) {
//					키 시작위치에서 시작
					arr[i+r][j+c] += key[r][c]; 
				}else if(spin == 1) {
					// r : 2, c : 0 -> 0 ,0
					// r : 1, c: 0 -> 0, 1
					//
					arr[i+r][j+c] += key[c][n-1-r];
				}else if(spin == 2) {
					// r: 2 ,2 -> 0,0 
					// r : 2, c : 1 -> 0, 1 
					arr[i+r][j+c] += key[n-1-r][n-1-c ];
				}else if(spin == 3) {
					// r:2,2 -> 0,2
					// r :2, c :1 -> 1,2
					// r: 2,0 -> 2,2
					arr[i+r][j+c] += key[n-1-c][r];
				}
			}
		}
		
		
		
		
		
		
		
	}
}