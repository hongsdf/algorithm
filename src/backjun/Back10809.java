package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int arr[] = new int[26];

		for (int i = 0; i < arr.length; i++) { // 32 공간

			arr[i] = -1; // arr[0] = 97 + 0, arr[1] = 97 + 1, arr[2] = 97 + 2
		}
		// a b c d e
		for(int j = 0; j < str.length(); j ++) { // bca
			char s = str.charAt(j); // b : 98 , c: 99, a : 97 
			
			 if(arr[s -'a'] == -1) {
				// 1 , 2 , 0
				arr[s-'a'] = j; // 배열의 시작위치 = b의 인덱스 값
				//arr[2] = 0; // 0 1 2
				//arr[1] = 0  // 2 0 1
				//arr[2] = 1
			}
			
		}
		for(int v : arr) {
			System.out.print(v+" ");
		}

	}
}
