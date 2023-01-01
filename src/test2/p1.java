package test2;

import java.util.Arrays;

public class p1 {
	public static void main(String[] args) {
		SolutionP1 m = new SolutionP1();
		int arr[] = {4,1,3,2};
		boolean answer = m.solution(arr);
		System.out.println(answer);
	}
}
class SolutionP1 {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i <arr.length; i++){
            if(arr[i] != i+1){
               answer = false;
               break;
            }
        }
       

        return answer;
    }
}