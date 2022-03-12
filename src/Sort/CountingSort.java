package Sort;

public class CountingSort {
	public static int temp[] = new int[30];
	public static void main(String[] args) {
		int arr[] = {1,2,1,1,1,1,3,5,3,3,4,5,30};
		for(int i=0; i<temp.length;i++) {
			temp[i] =0;
		}
		for(int a:temp) {
			System.out.print(a +" ");
		}
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			temp[arr[i] - 1]++; // 1값은 0번에 , 2값은 1번에 .. 3값은 2번에 5값은 4번에
		}
		for(int a:temp) {
			System.out.print(a +" ");
		}
		System.out.println();
		 // 한 인덱스의 값을 전부 출력하는 방법
		for(int i =0; i<temp.length; i++) { // temp 공간을 훍고
			if(temp[i] !=0) { // 0번이 아닌 temp공간이면
				for(int j =0;  j < temp[i] ; j++) { // 해당 temp[i]공간 원소 출력 이때 밑에 줄하고는 상관x, 횟수만
					System.out.print((i+1)+ " ");
				}
			}
		}
	}
}
