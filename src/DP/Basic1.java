package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�*/
/* ������ ���� ��ȭ���� ����� �ִ�.
 * �ϴ� N --> 1�� ����ٴ� ���� �۰� �����(dp�����غ���)
 *  N�� 1�� ����� ����� 3������� ����
 *  dp�� ȿ������ ������ ���� �޸������̼��� �������(���ߴ� �� �״�� ���)
 *  D[N] = D[N/3] + D[N/2] D[N-1](Ʋ�� ��ȭ��)
 *  ���� N == 4��� ����
 *  D[4] = D[4/3] + D[4/2] +D[N-1]
 *  
 *  // �ùٸ� ��ȭ��
 *  D[N] = Math.min(D[N/3]+1, D[N/2]+1, D[N-1]+1)   /3 , /2 ,-1 �� �Ͽ� �ּҰ�
 *  �����ϱ�
 *  D[4] �� /3�� �Ҽ� ���µ� �ּҰ��� ���Ҽ� �ִ°�? ���� ������ ���
 *  �ϴ� D[4]������ �ּ� ���� 4->2->1 �̹Ƿ� 3���̴�.
 *  ���� D[10]�� ���� ����
 *  10 -> 9 -> 3 -> 1 (3��) , -1,/3,/3
 *  10 -> 5 -> 4-> 2-> 1(4��) , /2,-1,/2,/2
 *  ���� ���ڰ� �� ������
 *  
 *  �̹��� D[5]�� ���غ���
 *  5 -> 4 ->2->1  3�� , -1,/2,/2
 *  
 *  ���ݾ� ������ ����
 *  D[5]���� D[10]�� Ƚ���� 1����
 *  
 *  �ᱹ ���� 10 -> 5 -> 4-> 2-> 1(4��)���� �̿��Ѱ��� D[5]�� ���� �״�� �̿��Ѱ�
 *  // D[5] == 3�̴�
 *  // D[10]�� ���ϱ� ���� D[5] ���� 1���� ������ �� �����ؼ� ����� �����Ƿ� D[5] + 1 = 4��
 *  
 *  
 *  D[1] = 0; // 1�̸� ������ ���� �ʱ� ������ 0
 *  D[2] = 1; 
 *  D[3] = 1;
 *  D[4] = 3;
 *  D[5] = 3;
 *  D[6] = 0;
 *  D[7] = 0;
 *  D[8] = 0;
 *  D[9] = 2;
 *  D[10] = 3;
 *  
 *  
 *  
 *  
 *  
 *  4 = 4-> 2 -> 1
 *  4 = 4-> 3-> 2 ->1
 *  // ������ 3�� �ȵ�
 *  
 * 
 * 	X�� 3���� ������ ��������, 3���� ������.
	X�� 2�� ������ ��������, 2�� ������.
	1�� ����.
 * 
 * */
public class Basic1 {
	public static int d[];
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[N+1];
		solve(N);
//		solve2(N);
		
	}
		// �ݺ���
		// Bottom - up ���� �迭�� d[1] ~ d[n]���� ������� ä������
		private static int solve2(int n) {
			d[1] = 0; // �ʱ�ȭ
			for(int i = 2; i <=n; i++) {
				// ���� 1
				d[i] = d[i-1] + 1;
				// ���� 2
				if( i%2 == 0) {
					int temp = d[i/2] + 1;
					if(temp < d[i]) d[i] = temp;
				}
				// ����3
				if( i%3 ==0) {
					int temp = d[i/3] + 1; //  d[i/3]�� �������� + ���� ����
					if(temp < d[i]) d[i] = temp;
				}
			}
			return d[n];
			
			
		}
		// ���
		// Top-down d[n]�� ã�� ���� ������ ���� ã�´�.
		private static int solve(int n) {
			if(n == 1) {
				return 0;
			}
			//�޸������̼�
			if(d[n] > 0) {
				return d[n]; // ���ߴ� ���� �ִ� ��
			}
			d[n] = solve(n-1) + 1;
			if(n%2== 0) {
				int temp = solve(n/2) + 1;
				if(temp < d[n]) {
					d[n] = temp ;
				}
				
			}
			if(n%3 ==0) {
				int temp = solve(n/3) + 1;
				if(temp < d[n]) {
					d[n] = temp ;
				}
			}
			
			
			return d[n]; 
		}
}