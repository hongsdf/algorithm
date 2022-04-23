package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASCLL {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int res[] = new int[26];
		for( char c : str.toCharArray() ) {
			res[c-'a']++;
			
		}
		for(int ans : res) {
			System.out.print(ans +" ");
		}
	}
}
