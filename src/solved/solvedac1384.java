package solved;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class solvedac1384 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// �׽�Ʈ ���̽��� �Է¹޴´�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		//wihile()
		while(true) {
			int T = Integer.parseInt(br.readLine());
			// 0 �̸� �׽�Ʈ ���̽� ����
			if(T == 0 ) break;
			
			String array[][] = new String[T][T];
			
			for(int i = 0; i <T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<T; j++) {
					array[i][j] = st.nextToken();
				}
				
			}
			boolean flag = true ;
			System.out.println("Group "+num);
			
			for(int i = 0; i<T; i++) {
				String A ="";
				String B ="";
				for(int j =1; j<T; j++) {
					if(array[i][j].equals("N")) {
						flag = false;
						if(i-j >= 0) {
							 A = array[i-j][0]; // ����
							 B = array[i][0]; // ����
							
							
						}else {
							 A = array[i-j+T][0]; // ����
							 B = array[i][0]; // ����
							
						}
						System.out.println(A+" was nasty about "+B);					
					}
					
				}
						
			}
			if(flag) {
				System.out.println("Nobody was nasty");
			}
			num++; // �� ����
			System.out.println();
		}

		
		
		// ��� ����
		/*
		 * Group 1 
		 * A was nasty about B 
		 * A was nasty about B
		 * 
		 * Group 2 
		 * Nobody was nasty
		 */
		
		// ���� ����
		// ���ʿ��� ���������� ���� ����
		// ��� �� ��ŭ ���� ������ ����
		
		
		// ���� ��ġ �� N�� ã�Ƽ� �ڷ� N�� ��ġ ��ŭ �ڿ� ��� 
		
		
		
	}
}
