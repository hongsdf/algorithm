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
		int max = -1;
		for(int i = 0; i <N; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		boolean flag = false;
		// ���� ����
		while(array[0] <= max) {
		for(int i = 1; i<N; i++) {
			if(array[0] <= array[i]) {
				array[0]++;
				array[i]--;
				cnt++;
			}
		}
		for(int i = 1; i<N; i++) {
			if(array[0] <= array[i]) {
				flag = true;
				break;
			}else {
				flag = false;
				break;
			}
		}
		if(flag) {
			continue;
		}else {
			break;
		}
	}
		
		System.out.println(cnt);
		
		
		
	}
}
