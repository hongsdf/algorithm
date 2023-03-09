package Programmers;

public class 키패드누르기 {
	public static void main(String[] args) {
		SolutionA1 m = new SolutionA1();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String answer = m.solution(numbers, hand);
		System.out.println(answer);
		// LRLLLRLLRRL
		// LRLLLRLLRRL
	}
}
/**
 * 2차원 배열을 가지고 노는 문제
 * 핵심 num에 대한 x,y좌표를 구하는 법
 * 0-base
 * 행 좌표 := num - 1 / M(열 크기)
 * 열 좌표 := num - 1 % M(열 크기)
 * 
 * 1-base
 * 행 좌표 := num - 1 /M + 1
 * 열 좌표 := num - 1 %M + 1
 * 
 * 키패드 누르고 손 위치 이동 시켜주기
 * @author tyuz3
 *
 */
class SolutionA1 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int Left = 10; int Right = 12;
        // 왼손과 오른손의 위치를 두개다 비교
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                Left = number; // 이동
            }else if(number == 3 || number == 6 || number == 9){
                sb.append("R");
                Right = number;
            }else{
                // 2,5,8,0에 대해 손을 골라야한다.
                // 1.거리가 가까운 손
                if(Dist(Left,number) > Dist(Right,number)){
                    // 오른손을 선택
                    sb.append("R");
                    Right = number;
               // LRL LLR LLRRL     
                }else if(Dist(Left,number) < Dist(Right,number)){
                    // 왼손 선택
                    sb.append("L");
                    Left = number;
                }else{
                    // 왼손,오른손 선택
                    if(hand.equals("right")){
                        sb.append("R");
                        Right = number;
                    }else{
                        sb.append("L");
                        Left = number;
                    }
                }      
            }
            
        }
        return sb.toString();
    }
    public int Dist(int Point, int number){
        // 2차원 보드의 테크닉
        // 7 == 2,0, 5
        // n + 1 / 4; // 행 , (n + 1) % 3 + 1
        if(number == 0){
            number = 11;
        }
        if(Point == 0) {
        	Point = 11;
        }
        int Px = (Point - 1)  / 3; int Py = (Point-1)%3;
        int Nx = (number - 1) / 3; int Ny = (number-1)%3;
        int dist = Math.abs(Px-Nx) + Math.abs(Py-Ny);
        return dist;
    }
}