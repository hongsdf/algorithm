package djk;

public class djk1 {
	public static void main(String[] args) {
		int[][] arr = new int[5][2];
		arr[0][0] = 1;
		arr[0][1] = 11;
		
		arr[1][0] = 2;
		arr[1][1] = 22;
		
		arr[2][0] = 3;
		arr[2][1] = 33;
		
		arr[3][0] = 4;
		arr[3][1] = 44;
		
		arr[4][0] = 5;
		arr[4][1] = 55;
		
//		arr[6] = 1;
		
		// 불가능 hash code가 나온다
		for(int i =0; i <arr.length; i++) {
			System.out.println(arr[i]);
		
		}
		
		
		for(int i =0; i <arr.length; i++) {
			System.out.println(arr[i][0]+" "+ arr[i][1]);
		}
		// 2차원 생성방법
		int ar[][] = new int[][] {{1,11},{2,22},{3,33}};
		// 출력이 hashcode로 나옴
		System.out.println(ar[1]);
		
	}
}
