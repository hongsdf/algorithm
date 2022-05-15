package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Chapter5_A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N --> 0) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			Stack<Character> st = new Stack<>();
			boolean flag = true;
			for(int i = 0; i <c.length; i+=1 ) {
				if(c[i] == '(') {
					st.push('(');
				}else if(!st.isEmpty() && c[i] == ')') {
					st.pop();
				}else {
					flag = false;
					break; // stÀÌ ºñ¾îÀÖ°í && ´ÝÈù °ýÈ£°¡ µé¾î¿Â °æ¿ì
				}
			}
			
			
			if(flag) {
				if(st.isEmpty()) {
					System.out.println("YES");
				}else {
					System.out.println("No");
					
				}
			}else {
				System.out.println("No");
			}
		}
	} // ())
}
