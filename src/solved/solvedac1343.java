package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* jdk > jre > jvm */
public class solvedac1343 {
	// ��ū ����
	// AAAA BB
	
	
	// ���ڿ��� �Է¹޴´�
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int n = str.length();
			String ans = ""; // ��� ��
			int z = 0; // �ǹ��ִ� ���� ī��Ʈ
			
			boolean flag = false; // ��ü �����ϴ�
			// ���ڿ��� ��ȸ�ϸ鼭 X�̸� TRUE , .�̸� false => A,B�� ��ü�ɼ� �մ��� üũ
			for(int i = 0; i <n; i++) {
				char c = str.charAt(i);
				// TRUE �̸� Z++
				// Z Ȧ�� : = RETURN -1
				
				// Z ¦�� : ����
				if(c == 'X') {
					flag = true;
					z++; 
				}else { // .
					// FALSE�̸� Z = 0
					flag = false;
					
					if(z%2==1) {
						ans = "-1"; 
						break;
					}
					
					ans += ".";
					z = 0;
				}
				
				
				if(z !=0 && z%4 == 0) { // BB.BBAAA
					ans = ans.substring(0, i-3);
					ans += "AAAA";
					z = 0;
				}else if(z!= 0 && z%2 == 0) {
					ans += "BB";
//					z = 0;
					
				}
				
			}
			System.out.println( (z%2==1 || ans.equals("-1")) ?  -1 : ans);
	}
	
	
	
	
	
	
	
	
	
	// Z �� ¦���̸� ��ū���� ����
	
	// Z�� Ȧ�� �̸� -1
	
	
}
