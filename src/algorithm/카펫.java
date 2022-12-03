package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 카펫 {
	
}

class Point1{
    int x; // 가로
    int y; //세로
    public Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class SolutionA8 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        
        // 카펫이 배치하기에 가로,세로 모두 3이상 크기이다
        // brown + yellow 의 약수 값 들 중하나이다.
        int num = brown + yellow;
        
        List<Point1> list = new ArrayList<>();
        // Math.sqrt(N) 까지만 순회하면 된다. 어차피 반대영역을 알아서 찾아준다.
        for(int i = 1; i<= (int)Math.sqrt(num); i++){
            if(num%i == 0){
                int x = num/i;
                list.add(new Point1(x,i));
            }
        }
        
        for(Point1 curr : list){
            if(curr.x >= 3 && curr.y >= 3){
                int width = curr.x-2; //가로 
                int height = curr.y-2; // 세로
                if(yellow == (width * height)){
                    answer[0] = width+2;
                    answer[1] = height+2;
                }
            }
            
        }
        
        
        // 약수 값들중 3이 상은 조합을 찾고 
        //24 = 1,2,3,4,6,8,12,24
        // (1,24) , (2,12), (3,8) , (4,6)
        // 세로 8-2 * 3-2 = 6 ==> 48 /6 == 8(가로)
        // 세로 4 -2 * 6-2 = 8==> 48/8 == 6(가로) 
        
        
        return answer;
    }
}