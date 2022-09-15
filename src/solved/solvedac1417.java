package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// O(N^2)
// �ĺ����� ��ȸ�ϸ� ������ ū �ĺ��� ������ 1 ��ǥ�� �����´� 
// �� +1 , ��� -1
// ���� ���� ��� ��������
// cnt++

public class solvedac1417 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		// �ĺ��� �Է� �ޱ�
		int N = Integer.parseInt(br.readLine());
		
		// �� �ĺ��� ���� �Է� �ޱ�
		int array[] = new int[N+1];
		
		for(int i = 0; i <N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		// �ִ밪 ã��
		while(true) {
			boolean flag = true; // �ִ밪 flag
			if(N == 1) {
				System.out.println(0);
				break;
			}
			for(int i = 1; i<N; i++) {
				if(array[0] <= array[i]) {
					array[0]++;
					array[i]--;
					cnt++;
				}
				
			}
			for(int j = 1; j<N; j++) {
				if(array[0] <= array[j]) {
					flag = false;
				}
			}
			if(flag) {
				System.out.println(cnt);
				break;
			}else {
				continue;
			}
			
		}
		
	}
}
