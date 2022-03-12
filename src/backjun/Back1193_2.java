package backjun;

import java.util.Scanner;

public class Back1193_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int pre = 0; int cross_num = 1; // 해당 대각선 원소 갯수
		while(true) {
			if( n <= pre + cross_num) { //n : 1  0+1, n:2   1+2,
				//n == 5 (2,2) n == 8 ,cross_num : 4  3/2
				if(cross_num%2 == 1) { // 2/2 아래 위쪽방향 /^
					/*(cross_num - (n-pre-1)) :  n-이전값들을 제거하면 공간이 남는다
					 * ex) n == 8 8공간- 6공간 2공간을 채워야한다  (예상답변 3/2)
					 * 2공간을 채우기 위해 어디 부터 채워야 할지 결정
					 * 8이 있는 대각선위치(cross = 4) 4 - (8-6-1) -> 4 - 1(위치) = 3 즉 4개의 공간중 1번째
					 * -1을 하는 이유 : 인덱스가 0번째 부터 있다고 생각하고 -1을 한다
					 * 3/ n-pre(8공간 - 이전공간(6공간)) = 2위치
					 * 1번째 위치에 3/2를
					 * O O O O
					 * O O O O
					 * O O O O 
					 * O O O O
					 * */
					System.out.println((n-(pre)) +"/"+ (cross_num - (n-pre-1))); //6-3-2 == 1
					break;
				}else { // 위쪽  아래               // 1 / cross(3 - (4-3-1)) 3    3 = 1/3 
					System.out.println((cross_num -(n-pre-1))+"/"+ (n-pre));// n == 7
					break;                   
				}                                // 4 - 0 = 4
													
			
			
			}
			else {
				pre += cross_num;// cross_num이 2가 되기전 원소갯수를 넘겨준다
				cross_num++;
			}
			
		}

	}

}
